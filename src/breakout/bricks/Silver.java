package breakout.bricks;

import breakout.levels.Level;

/**
 * Creates a silver brick if it get hit it'll chance to bronze and will be
 * removed afterwards
 *
 * @author Helge
 */
public class Silver extends Brick {

    /**
     * Counts how many times the brick got hit
     */
    private int hitCounter = 1;

    /**
     * Constructor takes x and y coordinate and sets Type to Silver by default.
     *
     * @param x x coordinate for the upper left corner
     * @param y coordinate for the upper left corner
     */
    public Silver(double x, double y) {
        super(x, y, 40, 15, Type.Silver);
    }

    /**
     * Overrides the gotHit. If Silver got hit its icon changes bronze and then will be removed
     */
    @Override
    public void gotHit(Level level) {
        switch (hitCounter) {
            case 1:
                this.setType(Type.Bronze);
                hitCounter++;
                break;
            case 2:
                this.removeBrick(level);
        }
    }
}
