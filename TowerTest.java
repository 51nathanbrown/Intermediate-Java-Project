// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
// nor will I accept the actions of those who do.
// -- Nathan Brown (bnathan)

package towerofhanoi;
import student.TestCase;
/**
 * tests methods of Tower class
 * @author Nathan Brown (bnathan)
 * @version 2020.10.20
 */
public class TowerTest extends TestCase {
    private Tower test;
    /**
     * sets up scenario for each test
     */
    public void setUp() {
        test = new Tower(Position.LEFT);
    }
    /**
     * tests position() method
     */
    public void testPosition() {
        assertEquals(Position.LEFT, test.position());
    }
    /**
     * tests push() when null
     */
    public void testPushNull() {
        try {
            Disk nothing = null;
            test.push(nothing);
        }
        catch (IllegalArgumentException e) {
            assertEquals(0, test.size());
        }
    }
    /**
     * tests push()
     */
    public void testPushEmpty() {
        Disk first = new Disk(10);
        test.push(first);
        assertEquals(1, test.size());
    }
    /**
     * tests push when disk is smaller than original
     */
    public void testPushSmaller() {
        Disk first = new Disk(10);
        test.push(first);
        Disk second = new Disk(5);
        test.push(second);
        assertEquals(2, test.size());
    }
    /**
     * tests push() when it fails
     */
    public void testPushFail() {
        try {
            Disk first = new Disk(10);
            test.push(first);
            Disk second = new Disk(20);
            test.push(second);
        }
        catch (IllegalStateException e) {
            assertEquals(1, test.size());
        }
    }
}
