package breakout.levels;

import breakout.Main;
import breakout.bricks.*;
import breakout.geometry.*;
import breakout.geometry.Label;
import breakout.geometry.Object;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A classic breakout level with different brick types
 *
 * @author Helge
 */
public class Level1 extends Level {

    /**
     * Constructor for the Level-
     * Adds the Objects to the Canvas
     */
    public Level1() {

        //Ball for the level
        this.setBall(new Ball(250, 510, 10, 10, 300, -400, Ball.Type.Level1));

        //Paddle for the level
        this.setPaddle(new Paddle(100, 530, 80, 10, Paddle.Type.Level1));

        //Background for the level
        this.setWall(new Wall(Wall.Type.Level1));

        //Game tries and speed are set here
        this.setBallsLeft(3);
        this.setTickRate(60);

        //In this list all bricks are saved
        List<Brick> bricks = new ArrayList<>();

        bricks.add(new BallLost());

        // Create bricks
        for (int i = 0; i < 8; i++) {
            bricks.add(new Gold(50 + 50 * i, 30));
            bricks.add(new Silver(50 + 50 * i, 60));
        }

        for (int i = 0; i < 9; i++) {
            bricks.add(new Metal(25 + 50 * i, 15));
            bricks.add(new Metal(25 + 50 * i, 45));
            bricks.add(new Metal(25 + 50 * i, 75));

        }

        this.setBricks(bricks);

    }

    @Override
    protected void plotWinnerOrLoser() {

        Main.getCanvas().setUserClickedToStartGame(false);

        Label dummyLabel;
        List<Object> dummyArray = new ArrayList<>();

        if (getBallsLeft() == 0) {
            dummyLabel = new Label(100, 150, "Failure is the opportunity");
            dummyArray.add(dummyLabel);
            dummyLabel = new Label(100, 170, "to begin again more intelligently.");
            dummyArray.add(dummyLabel);
            dummyLabel = new Label(230, 210, "-Henry Ford");
            dummyArray.add(dummyLabel);
        } else {
            dummyArray.add(new Wall(Wall.Type.winner1));
            dummyLabel = new Label(90, 180, "You did it!");
            dummyLabel.setColor(Color.GREEN);
            dummyArray.add(dummyLabel);
            dummyLabel = new Label(80, 200, "Congratulations!");
            dummyLabel.setColor(Color.GREEN);
            dummyArray.add(dummyLabel);
        }

        Main.getCanvas().plotObjects(dummyArray);

        while (!Main.getCanvas().getUserClickedToStartGame()) {
            // JUST WAIT
        }
    }
}
