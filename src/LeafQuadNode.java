import java.util.Arrays;

public class LeafQuadNode extends AbstractQuadNode<Point> {
    private static int LEAF_NODE_SIZE = 3;
    private int[] duplicateCount;

    public LeafQuadNode(QuadRange range) {
        super(LEAF_NODE_SIZE, range);
        setType(NodeType.LEAF);
        duplicateCount = new int[LEAF_NODE_SIZE];
        Arrays.fill(duplicateCount, 0);
    }

    @Override
    public AbstractQuadNode insert(Point value) {
        //check if there's a duplicate
        int pos = contains(value);
        if (pos >= 0) {
            duplicateCount[pos]++;
            return this;
        }

        if (getCount() < LEAF_NODE_SIZE) {
            add(value);
            duplicateCount[getCount() - 1]++;
        } else {
            return split();
        }
        return this;
    }

    @Override
    public AbstractQuadNode remove(Point value) {
        return this;
    }

    @Override
    public AbstractQuadNode split() {
        InternalQuadNode newNode = new InternalQuadNode(getRange());
        for (int i = 0; i < getCount(); i++) {
            for (int j = 0; j < duplicateCount[i]; j++) {
                newNode.insert(get(i));
            }
        }
        return newNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getCount(); i++) {
            for (int j = 0; j < duplicateCount[i]; j++) {
                sb.append(get(i).toString());
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
