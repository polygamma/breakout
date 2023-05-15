package breakout.bricks;

import breakout.geometry.Rectangle;
import breakout.levels.Level;

/**
 * This class is used to represent bricks.
 */
public abstract class Brick extends Rectangle {

    /**
     * the type of the brick
     */
    private Type type;

    /**
     * constructs a new brick.
     *
     * @param x      the x-coordinate of the upper left corner
     * @param y      the y-coordinate of the upper left corner
     * @param width  the width of the brick
     * @param height the height of the brick
     * @param type   the type of the brick
     */
    public Brick(double x, double y, double width, double height, Type type) {

        super(x, y, width, height);
        this.setType(type);

    }

    /**
     * sets the parameters of the brick.
     *
     * @param x      the x-coordinate of the upper left corner
     * @param y      the y-coordinate of the upper left corner
     * @param width  the width of the brick
     * @param height the height of the brick
     * @param type   the type of the brick
     */
    public void setBrick(double x, double y, double width, double height, Type type) {

        this.setRectangle(x, y, width, height);
        this.setType(type);

    }

    /**
     * returns the type of the brick.
     *
     * @return the type of the brick.
     */
    public Type getType() {
        return type;
    }

    /**
     * sets the type of the brick.
     *
     * @param type the type of the brick.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * this method is called when you want to remove the brick
     *
     * @param level the level which is getting played
     */
    public void removeBrick(Level level) {

        level.getBricks().remove(this);

    }

    /**
     * this method is called when a brick gets hit
     *
     * @param level the level which is getting played
     */
    public abstract void gotHit(Level level);

    /**
     * enum containing the different types of bricks
     */
    public enum Type {
        BallLost,
        Gold,
        Silver,
        Bronze,
        Neon,
        invisible,
        Metal,
        LightOff,
        LightOn
    }

}
