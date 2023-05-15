package breakout.bricks;

import breakout.levels.Level;

/**
 * Creates a normal brick. It'll be removed if it got hit
 *
 * @author Helge
 */
public class Metal extends Brick {

    /**
     * Constructor takes x and y coordinate and sets Type to Metal by default.
     *
     * @param x x coordinate for the upper left corner
     * @param y coordinate for the upper left corner
     */
    public Metal(double x, double y) {
        super(x, y, 40, 15, Type.Metal);
    }

    /**
     * Overrides the gotHit. If hit it'll be removed
     */
    @Override
    public void gotHit(Level level) {
        this.removeBrick(level);
    }
}
