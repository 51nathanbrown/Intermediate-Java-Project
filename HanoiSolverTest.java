package towerofhanoi;
import student.TestCase;
/**
 * tests methods of HanoiSolver class
 * @author Nathan Brown (bnathan)
 * @version 2020.10.20
 */
public class HanoiSolverTest extends TestCase {
    private HanoiSolver test;
    /**
     * sets up scenario for tests
     */
    public void setUp() {
        test = new HanoiSolver(3);
    }
    /**
     * tests disks()
     */
    public void testDisks() {
        assertEquals(3, test.disks());
    }
    /**
     * tests toString()
     */
    public void testToString() {
        assertEquals("[][][]", test.toString());
    }
    /**
     * tests solve()
     */
    public void testSolve() {
        new PuzzleWindow(test);
        test.solve();
        assertEquals("[35, 45, 55][][]", test.toString());
    }
    /**
     * tests getTower()
     */
    public void testGetTower() {
        assertEquals(test.getTower(Position.DEFAULT).toString(), "[]");
    }
}
