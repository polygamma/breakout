package breakout.geometry;

/**
 * This class represents an oval.
 */
public class Oval extends Object {

    /**
     * x-coordinate of the upper left corner.
     */
    private double x;

    /**
     * y-coordinate of the upper left corner.
     */
    private double y;

    /**
     * width of the oval.
     */
    private double width;

    /**
     * height of the oval.
     */
    private double height;

    /**
     * constructor. creates a new oval.
     *
     * @param x      x-coordinate of the upper left corner.
     * @param y      y-coordinate of the upper left corner.
     * @param width  width of the oval.
     * @param height height of the oval.
     */
    public Oval(double x, double y, double width, double height) {

        this.setOval(x, y, width, height);

    }

    /**
     * sets the defining parameters of this oval.
     *
     * @param x      x-coordinate of the upper left corner.
     * @param y      y-coordinate of the upper left corner.
     * @param width  width of the oval.
     * @param height height of the oval.
     */
    public void setOval(double x, double y, double width, double height) {

        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);

    }

    /**
     * returns the x-coordinate of the upper left corner.
     *
     * @return the x-coordinate of the upper left corner.
     */
    public double getX() {
        return x;
    }

    /**
     * sets the x-coordinate of the upper left corner.
     *
     * @param x the x-coordinate of the upper left corner.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * returns the y-coordinate of the upper left corner.
     *
     * @return the y-coordinate of the upper left corner.
     */
    public double getY() {
        return y;
    }

    /**
     * sets the y-coordinate of the upper left corner.
     *
     * @param y the y-coordinate of the upper left corner.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * returns the width of the rectangle.
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * sets the width of the oval.
     *
     * @param width the width of the oval.
     */
    public void setWidth(double width) {

        if (width < 0)
            throw new IllegalArgumentException("An oval with negative width doesn't make any sense.");

        this.width = width;
    }

    /**
     * returns the height of the oval.
     *
     * @return the height of the oval.
     */
    public double getHeight() {
        return height;
    }

    /**
     * sets the height of the oval.
     *
     * @param height the height of the oval.
     */
    public void setHeight(double height) {

        if (height < 0)
            throw new IllegalArgumentException("An oval with negative height doesn't make any sense.");

        this.height = height;
    }

    /**
     * checks if the oval is really an oval.
     *
     * @return {@code true} if the oval is really an oval, {@code false} otherwise.
     */
    @Override
    public boolean isFunctionalObject() {

        return this.getWidth() > 0 && this.getHeight() > 0;

    }

    /**
     * returns the bounds of this oval.
     *
     * @return the bounding box of the oval.
     */
    @Override
    public Rectangle getBounds() {

        return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());

    }

}
