public class InternalQuadNode extends AbstractQuadNode<AbstractQuadNode> {
    private static int INTERNAL_NODE_SIZE = 4;

    public InternalQuadNode(int minX, int maxX, int minY, int maxY) {
        super(INTERNAL_NODE_SIZE, minX, maxX, minY, maxY);
        setType(NodeType.INTERNAL);
    }

    @Override
    public AbstractQuadNode insert(Point value) {
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
}
