import java.util.ArrayList;
import java.util.List;

public class InternalQuadNode extends AbstractQuadNode<AbstractQuadNode> {
    private static int INTERNAL_NODE_SIZE = 4;

    public InternalQuadNode(QuadRange range) {
        super(INTERNAL_NODE_SIZE, range);
        setType(NodeType.INTERNAL);

        //fill the node with leafs
        for (int i = 0; i < INTERNAL_NODE_SIZE; i++) {
            getPayload().add(new LeafQuadNode(getRange().getSubrange(Direction.valueOf(i))));
        }
    }

    @Override
    public AbstractQuadNode insert(Point value) {
        Direction direction = getRange().getDirection(value);
        getPayload().set(direction.val(), getPayload().get(direction.val()).insert(value));
        return this;
    }

    @Override
    public AbstractQuadNode remove(Point value) {
        //find direction of point
        //get(dir.val()).remove(point)
        //get total count
        //if total count < INTERNAL_NODE_CAPACITY...
        //      points = getPoints();
        //      new InternalQuadNode(this.range)
        //      points.forEach(point -> newNode.insert(point))
        //      return newNode
        //return this
        return this;
    }

    @Override
    public int getNumPoints() {
        return getPayload().stream().mapToInt(node -> node.getNumPoints()).sum();
    }

    @Override
    public AbstractQuadNode split() {
        return null;
    }

    @Override
    public List<Point> getPoints() {
        List<Point> nodeList = new ArrayList<>();
        getPayload().forEach(node -> nodeList.addAll(node.getPoints()));
        return nodeList;
    }
}
