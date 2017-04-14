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
        while( current !=null ) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        mRootNode = previous;
    }

    void rotateLinkedList(int a) {
        ListNode first = mRootNode; // The first node from the pivot
        int i = 0;
        ListNode pivot = null; // The node at which the list is rotated.
        // Move through the list until you find the pivot and the next nodes
        while (first != null && i < a) {
            pivot = first;
            first = first.getNext();
            i++;
        }
        pivot.setNext(null);// Since the Pivot becomes the tail and to avoid a loop, set the next to null
        ListNode reversedHead = null;
        //Reverse the nodes from first node since we are rotating the list from pivot
        if (first != null) {
            reversedHead = reverseList(first);
        }
        //Set the first node's next to the original list's head
        first.setNext(mRootNode);
        //Set the reversed list's head to be the current head
        mRootNode = reversedHead;
    }

    ListNode reverseList(ListNode n) {
        ListNode current = n;
        ListNode next = null, previous = null;
        while( current != null ) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
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
