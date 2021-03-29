// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
// nor will I accept the actions of those who do.
// -- Nathan Brown (bnathan)

package towerofhanoi;
import java.util.EmptyStackException;
import student.TestCase;
/**
 * Tests methods of LinkedStack class
 * @author Nathan Brown (bnathan)
 * @version 2020.10.20
 */
public class LinkedStackTest extends TestCase {
    private LinkedStack<String> test;
    /**
     * sets up scenario for each test
     */
    public void setUp() {
        test = new LinkedStack<String>();
    }
    /**
     * tests size()
     */
    public void testSize() {
        assertEquals(0, test.size());
    }
    /**
     * tests toString() when empty
     */
    public void testToStringEmpty() {
        assertEquals("[]", test.toString());
    }
    /**
     * tests toString()
     */
    public void testToString() {
        test.push("nathan");
        test.push("brown");
        assertEquals("[brown, nathan]", test.toString());
    }
    /**
     * tests clear()
     */
    public void testClear() {
        test.push("nathan");
        test.clear();
        assertEquals(0, test.size());
    }
    /**
     * tests isEmpty() when true
     */
    public void testIsEmptyTrue() {
        assertTrue(test.isEmpty());
    }
    /**
     * tests isEmpty() when false
     */
    public void testIsEmptyFalse() {
        test.push("nathan");
        assertFalse(test.isEmpty());
    }
    /**
     * tests pop() when empty
     */
    public void testPopEmpty() {
        try {
            test.pop();
        }
        catch (EmptyStackException e) {
            assertEquals(0, test.size());
        }
    }
    /**
     * tests pop()
     */
    public void testPop() {
        test.push("nathan");
        assertEquals("nathan", test.pop());
    }
    /**
     * tests push()
     */
    public void testPush() {
        test.push("nathan");
        assertEquals(1, test.size());
        assertEquals("nathan", test.peek());
    }
    /**
     * tests peek() when empty
     */
    public void testPeekEmpty() {
        try {
            test.peek();
        }
        catch (EmptyStackException e) {
            assertEquals(0, test.size());
        }
    }
    /**
     * tests peek()
     */
    public void testPeek() {
        test.push("nathan");
        assertEquals("nathan", test.peek());
    }
}
