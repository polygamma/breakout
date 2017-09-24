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
 * In this level all lights have to be enlighted to win
 *
 * @author Helge
 */
public class Level2 extends Level {

    //Three Lights are creaed
    private Light L1 = new Light(80, 85);
    private Light L2 = new Light(380, 85);
    private Light L3 = new Light(230, 85);

    /**
     * Constructor for the Level
     */
    public Level2() {

        //Ball for the Level
        this.setBall(new Ball(250, 510, 10, 10, 300, -400, Ball.Type.Level1));

        //Paddle for the Level
        this.setPaddle(new Paddle(100, 530, 80, 10, Paddle.Type.Level1));

        //Background for the Level
        this.setWall(new Wall(Wall.Type.Level2));

        //Game tries and speed are set here
        this.setBallsLeft(3);
        this.setTickRate(60);

        //In this list all bricks are saved
        List<Brick> bricks = new ArrayList<>();

        bricks.add(new BallLost());

        //Create Bricks
        for (int i = 0; i < 12; i++) {
            bricks.add(new Neon(10 + i * 40, 145));
        }

        for (int i = 0; i < 3; i++) {
            bricks.add(new Gold(80 + i * 150, 70));
        }

        for (int i = 0; i < 5; i++) {
            bricks.add(new Metal(160 + i * 40, 220));
            bricks.add(new Neon(160 + i * 40, 220));
        }

        //Add lights
        bricks.add(L1);
        bricks.add(L2);
        bricks.add(L3);

        this.setBricks(bricks);
    }

    @Override
    protected void plotWinnerOrLoser() {

        Main.getCanvas().setUserClickedToStartGame(false);

        Label dummyLabel;
        List<Object> dummyArray = new ArrayList<>();

        if (getBallsLeft() == 0) {
            dummyLabel = new Label(100, 150, "I have not failed,");
            dummyArray.add(dummyLabel);
            dummyLabel = new Label(100, 170, "I've just found 10,000 ways that won't work.");
            dummyArray.add(dummyLabel);
            dummyLabel = new Label(230, 210, "-Thomas Edison");
            dummyArray.add(dummyLabel);
        } else {
            dummyArray.add(new Wall(Wall.Type.winner2));
            dummyLabel = new Label(30, 380, "You most likely feel enlightened now");
            dummyLabel.setColor(Color.GREEN);
            dummyArray.add(dummyLabel);
            dummyLabel = new Label(80, 400, "Congratulations!");
            dummyLabel.setColor(Color.GREEN);
            dummyArray.add(dummyLabel);
        }

        Main.getCanvas().plotObjects(dummyArray);

        while (!Main.getCanvas().getUserClickedToStartGame()) {
            // JUST WAIT
        }
    }

    /**
     * Overrides the isGameRunning method
     * All Lights have to be on to win this Level
     */
    @Override
    protected boolean isGameRunning() {
        return ((L1.isOn() && L2.isOn() && L3.isOn()) != true) && getBallsLeft() > 0;
    }

}
