
package ponderthis;

/**
 *
 * @author Efthymios G. Karadimas
 */
public class Segment {
    public enum Direction
    {
        LEFT,
        RIGHT;
    }

    public enum Orientation
    {
        LEFT,
        RIGHT,
        UP,
        DOWN;
    }

    private Orientation orientation;
    private Direction direction;
    private Position position;

    Segment()
    {
        position = new Position(0, 0);
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
