import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        if (getPayload().size() < LEAF_NODE_SIZE) {
            getPayload().add(value);
            duplicateCount[getPayload().size() - 1]++;
        } else {
            AbstractQuadNode newNode = split();
            newNode.insert(value);
            return newNode;
        }
        return this;
    }

    @Override
    public AbstractQuadNode remove(Point value) {
        //find the index of the point
        //remove the point
        return this;
    }

    @Override
    public AbstractQuadNode split() {
        InternalQuadNode newNode = new InternalQuadNode(getRange());
        for (int i = 0; i < getPayload().size(); i++) {
            for (int j = 0; j < duplicateCount[i]; j++) {
                newNode.insert(getPayload().get(i));
            }
        }
        return newNode;
    }

    @Override
    public List<Point> getPoints() {
        List<Point> nodeList = new ArrayList<>();
        for (int i = 0; i < getPayload().size(); i++) {
            for (int j = 0; j < duplicateCount[i]; j++) {
                nodeList.add(getPayload().get(i));
            }
        }
        return nodeList;
    }

    @Override
    public int getNumPoints() {
        return Arrays.stream(duplicateCount).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getPayload().size(); i++) {
            for (int j = 0; j < duplicateCount[i]; j++) {
                sb.append(getPayload().get(i).toString());
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
