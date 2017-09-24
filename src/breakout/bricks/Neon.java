package breakout.bricks;

import breakout.levels.Level;

/**
 * Creates a invisible
 * if it get hit it'll show itself and will be removed afterwards
 *
 * @author Helge
 */
public class Neon extends Brick {

    /**
     * Counts how many times the brick got hit
     */
    private int hitCounter = 1;

    /**
     * Constructor takes x and y coordinate and sets Type to Invisible by default.
     *
     * @param x x coordinate for the upper left corner
     * @param y coordinate for the upper left corner
     */
    public Neon(double x, double y) {
        super(x, y, 40, 15, Type.invisible);
    }

    /**
     * Overrides the gotHit. If Neon got hit its icon changes Neon type and then will be removed
     */
    @Override
    public void gotHit(Level level) {
        switch (hitCounter) {
            case 1:
                hitCounter++;
                this.setType(Type.Neon);
                break;
            case 2:
                this.removeBrick(level);
                break;
        }

    }

}
