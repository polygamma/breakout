package breakout.visuals;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import breakout.Main;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is part of the model and used to create the main menu of the game.
 * <p>
 * We are only using GObjects here since we need the MouseListeners for the buttons.
 */
public class MainMenu {

    /**
     * no construction allowed.
     */
    private MainMenu() {

    }

    /**
     * opens the main menu through creating it and sending it to the canvas.
     */
    public static void open() {

        GRect dummyRectangle;

        List<GObject> objects = new ArrayList<>();

        /*
        background image
         */

        GImage bg = new GImage(new ImageIcon(Main.getCanvas().getClass().getClassLoader().getResource("breakout/pictures/MainMenu.jpg")).getImage());
        objects.add(bg);
        
        /*
        exit button
         */
        dummyRectangle = new GRect(200, 515, 115, 50);
        dummyRectangle.setVisible(false);
        dummyRectangle.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                Main.setStateOfProgram(-1);

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

        objects.add(dummyRectangle);

        /*
        Level 1
         */
        dummyRectangle = new GRect(73, 230, 75, 75);
        dummyRectangle.setVisible(false);
        dummyRectangle.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                Main.setStateOfProgram(1);

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

        objects.add(dummyRectangle);

        /*
        Level 2
         */
        dummyRectangle = new GRect(215, 230, 75, 75);
        dummyRectangle.setVisible(false);
        dummyRectangle.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                Main.setStateOfProgram(2);

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

        objects.add(dummyRectangle);

        /*
        Level 3
         */
        dummyRectangle = new GRect(355, 230, 75, 75);
        dummyRectangle.setVisible(false);
        dummyRectangle.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                Main.setStateOfProgram(3);

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

        objects.add(dummyRectangle);

        objects.add(new GLabel("Aim for the top!", 260, 150));


        Main.getCanvas().plotGObjects(objects);

    }

}
