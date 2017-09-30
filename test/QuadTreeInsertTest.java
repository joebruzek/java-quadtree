import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadTreeInsertTest {
    private QuadTree tree;
    private static int QUADTREE_SIZE = 1000;

    @org.testng.annotations.BeforeMethod
    public void setUp() throws Exception {
        tree = new QuadTree(QUADTREE_SIZE);
    }

    @Test
    public void testInsertWithNoSplits() {
        tree.insert(new Point(500, 500));
        tree.insert(new Point(100, 100));
        tree.insert(new Point(900, 900));

        assertEquals(tree.toString(), "{[500, 500], [100, 100], [900, 900]}");
    }

    @Test
    public void testInsertWithSplits() {
        tree.insert(new Point(500, 500));
        tree.insert(new Point(100, 100));
        tree.insert(new Point(900, 900));
        tree.insert(new Point(800, 100));

        assertEquals(tree.toString(), "{[500, 500], [100, 100], [800, 100], [900, 900]}");
    }

    @Test
    public void testInsertInvalidPoints() {
        Point point1 = new Point(-100, -100);
        Point point2 = new Point(1000, 1000);
        try {
            tree.insert(point1);
            fail();
        } catch(Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
            assertEquals(e.getMessage(), "Point " + point1 + " is outside the boundaries of the tree. Tree size is " + QUADTREE_SIZE);
        }

        try {
            tree.insert(point2);
            fail();
        } catch(Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
            assertEquals(e.getMessage(), "Point " + point2 + " is outside the boundaries of the tree. Tree size is " + QUADTREE_SIZE);
        }
    }
}