package utils;

/**
 * This class is an implementation of Stack ADT realized using arrays.
 */
public class ArrayStack<T> {

    private static final int CAPACITY = 20;

    private int mCapacity;

    private int mTop;

    private T[] mStack;

    ArrayStack(int cap) {
        mCapacity = cap;
        mTop = -1;
        mStack = (T[]) new Object[CAPACITY];
    }

    public int size() {
        return mTop + 1;
    }

    public boolean isEmpty() {
        return mTop < 0;
    }

    public T top() {
        if(isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        } else {
            return mStack[mTop];
        }
    }

    public T pop() {
        if(isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        } else {
            return mStack[mTop--];
        }
    }

    public void push(T t) {
        if(size() == mCapacity) {
            throw new StackFullException("Stack is full");
        } else {
            mStack[++mTop] = t;
        }
    }
}
