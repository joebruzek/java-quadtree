public class Main {
    private static int QUADTREE_SIZE = 1000;

    public static void main(String[] args) {
        QuadTree tree = new QuadTree(QUADTREE_SIZE);
        tree.insert(new Point(500, 500));
        System.out.println(tree.toString());
    }
}
