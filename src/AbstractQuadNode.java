import java.util.Collection;
import java.util.List;

public abstract class AbstractQuadNode<T> {
    private int capacity;
    private T[] payload;
    private NodeType type;
    private int count = 0;
    private QuadRange range;

    //abstract methods to be implemented by children
    public abstract AbstractQuadNode insert(Point value);
    public abstract AbstractQuadNode remove(Point value);
    public abstract AbstractQuadNode split();
    public abstract List<Point> getPoints();

    public AbstractQuadNode(int capacity, QuadRange range) {
        this.capacity = capacity;
        this.payload = (T[])new Object[capacity];
        this.range = range;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(get(i).toString());
            sb.append(", ");
        }
        return sb.toString();
    }

    public void add(T value) {
        set(count, value);
        count++;
    }

    public T get(int index) {
        checkValidIndex(index);
        return payload[index];
    }

    public void set(int index, T value) {
        checkValidIndex(index);
        payload[index] = value;
    }

    public int contains(T value) {
        for (int i = 0; i < count; i++) {
            if (payload[i].equals(value)) {
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

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private void checkValidIndex(int index) {
        if (index >= capacity || index < 0) {
            throw new IndexOutOfBoundsException("Attempting to access index " + index + " of node with size " + capacity);
        }
    }
}
