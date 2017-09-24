package breakout.geometry;

import java.awt.*;

/**
 * This class is used to represent own labels.
 */
public class Label extends Object {

    /**
     * x-coordinate of the baseline.
     */
    private double x;

    /**
     * y-coordinate of the baseline.
     */
    private double y;

    /**
     * font of the label.
     */
    private Font font = new Font("Serif", Font.BOLD, 18);

    /**
     * string of the label.
     */
    private String string;

    /**
     * color of the label.
     */
    private Color color = Color.RED;

    /**
     * constructor.
     *
     * @param x      x-coordinate of the baseline.
     * @param y      y-coordinate of the baseline.
     * @param string string of the label.
     */
    public Label(double x, double y, String string) {

        this.x = x;

        this.y = y;

        this.string = string;

    }

    /**
     * returns the color of the label.
     *
     * @return the color of the label.
     */
    public Color getColor() {
        return color;
    }

    /**
     * sets the color of the label.
     *
     * @param color the color of the label.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * returns the x-coordinate of the baseline.
     *
     * @return the x-coordinate of the baseline.
     */
    public double getX() {
        return x;
    }

    /**
     * sets the x-coordinate of the baseline.
     *
     * @param x the x-coordinate of the baseline.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * returns the y-coordinate of the baseline.
     *
     * @return the y-coordinate of the baseline.
     */
    public double getY() {
        return y;
    }

    /**
     * sets the y-coordinate of the baseline.
     *
     * @param y the y-coordinate of the baseline.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * returns the font of the label.
     *
     * @return the font of the label.
     */
    public Font getFont() {
        return font;
    }

    /**
     * sets the font of the label.
     *
     * @param font the of the label.
     */
    public void setFont(Font font) {
        this.font = font;
    }

    /**
     * gets the string of the label.
     *
     * @return the string of the label.
     */
    public String getString() {
        return string;
    }

    /**
     * sets the string of the label.
     *
     * @param string the string of the label.
     */
    public void setString(String string) {
        this.string = string;
    }

    /**
     * Labels are always functional.
     *
     * @return {@code true}
     */
    @Override
    public boolean isFunctionalObject() {
        return true;
    }

    /**
     * Not able to calculate the correct bounds. Sorry, but we don't need this.
     *
     * @return {@code null}
     */
    @Override
    public Rectangle getBounds() {

        return null;

    }

}
