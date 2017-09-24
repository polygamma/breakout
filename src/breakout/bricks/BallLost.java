package breakout.bricks;

import breakout.Main;
import breakout.levels.Level;

/**
 * Brick which is placed at the very bottom.
 * <p>
 * If the ball hits this brick, the ball is lost.
 */
public class BallLost extends Brick {

    /**
     * Constructor. If the ball hits this brick, the ball is lost.
     */
    public BallLost() {

        super(0, 640, 500, 10, Type.BallLost);

    }


    /**
     * This method is getting called when the brick gets hit.
     * It removes the current ball and sets a new one to the starting position.
     *
     * @param level the level which is getting played
     */
    @Override
    public void gotHit(Level level) {

        level.setBallsLeft(level.getBallsLeft() - 1);
        level.getBall().setX(250);
        level.getBall().setY(level.getPaddle().getY() - 20);
        level.getBall().setSpeedY(Math.abs(level.getBall().getSpeedY()));
        Main.getCanvas().setUserClickedToStartGame(false);

    }
}
