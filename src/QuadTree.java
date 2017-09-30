import java.util.Collection;
import java.util.Collections;

public class QuadTree {
    private static LeafQuadNode flyweight = null;
    private AbstractQuadNode root;
    private int size;

    /**
     * Quadtree is always a square with width/height of {size}
     * @param size
     */
    public QuadTree(int size) {
        root = QuadTree.flyweight();
        this.size = size;
    }

    /**
     * The flyweight node is a singleton belonging to the QuadTree class
     */
    public static LeafQuadNode flyweight() {
        if (flyweight == null) {
            flyweight = new LeafQuadNode(0, 0, 0, 0);
            flyweight.setType(NodeType.FLYWEIGHT);
        }
        return flyweight;
    }

    public void insert(Point value) {
        if (value.getX() < 0 || value.getX() >= size
            || value.getY() < 0 || value.getY() >= size) {
            throw new IndexOutOfBoundsException("Point " + value + " is outside the boundaries of the tree. Tree size is " + size);
        }
        if (root.equals(flyweight)) {
            root = new LeafQuadNode(0, size, 0, size);
        }
        root = root.insert(value);
    }

    public void remove(Point value) {

    }

    public Collection<Point> findInRange() {
        return Collections.EMPTY_SET;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(root.toString());
        if (sb.indexOf(", ") > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");

        return sb.toString();
    }
}