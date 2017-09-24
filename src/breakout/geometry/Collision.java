package breakout.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used for collision calculations.
 */
public class Collision {

    /**
     * no construction allowed.
     */
    private Collision() {

    }

    /**
     * Calculates the time until collision between a moving Object and a static completely horizontal or vertical Line if they collide during one tick.
     *
     * @param movingObject the moving Object
     * @param speedX       the speed of the moving object in x-direction in pixel/tick
     * @param speedY       the speed of the moving object in y-direction in pixel/tick
     * @param staticLine   the static completely horizontal or vertical Line
     * @return the time until the two objects collide, if they collide during one tick. {@code -1} otherwise. Will also return {@code -1} if the objects are already colliding.
     */
    private static double calcTimeUntilCollisionObjectLineSegment(Object movingObject, double speedX, double speedY, Line staticLine) {

        assert speedX != 0 || speedY != 0 : "Moving object should be moving";
        assert movingObject.isFunctionalObject() && staticLine.isFunctionalObject() : "What are those? :( Not the objects I was waiting for.";

        /*
        true if the line is horizontal, false otherwise
         */
        boolean isLineHorizontal = (staticLine.getEndPoint().getX() - staticLine.getStartPoint().getX()) != 0;

                /*
        will contain the relevant lines of the GObject to calculate the next collision
         */
        List<Line> linesOfMovingObject;

        if (isLineHorizontal)
            linesOfMovingObject = movingObject.getBounds().getHorizontalEdges();
        else
            linesOfMovingObject = movingObject.getBounds().getVerticalEdges();

        double timeUntilCollision = -1;
        double dummyTime;

        /*
        calculates time until next collision
         */
        for (Line lineOfMovingObject : linesOfMovingObject) {

            dummyTime = calcTimeUntilCollisionLineSegments(lineOfMovingObject, speedX, speedY, staticLine);
            if (timeUntilCollision == -1 || (dummyTime != -1 && dummyTime < timeUntilCollision))
                timeUntilCollision = dummyTime;

        }

        return timeUntilCollision;

    }

