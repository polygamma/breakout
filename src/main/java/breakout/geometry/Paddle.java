package breakout.geometry;

/**
 * This class is used to represent the paddle of the game.
 */
public class Paddle extends Rectangle {

    /**
     * the type of the paddle.
     */
    private Type type;

    /**
     * constructs a new paddle.
     *
     * @param x      the x-coordinate of the upper left corner
     * @param y      the y-coordinate of the upper left corner
     * @param width  the width of the paddle
     * @param height the height of the paddle
     * @param type   the type of the paddle
     */
    public Paddle(double x, double y, double width, double height, Type type) {

        super(x, y, width, height);
        this.setType(type);

    }

    /**
     * sets the parameters of the paddle.
     *
     * @param x      the x-coordinate of the upper left corner
     * @param y      the y-coordinate of the upper left corner
     * @param width  the width of the paddle
     * @param height the height of the paddle
     * @param type   the type of the paddle
     */
    public void setPaddle(double x, double y, double width, double height, Type type) {

        this.setRectangle(x, y, width, height);
        this.setType(type);

    }

    /**
     * returns the type of the paddle.
     *
     * @return the type of the paddle.
     */
    public Type getType() {
        return type;
    }

    /**
     * sets the type of the paddle.
     *
     * @param type the type of the paddle.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * enum containing the different types of paddles.
     */
    public enum Type {
        Level1
    }

}
