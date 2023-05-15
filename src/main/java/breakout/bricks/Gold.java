package breakout.bricks;

import breakout.levels.Level;

/**
 * Creates a golden brick
 * if it get hit it'll chance to silver, to bronze and will be removed afterwards
 *
 * @author Helge
 */
public class Gold extends Brick {

    /**
     * Counts how many times the brick got hit
     */
    private int hitCounter = 1;

    /**
     * Constructor takes x and y coordinate and sets Type to Gold by default.
     *
     * @param x x coordinate for the upper left corner
     * @param y coordinate for the upper left corner
     */
    public Gold(double x, double y) {
        super(x, y, 40, 15, Type.Gold);
    }

    /**
     * Overrides the gotHit. If Gold got hit its icon changes to Silver
     * then to bronze and then will be removed
     */
    @Override
    public void gotHit(Level level) {
        switch (hitCounter) {
            case 1:
                this.setType(Type.Silver);
                hitCounter++;
                break;
            case 2:
                this.setType(Type.Bronze);
                hitCounter++;
                break;
            case 3:
                this.removeBrick(level);
        }
    }
}
