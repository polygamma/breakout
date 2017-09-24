package breakout.levels;

import breakout.Main;
import breakout.bricks.Brick;
import breakout.geometry.*;
import breakout.geometry.Label;
import breakout.geometry.Object;
import breakout.visuals.MainMenu;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to represent different levels of the game.
 */
public abstract class Level {

    /**
     * the ball of the level
     */
    private Ball ball;

    /**
     * the paddle of the level
     */
    private Paddle paddle;

    /**
     * the wall of the level
     */
    private Wall wall;

    /**
     * the bricks of the level
     */
    private List<Brick> bricks;

    /**
     * the tickrate of the level
     */
    private double tickRate;

    /**
     * the balls left in the level
     */
    private int ballsLeft;

    /**
     * returns if the level is still running.
     *
     * @return {@code true} if the level is still running, {@code false} otherwise.
     */
    protected boolean isGameRunning() {
        return getBallsLeft() > 0 && getBricks().size() > 1;
    }

    /**
     * starts the level.
     */
    public void play() {

        double timerStart, timerEnd, timeLeftInTick;

        Main.getCanvas().setUserClickedToStartGame(false);

        while (isGameRunning()) {

            timerStart = System.currentTimeMillis();
            if (Main.getCanvas().getUserClickedToStartGame())
                moveBall(1);
            movePaddle();
            sendGameStateToCanvas();
            timerEnd = System.currentTimeMillis();
            timeLeftInTick = 1000 / tickRate - (timerEnd - timerStart);
            if (timeLeftInTick > 0) {

                try {
                    Thread.sleep((int) timeLeftInTick);
                } catch (InterruptedException e) {
                    System.out.println("Awakened prematurely.");
                }

            }

        }

        plotWinnerOrLoser();
        MainMenu.open();

    }

    /**
     * Plots a winner or loser message!
     */
    protected void plotWinnerOrLoser() {

        Main.getCanvas().setUserClickedToStartGame(false);

        Label dummyLabel;
        List<Object> dummyArray = new ArrayList<>();

        if (getBallsLeft() == 0) {
            dummyLabel = new Label(250, 150, "Loser!");
            dummyLabel.setColor(Color.RED);
        } else {
            dummyLabel = new Label(250, 150, "Winner!");
            dummyLabel.setColor(Color.GREEN);
        }

        dummyArray.add(dummyLabel);

        Main.getCanvas().plotObjects(dummyArray);

        while (!Main.getCanvas().getUserClickedToStartGame()) {
            // JUST WAIT
        }

    }

    /**
     * moves the ball. recursion!
     *
     * @param i the time left of the tick
     * @return the time left of the tick
     */
    private double moveBall(double i) {

        List<java.lang.Object> dummyArray;
        Brick dummyBrick = null;
        double dummyTime, timeUntilCollision;
        boolean isHorizontal = true;
        List<Brick> hittableObjects = getBricks();
        List<Object> notHittableObjects = new ArrayList<>();

        notHittableObjects.add(paddle);
        notHittableObjects.add(wall);

        /*
        calculates next collision
         */
        timeUntilCollision = -1;
        for (Brick object : hittableObjects) {

            dummyArray = Collision.calcTimeUntilCollisionObjects(ball, getBall().getSpeedX() / tickRate, getBall().getSpeedY() / tickRate, object);
            dummyTime = (double) dummyArray.get(0);
            if (timeUntilCollision == -1 || (dummyTime != -1 && dummyTime < timeUntilCollision)) {
                timeUntilCollision = dummyTime;
                dummyBrick = object;
                isHorizontal = (boolean) dummyArray.get(1);
            }

        }

        for (Object object : notHittableObjects) {

            dummyArray = Collision.calcTimeUntilCollisionObjects(ball, getBall().getSpeedX() / tickRate, getBall().getSpeedY() / tickRate, object);
            dummyTime = (double) dummyArray.get(0);
            if (timeUntilCollision == -1 || (dummyTime != -1 && dummyTime < timeUntilCollision)) {
                timeUntilCollision = dummyTime;
                dummyBrick = null;
                isHorizontal = (boolean) dummyArray.get(1);
            }

        }

        /*
        handles the next collision
         */
        if (timeUntilCollision == -1) {

            ball.setX(ball.getX() + i * getBall().getSpeedX() / tickRate);
            ball.setY(ball.getY() + i * getBall().getSpeedY() / tickRate);
            return -1;

        } else if (timeUntilCollision <= i) {

            ball.setX(ball.getX() + timeUntilCollision * getBall().getSpeedX() / tickRate - 0.01 * Math.signum(getBall().getSpeedX()));
            ball.setY(ball.getY() + timeUntilCollision * getBall().getSpeedY() / tickRate - 0.01 * Math.signum(getBall().getSpeedY()));

            if (dummyBrick != null) {

                dummyBrick.gotHit(this);

            }

            if (isHorizontal) {
                getBall().setSpeedY(-getBall().getSpeedY());
            } else {
                getBall().setSpeedX(-getBall().getSpeedX());
            }

            return moveBall(i - timeUntilCollision);

        } else {

            ball.setX(ball.getX() + i * getBall().getSpeedX() / tickRate);
            ball.setY(ball.getY() + i * getBall().getSpeedY() / tickRate);
            return -1;

        }

    }

