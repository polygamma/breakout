package breakout.visuals;

import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import breakout.conversion.Converter;
import breakout.geometry.Object;

import java.awt.event.MouseEvent;
import java.util.List;

/**
 * This class is the canvas on which everything gets drawn. It's also the last part of the view.
 */
public class Canvas extends GraphicsProgram {

    /**
     * boolean used for pausing the game in some situations.
     */
    private volatile boolean userClickedToStartGame = true;

    /**
     * returns the boolean used for pausing the game in some situations.
     *
     * @return the boolean used for pausing the game in some situations.
     */
    public boolean getUserClickedToStartGame() {
        return userClickedToStartGame;
    }

    /**
     * sets the boolean used for pausing the game in some situations.
     *
     * @param userClickedToStartGame the boolean used for pausing the game in some situations.
     */
    public void setUserClickedToStartGame(boolean userClickedToStartGame) {
        this.userClickedToStartGame = userClickedToStartGame;
    }

    /**
     * initialization of the canvas.
     */
    public void init() {

        setSize(500, 650);
        addMouseListeners();
        validate();

    }

    /**
     * just sets the boolean used for pausing the game to {@code true}.
     *
     * @param e not used
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        this.userClickedToStartGame = true;

    }

    /**
     * this method gets our own geometric objects, converts them to GObjects and draws them on the canvas.
     *
     * @param objects a list with our own objects.
     */
    public void plotObjects(List<Object> objects) {

        plotGObjects(Converter.convertToGObjects(objects));

    }

    /**
     * this method is called when the canvas has to plot objects.
     *
     * @param objects a list with the GObjects the canvas has to plot.
     */
    public void plotGObjects(List<GObject> objects) {

        removeAll();
        for (GObject object : objects) {
            add(object);
        }
        validate();

    }

}