    /**
     * Calculates the time until collision between a moving completely horizontal or vertical Line and a static completely horizontal or vertical Line if they collide during one tick.
     * Both line segments are either horizontal or vertical.
     *
     * @param movingLine the moving line
     * @param speedX     the speed of the moving line in x-direction in pixel/tick
     * @param speedY     the speed of the moving line in y-direction in pixel/tick
     * @param staticLine the static line
     * @return the time until the lines collide if they collide during one tick. {@code -1} otherwise. will also return {@code -1} if the lines are already colliding.
     */
    private static double calcTimeUntilCollisionLineSegments(Line movingLine, double speedX, double speedY, Line staticLine) {

        assert speedX != 0 || speedY != 0 : "Moving line should be moving";
        assert movingLine.isFunctionalObject() && staticLine.isFunctionalObject() : "One line is just a point.";


        Point collisionPoint1, collisionPoint2;
        double distance1, distance2;
        double lengthOfLineOfMovingLine = movingLine.getLength();
        double lengthOfStaticLine = staticLine.getLength();
        double distancePerTick = Math.sqrt(Math.pow(speedX, 2) + Math.pow(speedY, 2));

        /*
        checks which line is shorter
        and calculates distances to the collision points (if there are collision points)
         */
        if (lengthOfLineOfMovingLine < lengthOfStaticLine) {

            collisionPoint1 = Line.getLineSegmentsIntersectionPoint(staticLine, new Line(movingLine.getStartPoint().getX(), movingLine.getStartPoint().getY(), movingLine.getStartPoint().getX() + speedX, movingLine.getStartPoint().getY() + speedY));
            collisionPoint2 = Line.getLineSegmentsIntersectionPoint(staticLine, new Line(movingLine.getEndPoint().getX(), movingLine.getEndPoint().getY(), movingLine.getEndPoint().getX() + speedX, movingLine.getEndPoint().getY() + speedY));

            if (collisionPoint1 != null)
                distance1 = Line.getLength(new Line(movingLine.getStartPoint().getX(), movingLine.getStartPoint().getY(), collisionPoint1.getX(), collisionPoint1.getY()));
            else
                distance1 = -1;

            if (collisionPoint2 != null)
                distance2 = Line.getLength(new Line(movingLine.getEndPoint().getX(), movingLine.getEndPoint().getY(), collisionPoint2.getX(), collisionPoint2.getY()));
            else
                distance2 = -1;

        } else {

            collisionPoint1 = Line.getLineSegmentsIntersectionPoint(movingLine, new Line(staticLine.getStartPoint().getX(), staticLine.getStartPoint().getY(), staticLine.getStartPoint().getX() - speedX, staticLine.getStartPoint().getY() - speedY));
            collisionPoint2 = Line.getLineSegmentsIntersectionPoint(movingLine, new Line(staticLine.getEndPoint().getX(), staticLine.getEndPoint().getY(), staticLine.getEndPoint().getX() - speedX, staticLine.getEndPoint().getY() - speedY));

            if (collisionPoint1 != null)
                distance1 = Line.getLength(new Line(staticLine.getStartPoint().getX(), staticLine.getStartPoint().getY(), collisionPoint1.getX(), collisionPoint1.getY()));
            else
                distance1 = -1;

            if (collisionPoint2 != null)
                distance2 = Line.getLength(new Line(staticLine.getEndPoint().getX(), staticLine.getEndPoint().getY(), collisionPoint2.getX(), collisionPoint2.getY()));
            else
                distance2 = -1;

        }

        double shortestDistance = distance1;
        if (shortestDistance == -1 || (distance2 != -1 && distance2 < shortestDistance))
            shortestDistance = distance2;

        if (shortestDistance != -1)
            return shortestDistance / distancePerTick;
        else
            return -1;

    }

    /**
     * Calculates the time until collision between a moving Object and a static Object if they collide during one tick.
     *
     * @param movingObject the moving Object
     * @param speedX       the speed of the moving object in x-direction in pixel/tick
     * @param speedY       the speed of the moving object in y-direction in pixel/tick
     * @param staticObject the static Object
     * @return a list containing two elements. first element: the time until the two objects collide, if they collide during one tick. {@code -1} otherwise. Will also return {@code -1} if the objects are already colliding. second element: a boolean which is true if the colliding line of the static object is horizontal, false otherwise.
     */
    public static List<java.lang.Object> calcTimeUntilCollisionObjects(Object movingObject, double speedX, double speedY, Object staticObject) {

        if (speedX == 0 && speedY == 0)
            throw new IllegalArgumentException("The movingObject is not moving!");

        if (staticObject.getBounds().getWidth() == 0 && staticObject.getBounds().getHeight() == 0)
            throw new IllegalArgumentException("The staticObject is a bit too small.");

        if (movingObject.getBounds().getWidth() == 0 && movingObject.getBounds().getHeight() == 0)
            throw new IllegalArgumentException("The movingObject is a bit too small.");

        double timeUntilCollision = -1;
        boolean isHorizontal = true;
        double dummyTime;
        List<Line> linesOfStaticObject = staticObject.getBounds().getEdges();

        for (Line lineOfStaticObject : linesOfStaticObject) {

            dummyTime = calcTimeUntilCollisionObjectLineSegment(movingObject, speedX, speedY, lineOfStaticObject);
            if (timeUntilCollision == -1 || (dummyTime != -1 && dummyTime < timeUntilCollision)) {
                timeUntilCollision = dummyTime;
                isHorizontal = (lineOfStaticObject.getEndPoint().getX() - lineOfStaticObject.getStartPoint().getX()) != 0;
            }

        }

        List<java.lang.Object> returnValue = new ArrayList<>();
        returnValue.add(timeUntilCollision);
        returnValue.add(isHorizontal);
        return returnValue;

    }

}
