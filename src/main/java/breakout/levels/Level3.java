package breakout.levels;

import breakout.Main;
import breakout.bricks.*;
import breakout.geometry.*;
import breakout.geometry.Object;

import java.util.ArrayList;
import java.util.List;

public class Level3 extends Level {

    private Light L1 = new Light(230, 20);

    public Level3() {

        this.setBall(new Ball(250, 510, 10, 10, 300, -400, Ball.Type.Level1));
        this.setPaddle(new Paddle(100, 530, 80, 10, Paddle.Type.Level1));
        this.setWall(new Wall(Wall.Type.Level3));

        this.setBallsLeft(3);
        this.setTickRate(60);

        List<Brick> bricks = new ArrayList<>();

        bricks.add(new BallLost());

        // Create bricks
        bricks.add(new Neon(210, 20));
        bricks.add(new Neon(190, 80));
        bricks.add(new Neon(270, 80));
        bricks.add(new Neon(250, 20));

        bricks.add(L1);

        for (int i = 0; i < 2; i++) {
            bricks.add(new Gold(210 + 40 * i, 35));
            bricks.add(new Silver(210 + 40 * i, 50));
            bricks.add(new Gold(210 + 40 * i, 65));
        }

        for (int n = 0; n < 10; n++) {
            bricks.add(new Silver(230, 80 + 15 * n));
        }

        for (int n = 0; n < 3; n++) {
            bricks.add(new Gold(190 + 40 * n, 230));
            bricks.add(new Silver(190 + 40 * n, 245));
            bricks.add(new Silver(190 + 40 * n, 260));
            bricks.add(new Gold(190 + 40 * n, 275));
        }

        bricks.add(new Metal(210, 290));
        bricks.add(new Metal(250, 290));
        bricks.add(new Metal(210, 95));
        bricks.add(new Metal(250, 95));
        bricks.add(new Gold(210, 5));
        bricks.add(new Gold(250, 5));

        this.setBricks(bricks);
    }

    @Override
    protected void plotWinnerOrLoser() {

        Main.getCanvas().setUserClickedToStartGame(false);

        Label dummyLabel;
        List<Object> dummyArray = new ArrayList<>();

        if (getBallsLeft() == 0) {
            dummyLabel = new Label(150, 150, "The higher the tower,");
            dummyArray.add(dummyLabel);
            dummyLabel = new Label(150, 170, "the greater the fall there off.");
            dummyArray.add(dummyLabel);
            dummyLabel = new Label(280, 210, "-Horace");
            dummyArray.add(dummyLabel);
        } else {
            dummyArray.add(new Wall(Wall.Type.winner3));
            dummyLabel = new Label(160, 100, "You've reached the top!");
            dummyArray.add(dummyLabel);
            dummyLabel = new Label(180, 120, "Congratulations!");
            dummyArray.add(dummyLabel);
        }

        Main.getCanvas().plotObjects(dummyArray);

        while (!Main.getCanvas().getUserClickedToStartGame()) {
            // JUST WAIT
        }
    }

    @Override
    protected boolean isGameRunning() {
        return L1.isOn() != true && getBallsLeft() > 0;
    }
}
