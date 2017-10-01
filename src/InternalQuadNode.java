import java.util.ArrayList;
import java.util.List;

public class InternalQuadNode extends AbstractQuadNode<AbstractQuadNode> {
    private static int INTERNAL_NODE_SIZE = 4;

    public InternalQuadNode(QuadRange range) {
        super(INTERNAL_NODE_SIZE, range);
        setType(NodeType.INTERNAL);

        //fill the node with leafs
        for (int i = 0; i < INTERNAL_NODE_SIZE; i++) {
            set(i, new LeafQuadNode(range.getSubrange(Direction.valueOf(i))));
        }
        setCount(INTERNAL_NODE_SIZE);
    }

    @Override
    public AbstractQuadNode insert(Point value) {
        Direction direction = getRange().getDirection(value);
        get(direction.val()).insert(value);
        return this;
    }

    @Override
    public AbstractQuadNode remove(Point value) {
        return this;
    }

    @Override
    public AbstractQuadNode split() {
        return null;
    }

    @Override
    public List<Point> getPoints() {
        List<Point> nodeList = new ArrayList<>();
        for(int i = 0; i < getCount(); i++) {
            nodeList.addAll(get(i).getPoints());
        }
        return nodeList;
    }
}
