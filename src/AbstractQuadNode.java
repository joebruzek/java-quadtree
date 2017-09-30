public abstract class AbstractQuadNode<T> {
    private int capacity;
    private T[] payload;
    private NodeType type;
    private int count = 0;
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    //abstract methods to be implemented by children
    public abstract AbstractQuadNode insert(Point value);
    public abstract AbstractQuadNode remove(Point value);
    public abstract AbstractQuadNode split();

    public AbstractQuadNode(int capacity, int minX, int maxX, int minY, int maxY) {
        this.capacity = capacity;
        this.payload = (T[])new Object[capacity];
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
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

    private void checkValidIndex(int index) {
        if (index >= capacity || index < 0) {
            throw new IndexOutOfBoundsException("Attempting to access index " + index + " of node with size " + capacity);
        }
    }
}
