import utils.ListNode;

/**
 * Linked List problems class
 */
public class LinkedListProblems {
    private ListNode mRootNode;

    public LinkedListProblems(ListNode node) {
        mRootNode = node;
    }

    void deleteLastButOneNode() {
        ListNode n = mRootNode;
        int i = 0;
        while(n != null) {
            i++;
            n = n.getNext();
        }
        ListNode previous = mRootNode;
        n = mRootNode;
        for(int j = 0; j<i-2; j++) {
            previous = n;
            n = n.getNext();
        }
        previous.setNext(n.getNext());
        print();
    }

    void reverseLinkedList() {
        ListNode current = mRootNode;
        ListNode next = null, previous = null;
        while( current!=null ) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        mRootNode = previous;
    }

    void print() {
        ListNode n = mRootNode;
        while(n != null) {
            System.out.print(n.getVal()+"->");
            n = n.getNext();
        }
        System.out.println();
    }
}
