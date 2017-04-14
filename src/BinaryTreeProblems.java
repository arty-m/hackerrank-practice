import utils.Node;

/**
 * Class contains methods to solve the problems listed in the Stanford CS Library Binary Tree Problems
 * See <a href="http://cslibrary.stanford.edu/110/BinaryTrees.html">Binary Trees</a>
 */
public class BinaryTreeProblems {

    private Node mRoot;

    void build123M1() {
        mRoot = null;
        mRoot = new Node(2);
        Node n2 = new Node(1);
        Node n3 = new Node(3);
        mRoot.setLeft(n2);
        mRoot.setRight(n3);
        printTreeInOrder();
    }

    void build123M2() {
        mRoot = null;
        mRoot = new Node(2);
        mRoot.setLeft(new Node(1));
        mRoot.setRight(new Node(3));
        printTreeInOrder();
    }

    void build123M3() {
        mRoot = null;
        insert(2);
        insert(1);
        insert(3);
        printTreeInOrder();
    }

    int size() {
        return size(mRoot);
    }

    int maxDepth() {
        return maxDepth(mRoot);
    }

    private int size(Node n) {
        if(n == null) {
            return 0;
        }
        else {
            return (size(n.getLeft()) + 1 + size(n.getRight()));
        }
    }

    public int maxDepth(Node n) {
        if(n == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(n.getLeft()), maxDepth(n.getRight()));
        }
    }

    public void insert(int d) {
        mRoot = insert(mRoot, d);
    }

    private Node insert(Node n, int data) {
        if(n == null) {
            n = new Node(data);
        } else {
            if(data <= n.getData()) {
                n.setLeft(insert(n.getLeft(), data));
            } else {
                n.setRight(insert(n.getRight(), data));
            }
        }
        return n;
    }

    void printTreeInOrder() {
        printTreeInOrder(mRoot);
    }

    void printTreeInOrder(Node n) {
        if(n != null) {
            System.out.print(n.getData());
            if(n.getLeft() != null)
                System.out.print(n.getLeft().getData());
            if(n.getRight() != null)
                System.out.print(n.getRight().getData());
            System.out.println();
            printTreeInOrder(n.getLeft().getLeft());
            printTreeInOrder(n.getRight().getRight());
        }
    }

    public Node getRoot() {
        return mRoot;
    }
}
