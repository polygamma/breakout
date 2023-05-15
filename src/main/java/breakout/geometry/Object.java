package breakout.geometry;

/**
 * This class is abstract and represents geometric objects (points, line segments, ovals and rectangles).
 * <p>
 * The coordinate system is the java user space in which the y-axis values increase downward and x-axis values increase to the right.
 */
public abstract class Object {

    /**
     * returns the bounding box of this object, which is defined to be the smallest rectangle that covers everything drawn by the figure.
     *
     * @return the bounding box for this object
     */
    public abstract Rectangle getBounds();

    /**
     * checks if the object is really the object it should be. e.g. if a line is not defined through two different points it's just a point.
     *
     * @return {@code true} if the object is really the object it should be, {@code false} otherwise.
     */
    public abstract boolean isFunctionalObject();

}
