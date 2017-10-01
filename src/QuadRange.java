public class QuadRange {
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public enum Direction {
        NORTHWEST,
        NORTHEAST,
        SOUTHWEST,
        SOUTHEAST
    }

    public QuadRange(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

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
