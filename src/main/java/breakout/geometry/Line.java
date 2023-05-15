package breakout.geometry;

/**
 * This class represents a line segment.
 */
public class Line extends Object {

    /**
     * the x-coordinate of the startpoint.
     */
    private double x1;

    /**
     * the y-coordinate of the startpoint.
     */
    private double y1;

    /**
     * the x-coordinate of the endpoint.
     */
    private double x2;

    /**
     * the y-coordinate of the endpoint.
     */
    private double y2;

    /**
     * constructor. creates a new line segment.
     *
     * @param x1 the x-coordinate of the startpoint.
     * @param y1 the y-coordinate of the startpoint.
     * @param x2 the x-coordinate of the endpoint.
     * @param y2 the y-coordinate of the endpoint.
     */
    public Line(double x1, double y1, double x2, double y2) {

        this.setLine(x1, y1, x2, y2);

    }

    /**
     * returns the length of the line segment.
     *
     * @return the length of the line segment.
     */
    public static double getLength(Line line) {

        return Math.sqrt(Math.pow(line.getX1() - line.getX2(), 2) + Math.pow(line.getY1() - line.getY2(), 2));

    }

    /**
     * calculates the intersection point between two line segments.
     *
     * @param line1 the first line segment
     * @param line2 the second line segment
     * @return the Point of intersection if there is exactly one intersection point, {@code null} otherwise.
     */
    public static Point getLineSegmentsIntersectionPoint(Line line1, Line line2) {

        if (!line1.isFunctionalObject() || !line2.isFunctionalObject())
            throw new IllegalArgumentException("One of the line segments is not a line segment but just a point.");

        double lambda1, lambda2;

        double line1StartingVectorX = line1.getStartPoint().getX();
        double line1StartingVectorY = line1.getStartPoint().getY();

        double line2StartingVectorX = line2.getStartPoint().getX();
        double line2StartingVectorY = line2.getStartPoint().getY();

        double line1DirectionVectorX = line1.getEndPoint().getX() - line1StartingVectorX;
        double line1DirectionVectorY = line1.getEndPoint().getY() - line1StartingVectorY;

        double line2DirectionVectorX = line2.getEndPoint().getX() - line2StartingVectorX;
        double line2DirectionVectorY = line2.getEndPoint().getY() - line2StartingVectorY;

        /*
        Check for linear dependence of the direction vectors.
        If the direction vectors are linear dependent we can just return null,
        since it is not possible that there is just one intersection point.
         */
        double d = line1DirectionVectorY * line2DirectionVectorX - line2DirectionVectorY * line1DirectionVectorX;
        if (d == 0)
            return null;

        /*
        Calculate the lambda of the intersection point for the line segments
         */
        lambda2 = (line1DirectionVectorX * (line2StartingVectorY - line1StartingVectorY) - line1DirectionVectorY * (line2StartingVectorX - line1StartingVectorX)) / d;

        if (line1DirectionVectorX != 0) {

            lambda1 = (line2StartingVectorX + lambda2 * line2DirectionVectorX - line1StartingVectorX) / line1DirectionVectorX;

        } else {

            /*
            we have line segments, not just points, hence one of the direction vectors is not zero.
             */
            assert line1DirectionVectorY != 0 : line1DirectionVectorY;

            lambda1 = (line2StartingVectorY + lambda2 * line2DirectionVectorY - line1StartingVectorY) / line1DirectionVectorY;

        }

        /*
        if both lambdas are in between 0 and 1, the intersection point is on both line segments.
         */
        if (0 <= lambda1 && lambda1 <= 1 && 0 <= lambda2 && lambda2 <= 1)
            return new Point(line1StartingVectorX + lambda1 * line1DirectionVectorX, line1StartingVectorY + lambda1 * line1DirectionVectorY);

        else
            return null;

    }

    /**
     * calculates the intersection point between this line segment and another line segment.
     *
     * @param line the other line segment.
     * @return the Point of intersection if there is exactly one intersection point, {@code null} otherwise.
     */
    public Point getLineSegmentsIntersectionPoint(Line line) {

        return getLineSegmentsIntersectionPoint(this, line);

    }

    /**
     * sets the parameters of the line segment.
     *
     * @param x1 the x-coordinate of the startpoint.
     * @param y1 the y-coordinate of the startpoint.
     * @param x2 the x-coordinate of the endpoint.
     * @param y2 the y-coordinate of the endpoint.
     */
    public void setLine(double x1, double y1, double x2, double y2) {

        this.setX1(x1);
        this.setY1(y1);
        this.setX2(x2);
        this.setY2(y2);

    }

    /**
     * returns the startpoint of the line segment.
     *
     * @return the startpoint of the line segment.
     */
    public Point getStartPoint() {

        return new Point(this.getX1(), this.getY1());

    }

    /**
     * returns the endpoint of the line segment.
     *
     * @return the endpoint of the line segment.
     */
    public Point getEndPoint() {

        return new Point(this.getX2(), this.getY2());

    }

    /**
     * returns the x-coordinate of the startpoint.
     *
     * @return the x-coordinate of the startpoint.
     */
    public double getX1() {
        return x1;
    }

    /**
     * sets the x-coordinate of the startpoint.
     *
     * @param x1 the x-coordinate of the startpoint.
     */
    public void setX1(double x1) {
        this.x1 = x1;
    }

    /**
     * returns the y-coordinate of the startpoint.
     *
     * @return the y-coordinate of the startpoint.
     */
    public double getY1() {
        return y1;
    }

    /**
     * sets the x-coordinate of the startpoint.
     *
     * @param y1 the y-coordinate of the startpoint.
     */
    public void setY1(double y1) {
        this.y1 = y1;
    }

    /**
     * returns the x-coordinate of the endpoint.
     *
     * @return the x-coordinate of the endpoint.
     */
    public double getX2() {
        return x2;
    }

    /**
     * sets the x-coordinate of the endpoint.
     *
     * @param x2 the x-coordinate of the endpoint.
     */
    public void setX2(double x2) {
        this.x2 = x2;
    }

    /**
     * returns the y-coordinate of the endpoint.
     *
     * @return the y-coordinate of the endpoint
     */
    public double getY2() {
        return y2;
    }

    /**
     * sets the y-coordinate of the endpoint
     *
     * @param y2 the y-coordinate of the endpoint
     */
    public void setY2(double y2) {
        this.y2 = y2;
    }

    /**
     * returns the length of the line segment.
     *
     * @return the length of the line segment.
     */
    public double getLength() {

        return getLength(this);

    }

    /**
     * checks if the line is really a line and not just a point
     *
     * @return {@code true} if the line is not just a point, {@code false} otherwise
     */
    @Override
    public boolean isFunctionalObject() {

        return this.getX1() - this.getX2() != 0 || this.getY1() - this.getY2() != 0;

    }

    /**
     * returns the bounding box of this line, which is defined to be the smallest rectangle that covers everything drawn by the figure.
     *
     * @return the bounding box for this line
     */
    @Override
    public Rectangle getBounds() {

        double upperLeftCornerX = Math.min(this.getX1(), this.getX2());
        double upperLeftCornerY = Math.min(this.getY1(), this.getY2());

        return new Rectangle(upperLeftCornerX, upperLeftCornerY, Math.abs(this.getX1() - this.getX2()), Math.abs(this.getY1() - this.getY2()));

    }

}
