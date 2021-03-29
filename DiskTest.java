// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
// nor will I accept the actions of those who do.
// -- Nathan Brown (bnathan)
package towerofhanoi;
import student.TestCase;
/**
 * tests methods of Disk class
 * @author Nathan Brown (bnathan)
 * @version 2020.10.20
 * 
 */
public class DiskTest extends TestCase {
    private Disk test;
    /**
     * sets up scenario for each test method
     */
    public void setUp() {
        test = new Disk(10);
    }
    /**
     * tests compareTo() when paramater is null
     */
    public void testCompareToNull() {
        try {
            test.compareTo(null);
        }
        catch (IllegalArgumentException e) {
            assertEquals(10, test.getWidth());
        }
    }
    /**
     * tests compareTo()
     */
    public void testCompareTo() {
        Disk compare = new Disk(5);
        assertEquals(5, test.compareTo(compare));
    }
    /**
     * tests toString()
     */
    public void testToString() {
        assertEquals("10", test.toString());
    }
    /**
     * tests equals() when objects are the same
     */
    public void testEqualsSame() {
        Disk same = test;
        assertTrue(same.equals(test));
    }
    /**
     * tests equals() when null
     */
    public void testEqualsNull() {
        Disk nothing = null;
        assertFalse(test.equals(nothing));
    }
    /**
     * tests equals() when parameter is a different class
     */
    public void testEqualsDiffClass() {
        String compare = "testing";
        assertFalse(test.equals(compare));
    }
    /**
     * tests equals()
     */
    public void testEqualsTrue() {
        Disk same = new Disk(10);
        assertTrue(test.equals(same));
    }
    /**
     * tests equals() when false
     */
    public void testEqualsFalse() {
        Disk diff = new Disk(5);
        assertFalse(test.equals(diff));
    }
}
