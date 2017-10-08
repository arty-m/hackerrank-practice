package utils;

import org.junit.Before;
import org.junit.Test;
import utils.exceptions.StackEmptyException;
import utils.exceptions.StackFullException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This is a unit test class for the Array Stack
 */
public class ArrayStackTest {

    private ArrayStack<Object> mStack;

    @Before
    public void init() {
        mStack = new ArrayStack<>(5);
    }

    @Test
    public void testIsEmpty() {
        assertTrue("Stack is currently empty", mStack.isEmpty());
        mStack.push(5);
        assertFalse("Stack is not empty", mStack.isEmpty());
    }

    @Test
    public void testSize() {
        assertTrue("Size is 0", mStack.size() == 0);
        mStack.push(1);
        assertTrue("Size is 1", mStack.size() == 1);
        mStack.push(1);
        assertTrue("Size is 2", mStack.size() == 2);
    }

    @Test
    public void testPushAndPopMakesSizeZero() {
        mStack.push(3);
        mStack.pop();
        assertTrue("Size is 0", mStack.size() == 0);
    }

    @Test(expected = StackEmptyException.class)
    public void testPopEmptyStackThrowsException() {
        mStack.pop();
    }

    @Test(expected = StackFullException.class)
    public void testPushToFullStackThrowsStackFullException() {
        mStack = new ArrayStack<>(0);
        mStack.push(10);
    }

    @Test
    public void testTopOfStack() {
        mStack.push(10);
        int top = (int) mStack.top();
        assertEquals("top element is expected to be 10", 10, top);
        assertTrue("Expect size to be 1", mStack.size()==1);
    }

    @Test(expected = StackEmptyException.class)
    public void testTopOfEmptyStack() {
        mStack = new ArrayStack<>(0);
        mStack.top();
    }

    @Test
    public void testPop() {
        mStack.push(10);
        int element = (int) mStack.pop();
        assertEquals("top element is expected to be 10", 10, element);
        assertTrue("Expect size to be 1", mStack.size() == 0);
    }

    @Test
    public void testLastInFirstOut() {
        mStack.push("first push");
        mStack.push("second push");

        String firstPop = (String) mStack.pop();
        String secondPop = (String) mStack.pop();
        assertEquals("First pop is second pushed", "second push", firstPop);
        assertEquals("Second pop is first pushed", "first push", secondPop);
    }

}
