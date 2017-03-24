/**
 * Created by Mihir on 11-02-2017.
 */
public class BinarySearchTree {
    int mCapacity;
    private Node mRoot;

    /*public BinarySearchTree(int n) {
        mCapacity = n;
    }*/

    public void insert(int n) {
        Node newNode = new Node(n);
        if(mRoot == null) {
            mRoot = newNode;
            return;
        }
        Node current = mRoot;
        Node parent = null;
        while(true) {
            parent = current;
            if(n == current.data) {
                return;
            }else if(n < current.data) {
                current = current.left;
                if(current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if(current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public boolean find(int n) {
        Node current = mRoot;
        while (true) {
            if (current == null) {
                return false;
            } else {
                if (n == current.data) {
                    return true;
                } else if (n < current.data) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
        }
    }

    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int n) {
            data = n;
            left = null;
            right = null;
        }
    }


}