    /**
     * Returns the balls left as label.
     *
     * @return the balls left as label.
     */
    protected Label ballsLeftAsLabel() {

        return new Label(10, 575, "Balls left: " + String.valueOf(getBallsLeft()));

    }

    /**
     * sends the current game state to the canvas.
     */
    private void sendGameStateToCanvas() {

        List<Object> objects = new ArrayList<>();

        objects.add(wall);
        objects.add(paddle);
        objects.add(ball);
        for (Object object : getBricks()) {
            objects.add(object);
        }
        objects.add(ballsLeftAsLabel());
        Main.getCanvas().plotObjects(objects);

    }

    /**
     * moves the paddle
     */
    private void movePaddle() {

        Point dummyPoint, dummyPoint2;

        dummyPoint = MouseInfo.getPointerInfo().getLocation();
        try {
            dummyPoint2 = Main.getCanvas().getGCanvas().getLocationOnScreen();
        } catch (IllegalComponentStateException e) {
            dummyPoint2 = null;
        }
        if ((dummyPoint != null && dummyPoint2 != null)
                && !(new Rectangle2D.Double(dummyPoint.getX() - dummyPoint2.getX() - this.getPaddle().getWidth() / 2, this.getPaddle().getY(), this.getPaddle().getWidth(), this.getPaddle().getHeight()).intersects(new Rectangle2D.Double(this.getBall().getBounds().getX(), this.getBall().getBounds().getY(), this.getBall().getBounds().getWidth(), this.getBall().getBounds().getHeight())))) {

            if (dummyPoint.getX() - dummyPoint2.getX() <= this.getPaddle().getWidth() / 2) {

                this.getPaddle().setX(0);

            } else if (dummyPoint.getX() - dummyPoint2.getX() >= 500 - this.getPaddle().getWidth() / 2) {

                this.getPaddle().setX(500 - this.getPaddle().getWidth());

            } else {

                this.getPaddle().setX(dummyPoint.getX() - dummyPoint2.getX() - this.getPaddle().getWidth() / 2);
            }
        }

    }


    /**
     * returns the ball of the level
     *
     * @return the ball of the level
     */
    public Ball getBall() {
        return ball;
    }

    /**
     * sets the ball of the level
     *
     * @param ball the ball of the level
     */
    public void setBall(Ball ball) {
        this.ball = ball;
    }

    /**
     * gets the paddle of the level
     *
     * @return the paddle of the level
     */
    public Paddle getPaddle() {
        return paddle;
    }

    /**
     * sets the paddle of the level
     *
     * @param paddle the paddle of the level
     */
    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    /**
     * gets the wall of the level
     *
     * @return the wall of the level
     */
    public Wall getWall() {
        return wall;
    }

    /**
     * sets the wall of the level
     *
     * @param wall the wall of the level
     */
    public void setWall(Wall wall) {
        this.wall = wall;
    }

    /**
     * gets the bricks of the level
     *
     * @return the bricks of the level
     */
    public List<Brick> getBricks() {
        return bricks;
    }

    /**
     * sets the bricks of the level
     *
     * @param bricks the bricks of the level
     */
    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    /**
     * gets the tick rate of the level
     *
     * @return the tick rate of the level
     */
    public double getTickRate() {
        return tickRate;
    }

    /**
     * sets the tick rate of the level
     *
     * @param tickRate the tick rate of the level
     */
    public void setTickRate(double tickRate) {
        this.tickRate = tickRate;
    }

    /**
     * returns the balls left of the level
     *
     * @return the balls left of the level
     */
    public int getBallsLeft() {
        return ballsLeft;
    }

    /**
     * sets the balls left of the level
     *
     * @param ballsLeft the balls left of the level
     */
    public void setBallsLeft(int ballsLeft) {
        this.ballsLeft = ballsLeft;
    }

}
