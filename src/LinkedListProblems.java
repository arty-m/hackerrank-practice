import utils.ListNode;

import java.util.List;

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

    /**
     * Method counts the number of occurrences of the given integer in the list and outputs the count
     * @param searchFor The number to search for in the list
     * @return an integer showing the number of occurrences of the given integer in the list
     */
    int count(int searchFor) {
        ListNode current = mRootNode;
        int count = 0;
        while (current != null) {
            if(current.getVal() == searchFor) {
                count++;
            }
            current = current.getNext();
        }
        return count;
    }

    /**
     * This method will return the value of the node at the position. Similar to [] operator for Arrays
     * If the list is empty, the method will throw an error with the appropriate message
     * If the index is more than the length of the list, the method will throw an error with appropriate message
     * @param index The index of the list at which the data needs to be retrieved
     * @return The integer value at the desired index
     */
    int getNth(int index) {
        ListNode current = mRootNode;
        int i = 0;
        while (current != null && i < index) {
            current = current.getNext();
            i++;
        }
        if(current != null)
            return current.getVal();
        else {
            if(i > 0) {
                throw new Error("Index is more than the length of the List");
            }
            throw new Error("List is empty");
        }
    }



    ListNode reverseList(ListNode n) {
        ListNode current = n;
        ListNode next, previous = null;
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
