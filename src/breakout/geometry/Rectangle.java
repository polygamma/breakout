package breakout.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a rectangle.
 */
public class Rectangle extends Object {

    /**
     * x-coordinate of the upper left corner.
     */
    private double x;

    /**
     * y-coordinate of the upper left corner.
     */
    private double y;

    /**
     * width of the rectangle.
     */
    private double width;

    /**
     * height of the rectangle.
     */
    private double height;

    /**
     * constructor. creates a new rectangle.
     *
     * @param x      x-coordinate of the upper left corner.
     * @param y      y-coordinate of the upper left corner.
     * @param width  width of the rectangle.
     * @param height height of the rectangle.
     */
    public Rectangle(double x, double y, double width, double height) {

        this.setRectangle(x, y, width, height);

    }

    /**
     * sets the defining parameters of this rectangle.
     *
     * @param x      x-coordinate of the upper left corner.
     * @param y      y-coordinate of the upper left corner.
     * @param width  width of the rectangle.
     * @param height height of the rectangle.
     */
    public void setRectangle(double x, double y, double width, double height) {

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
     * sets the width of the rectangle.
     *
     * @param width the width of the rectangle.
     */
    public void setWidth(double width) {

        if (width < 0)
            throw new IllegalArgumentException("A rectangle with negative width doesn't make any sense.");

        this.width = width;
    }

    /**
     * returns the height of the rectangle.
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return height;
    }

    /**
     * sets the height of the rectangle.
     *
     * @param height the height of the rectangle.
     */
    public void setHeight(double height) {

        if (height < 0)
            throw new IllegalArgumentException("A rectangle with negative height doesn't make any sense.");

        this.height = height;
    }

    /**
     * Returns the edges of the rectangle.
     *
     * @return An Arraylist containing the edges of the rectangle as Lines.
     */
    public List<Line> getEdges() {

        List<Line> edges = new ArrayList<>();

        edges.add(new Line(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY()));
        edges.add(new Line(this.getX() + this.getWidth(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight()));
        edges.add(new Line(this.getX() + this.getWidth(), this.getY() + getHeight(), this.getX(), this.getY() + this.getHeight()));
        edges.add(new Line(this.getX(), this.getY() + this.getHeight(), this.getX(), this.getY()));

        return edges;

    }

    /**
     * Returns the horizontal edges of the rectangle.
     *
     * @return An Arraylist containing the horizontal edges of the rectangle as Lines.
     */
    public List<Line> getHorizontalEdges() {

        List<Line> edges = new ArrayList<>();

        edges.add(new Line(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY()));
        edges.add(new Line(this.getX() + this.getWidth(), this.getY() + getHeight(), this.getX(), this.getY() + this.getHeight()));

        return edges;

    }

    /**
     * Returns the vertical edges of the rectangle.
     *
     * @return An Arraylist containing the vertical edges of the rectangle as Lines.
     */
    public List<Line> getVerticalEdges() {

        List<Line> edges = new ArrayList<>();

        edges.add(new Line(this.getX() + this.getWidth(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight()));
        edges.add(new Line(this.getX(), this.getY() + this.getHeight(), this.getX(), this.getY()));

        return edges;

    }


    /**
     * checks if the rectangle is really a rectangle and not just a line or a point.
     *
     * @return {@code true} if the rectangle is really a rectangle and not just a line or a point, {@code false} otherwise.
     */
    @Override
    public boolean isFunctionalObject() {

        return this.getWidth() > 0 && this.getHeight() > 0;

    }

    /**
     * returns the bounds of this rectangle which is the rectangle itself.
     *
     * @return the rectangle itself.
     */
    @Override
    public Rectangle getBounds() {

        return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());

    }

}
