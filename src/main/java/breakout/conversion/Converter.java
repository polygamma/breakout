package breakout.conversion;

import acm.graphics.*;
import breakout.Main;
import breakout.bricks.Brick;
import breakout.geometry.*;
import breakout.geometry.Label;
import breakout.geometry.Object;
import breakout.geometry.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to convert our own geometric objects to GObjects.
 */
public class Converter {

    /**
     * no construction allowed.
     */
    private Converter() {

    }

    /**
     * Converts our own geometric objects to GObjects.
     *
     * @param ourObjects a list containing our geometric objects.
     * @return a list containing the GObjects.
     */
    public static List<GObject> convertToGObjects(List<Object> ourObjects) {

        List<GObject> gObjects = new ArrayList<>();
        Line dummyLine;
        Oval dummyOval;
        Rectangle dummyRectangle;
        GCompound dummyCompound;
        Image dummyImage;
        Brick dummyBrick;
        Ball dummyBall;
        Paddle dummyPaddle;
        Wall dummyWall;
        Label dummyLabel;
        GLabel dummyGLabel;

        for (Object object : ourObjects) {


            if (object instanceof Brick || object instanceof Ball || object instanceof Paddle || object instanceof Wall) {

                dummyImage = null;

                if (object instanceof Brick) {

                    dummyBrick = (Brick) object;

                    // changing starts here

                    if (dummyBrick.getType() == Brick.Type.Gold)
                        dummyImage = getImage("breakout/pictures/GoldBlock.png");

                    if (dummyBrick.getType() == Brick.Type.Silver)
                        dummyImage = getImage("breakout/pictures/SilverBlock.png");

                    if (dummyBrick.getType() == Brick.Type.Bronze)
                        dummyImage = getImage("breakout/pictures/BronzeBlock.png");

                    if (dummyBrick.getType() == Brick.Type.Neon)
                        dummyImage = getImage("breakout/pictures/NeonBlock.png");

                    if (dummyBrick.getType() == Brick.Type.Metal)
                        dummyImage = getImage("breakout/pictures/MetalBlock.png");

                    if (dummyBrick.getType() == Brick.Type.LightOff)
                        dummyImage = getImage("breakout/pictures/LightOff.png");

                    if (dummyBrick.getType() == Brick.Type.LightOn)
                        dummyImage = getImage("breakout/pictures/LightOn.png");

                    // changing ends here

                } else if (object instanceof Ball) {

                    dummyBall = (Ball) object;

                    // changing starts here

                    if (dummyBall.getType() == Ball.Type.Level1)
                        dummyImage = getImage("breakout/pictures/LaserBall.png");

                    // changing ends here

                } else if (object instanceof Paddle) {

                    dummyPaddle = (Paddle) object;

                    // changing starts here

                    if (dummyPaddle.getType() == Paddle.Type.Level1)
                        dummyImage = getImage("breakout/pictures/paddle.png");

                    // changing ends here

                } else {

                    dummyWall = (Wall) object;

                    // changing starts here

                    if (dummyWall.getType() == Wall.Type.Level1)
                        dummyImage = getImage("breakout/pictures/BackGround1.jpg");

                    if (dummyWall.getType() == Wall.Type.Level2)
                        dummyImage = getImage("breakout/pictures/BackGround2.jpg");

                    if (dummyWall.getType() == Wall.Type.Level3)
                        dummyImage = getImage("breakout/pictures/BackGround3.jpg");

                    if (dummyWall.getType() == Wall.Type.winner3)
                        dummyImage = getImage("breakout/pictures/back-05.gif");

                    if (dummyWall.getType() == Wall.Type.winner2)
                        dummyImage = getImage("breakout/pictures/back-03.gif");

                    if (dummyWall.getType() == Wall.Type.winner1)
                        dummyImage = getImage("breakout/pictures/back-01.gif");

                    // changing ends here

                }

                if (dummyImage != null) {

                    dummyCompound = new GCompound();
                    dummyCompound.add(new GImage(dummyImage));
                    dummyCompound.setLocation(object.getBounds().getX(), object.getBounds().getY());
                    gObjects.add(dummyCompound);

                }

            } else if (object instanceof Line) {

                dummyLine = (Line) object;
                gObjects.add(new GLine(dummyLine.getX1(), dummyLine.getY1(), dummyLine.getX2(), dummyLine.getY2()));

            } else if (object instanceof Oval) {

                dummyOval = (Oval) object;
                gObjects.add(new GOval(dummyOval.getX(), dummyOval.getY(), dummyOval.getWidth(), dummyOval.getHeight()));

            } else if (object instanceof Rectangle) {

                dummyRectangle = (Rectangle) object;
                gObjects.add(new GRect(dummyRectangle.getX(), dummyRectangle.getY(), dummyRectangle.getWidth(), dummyRectangle.getHeight()));

            } else if (object instanceof Label) {

                dummyLabel = (Label) object;
                dummyGLabel = new GLabel(dummyLabel.getString(), dummyLabel.getX(), dummyLabel.getY());
                dummyGLabel.setFont(dummyLabel.getFont());
                dummyGLabel.setColor(dummyLabel.getColor());
                gObjects.add(dummyGLabel);

            }

        }

        return gObjects;

    }

    /**
     * returns the image at the specific path
     *
     * @param pathToImage path to the image
     * @return the image or {@code null} if the path is invalid
     */
    private static Image getImage(String pathToImage) {

        return new ImageIcon(Main.getCanvas().getClass().getClassLoader().getResource(pathToImage)).getImage();

    }

}
