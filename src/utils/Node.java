package utils;

/**
 * A Node class that would be used for building Binary Trees
 */
public class Node {

    private int mData;

    private Node mLeft;

    private Node mRight;

    public Node (int d) {
        mData = d;
    }

    public int getData() {
        return mData;
    }

    public void setData(int mData) {
        this.mData = mData;
    }

    public Node getLeft() {
        return mLeft;
    }

    public void setLeft(Node mLeft) {
        this.mLeft = mLeft;
    }

    public Node getRight() {
        return mRight;
    }

    public void setRight(Node mRight) {
        this.mRight = mRight;
    }
}
