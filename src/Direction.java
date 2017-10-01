import java.util.HashMap;
import java.util.Map;

public enum Direction {
    NORTHWEST(0),
    NORTHEAST(1),
    SOUTHWEST(2),
    SOUTHEAST(3);

    private final int value;
    private static Map<Integer, Direction> map = new HashMap<>();

    static {
        for (Direction dir : Direction.values()) {
            map.put(dir.value, dir);
        }
    }

    Direction(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }

    public static Direction valueOf(int dirVal) {
        return map.get(dirVal);
    }
}
