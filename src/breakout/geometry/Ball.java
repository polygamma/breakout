package breakout.geometry;

/**
 * This class is used to represent the ball of the game.
 */
public class Ball extends Oval {

    /**
     * The speed of the ball in x-direction per second.
     */
    private double speedX;

    /**
     * The speed of the ball in y-direction per second.
     */
    private double speedY;

    /**
     * the type of the ball.
     */
    private Type type;

    /**
     * constructs a new ball.
     *
     * @param x      the x-coordinate of the upper left corner.
     * @param y      the y-coordinate of the upper left corner.
     * @param width  the width of the ball.
     * @param height the height of the ball.
     * @param speedX the speed of the ball in x-direction per second.
     * @param speedY the speed of the ball in y-direction per second.
     */
    public Ball(double x, double y, double width, double height, double speedX, double speedY, Type type) {

        super(x, y, width, height);
        this.setSpeedX(speedX);
        this.setSpeedY(speedY);
        this.setType(type);

    }

    /**
     * Sets the parameters of the ball.
     *
     * @param x      the x-coordinate of the upper left corner.
     * @param y      the y-coordinate of the upper left corner.
     * @param width  the width of the ball.
     * @param height the height of the ball.
     * @param speedX the speed of the ball in x-direction per second.
     * @param speedY the speed of the ball in y-direction per second.
     */
    public void setBall(double x, double y, double width, double height, double speedX, double speedY, Type type) {

        this.setOval(x, y, width, height);
        this.setSpeedX(speedX);
        this.setSpeedY(speedY);
        this.setType(type);

    }

    /**
     * returns the speed of the ball in x-direction per second.
     *
     * @return the speed of the ball in x-direction per second.
     */
    public double getSpeedX() {
        return speedX;
    }

    /**
     * sets the speed of the ball in x-direction per second.
     *
     * @param speedX the speed of the ball in x-direction per second.
     */
    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    /**
     * returns the speed of the ball in y-direction per second.
     *
     * @return the speed of the ball in y-direction per second.
     */
    public double getSpeedY() {
        return speedY;
    }

    /**
     * sets the speed of the ball in y-direction per second.
     *
     * @param speedY the speed of the ball in x-direction per second.
     */
    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    /**
     * returns the type of the ball.
     *
     * @return the type of the ball.
     */
    public Type getType() {
        return type;
    }

    /**
     * sets the type of the ball.
     *
     * @param type the type of the ball.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * enum containing the different types of the ball.
     */
    public enum Type {
        Level1
    }

}
