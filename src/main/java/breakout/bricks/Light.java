package breakout.bricks;

import breakout.levels.Level;

/**
 * Creates a lightning bulb brick. if it gets hit it'll turn the light on and if
 * it gets afterwards it'll turn its lights of
 *
 * @author Helge
 */
public class Light extends Brick {

    /**
     * shows if the light is on
     */
    private boolean isOn = false;

    /**
     * Constructor takes x and y coordinate and sets Type to LightOff by
     * default.
     *
     * @param x x coordinate for the upper left corner
     * @param y coordinate for the upper left corner
     */
    public Light(double x, double y) {
        super(x, y, 40, 15, Type.LightOff);
    }

    /**
     * gettetr for the isOn field
     *
     * @return {@code true} if light is on {@code false} if the light is off
     */
    public boolean isOn() {
        return this.isOn;
    }

    /**
     * Overrides the gotHit. If Light got hit its icon changes LightOn and back
     * to LightOff afterwards
     */
    @Override
    public void gotHit(Level level) {
        if (isOn) {
            this.setType(Type.LightOff);
            isOn = false;
        } else {
            this.setType(Type.LightOn);
            isOn = true;
        }
    }
}