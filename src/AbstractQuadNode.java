import java.util.ArrayList;
import java.util.List;

public abstract class AbstractQuadNode<T> {
    private int capacity;
    private ArrayList<T> payload;
    private NodeType type;
    private int count = 0;
    private QuadRange range;

    //abstract methods to be implemented by children
    public abstract AbstractQuadNode insert(Point value);
    public abstract AbstractQuadNode remove(Point value);
    public abstract AbstractQuadNode split();
    public abstract List<Point> getPoints();
    public abstract int getNumPoints();

    public AbstractQuadNode(int capacity, QuadRange range) {
        this.capacity = capacity;
        this.payload = new ArrayList<>();
        this.range = range;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(payload.get(i).toString());
            sb.append(", ");
        }
        return sb.toString();
    }

    public ArrayList<T> getPayload() {
        return payload;
    }

    public int contains(T value) {
        for (int i = 0; i < payload.size(); i++) {
            if (payload.get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public QuadRange getRange() {
        return range;
    }

    public void setRange(QuadRange range) {
        this.range = range;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }
}
