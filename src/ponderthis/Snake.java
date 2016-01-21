package ponderthis;

/**
 * @author Efthymios G. Karadimas
 */
public class Snake {

    private int counter;
    private Segment[] segments;

    Snake() {
        segments = new Segment[20];
        segments[0] = new Segment();
        segments[0].setDirection(Segment.Direction.LEFT);
        segments[0].setPosition(new Position(0, 1));
        segments[0].setOrientation(Segment.Orientation.UP);
    }

    public boolean placeSegments() {
        return placeSegmentRecursive(Segment.Direction.LEFT, 1);
    }

    private boolean placeSegmentRecursive(Segment.Direction direction, int s) {
        segments[s] = new Segment();
        segments[s].setDirection(direction);

        if (segments[s - 1].getOrientation() == Segment.Orientation.UP) {

            if (direction == Segment.Direction.LEFT) {
                segments[s].setOrientation(Segment.Orientation.LEFT);

                segments[s].getPosition().setX(segments[s - 1].getPosition().getX() - 1);
                segments[s].getPosition().setY(segments[s - 1].getPosition().getY());
            } else {
                segments[s].setOrientation(Segment.Orientation.RIGHT);

                segments[s].getPosition().setX(segments[s - 1].getPosition().getX() + 1);
                segments[s].getPosition().setY(segments[s - 1].getPosition().getY());
            }
        } else if (segments[s - 1].getOrientation() == Segment.Orientation.DOWN) {

            if (direction == Segment.Direction.LEFT) {
                segments[s].setOrientation(Segment.Orientation.RIGHT);

                segments[s].getPosition().setX(segments[s - 1].getPosition().getX() + 1);
                segments[s].getPosition().setY(segments[s - 1].getPosition().getY());
            } else {
                segments[s].setOrientation(Segment.Orientation.LEFT);

                segments[s].getPosition().setX(segments[s - 1].getPosition().getX() - 1);
                segments[s].getPosition().setY(segments[s - 1].getPosition().getY());
            }
        } else if (segments[s - 1].getOrientation() == Segment.Orientation.LEFT) {

            if (direction == Segment.Direction.LEFT) {
                segments[s].setOrientation(Segment.Orientation.DOWN);

                segments[s].getPosition().setX(segments[s - 1].getPosition().getX());
                segments[s].getPosition().setY(segments[s - 1].getPosition().getY() - 1);
            } else {
                segments[s].setOrientation(Segment.Orientation.UP);

                segments[s].getPosition().setX(segments[s - 1].getPosition().getX());
                segments[s].getPosition().setY(segments[s - 1].getPosition().getY() + 1);
            }
        } else if (segments[s - 1].getOrientation() == Segment.Orientation.RIGHT) {

            if (direction == Segment.Direction.LEFT) {
                segments[s].setOrientation(Segment.Orientation.UP);

                segments[s].getPosition().setX(segments[s - 1].getPosition().getX());
                segments[s].getPosition().setY(segments[s - 1].getPosition().getY() + 1);
            } else {
                segments[s].setOrientation(Segment.Orientation.DOWN);

                segments[s].getPosition().setX(segments[s - 1].getPosition().getX());
                segments[s].getPosition().setY(segments[s - 1].getPosition().getY() - 1);
            }
        }

        if (checkOverlapping(s)) {
            if (s == 19) {
                print();
                counter++;
                return true;
            } else {
                placeSegmentRecursive(Segment.Direction.LEFT, s + 1);
                placeSegmentRecursive(Segment.Direction.RIGHT, s + 1);
            }
        }

        return false;
    }

    private void print() {
        for (int i = 1; i < 20; i++) {
            if (segments[i].getDirection() == Segment.Direction.LEFT) {
                System.out.print('L');                
            }
            else {
            	System.out.print('R');
            }
        }
        System.out.print('\n');
    }

    private boolean checkOverlapping(int s) {
        for (int i = 0; i < s; i++) {
            if (segments[s].getPosition().getX() == segments[i].getPosition().getX() 
            		&& segments[s].getPosition().getY() == segments[i].getPosition().getY()) {
                return false;
            }
        }
        if (segments[s].getPosition().getX() == 0 && segments[s].getPosition().getY() == 0) {
            return false;
        }
        return true;
    }

    public int getCounter() {
        return counter;
    }
}
