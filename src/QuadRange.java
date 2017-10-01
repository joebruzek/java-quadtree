import java.util.HashMap;
import java.util.Map;

public class QuadRange {
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public QuadRange(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    // Get a new Quadrange representing a 1/4 subrange of this one
    public QuadRange getSubrange(Direction direction) {
        switch (direction) {
            case NORTHWEST:
                return new QuadRange(minX, maxX / 2, minY, maxY / 2);
            case NORTHEAST:
                return new QuadRange(maxX / 2, maxX, minY, maxY / 2);
            case SOUTHWEST:
                return new QuadRange(minX, maxX / 2, maxY / 2, maxY);
            case SOUTHEAST:
                return new QuadRange(maxX / 2, maxX, maxY / 2, maxY);
        }
        return null;
    }

    // Get the internal quadrant of this range a point lies in
    public Direction getDirection(Point pos) {
        if (pos.getX() <= maxX / 2) {
            if (pos.getY() <= maxY / 2) {
                return Direction.NORTHWEST;
            } else {
                return Direction.SOUTHWEST;
            }
        } else {
            if (pos.getY() <= maxY / 2) {
                return Direction.NORTHEAST;
            } else {
                return Direction.SOUTHEAST;
            }
        }
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }
}
