package breakout.geometry;

/**
 * This class is used to represent the walls of the playing field.
 */
public class Wall extends Rectangle {

    /**
     * the type of the wall.
     */
    private Type type;

    /**
     * constructs a new wall.
     *
     * @param type the type of the wall
     */
    public Wall(Type type) {

        super(0, 0, 500, 650);
        this.setType(type);

    }

    /**
     * sets the parameters of the wall.
     *
     * @param width  the width of the wall
     * @param height the height of the wall
     * @param type   the type of the wall
     */
    public void setWall(double width, double height, Type type) {

        this.setRectangle(0, 0, width, height);
        this.setType(type);

    }

    /**
     * returns the type of the wall.
     *
     * @return the type of the wall.
     */
    public Type getType() {
        return type;
    }

    /**
     * sets the type of the wall.
     *
     * @param type the type of the wall.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * enum containing the different types of walls.
     */
    public enum Type {
        Level1,
        Level2,
        Level3,
        winner3,
        winner2,
        winner1
    }

}
