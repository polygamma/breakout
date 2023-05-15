package breakout.geometry;

/**
 * This class represents a point.
 */
public class Point extends Object {

    /**
     * x-coordinate of the point.
     */
    private double x;

    /**
     * y-coordinate of the point.
     */
    private double y;

    /**
     * constructor. creates a new point.
     *
     * @param x the x-coordinate of the point.
     * @param y the y-coordinate of the point.
     */
    public Point(double x, double y) {

        this.setPoint(x, y);

    }

    /**
     * sets the coordinates of this point.
     *
     * @param x the x-coordinate of the point.
     * @param y the y-coordinate of the point.
     */
    public void setPoint(double x, double y) {

        this.setX(x);
        this.setY(y);

    }

    /**
     * return the x-coordinate of the point.
     *
     * @return the x-coordinate of the point.
     */
    public double getX() {
        return x;
    }

    /**
     * sets the x-coordinate of the point.
     *
     * @param x the x-coordinate of the point.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * returns the y-coordinate of the point.
     *
     * @return the y-coordinate of the point.
     */
    public double getY() {
        return y;
    }

    /**
     * sets the y-coordinate of the point.
     *
     * @param y the y-coordinate of the point.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * checks if the point is really a point (which is always the case).
     *
     * @return {@code true}
     */
    @Override
    public boolean isFunctionalObject() {
        return true;
    }

    /**
     * returns the bounding box of this point, which is defined to be the smallest rectangle that covers everything drawn by the figure (rectangle with width and height 0).
     *
     * @return the bounding box for this point
     */
    @Override
    public Rectangle getBounds() {

        return new Rectangle(this.getX(), this.getY(), 0, 0);

    }

}
