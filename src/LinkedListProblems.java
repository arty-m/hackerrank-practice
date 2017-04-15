import utils.ListNode;

import java.util.ArrayList;
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
        if(mRootNode == null) {
            return;
        } else {
            ListNode first = mRootNode; // The first node from the pivot
            int i = 0;
            ListNode pivot = first; // The node at which the list is rotated.
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

                //Set the first node's next to the original list's head
                first.setNext(mRootNode);
                //Set the reversed list's head to be the current head
                mRootNode = reversedHead;
            }
        }
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

    int pop() {
        ListNode popNode = mRootNode;
        if(popNode != null) {
            mRootNode = popNode.getNext();
            return popNode.getVal();
        }
        throw new Error("The list is empty");
    }

    void push(int a) {
        ListNode pushNode = new ListNode(a);
        pushNode.setNext(mRootNode);
        mRootNode = pushNode;
    }

    void insertNth(int index, int data) {
        ListNode current = mRootNode;
        if(current != null) {
            if (index == 0) {
                push(data);
                return;
            }
            int i = 0;
            ListNode previous = null;
            while(i < index) {
                i++;
                previous = current;
                current = current.getNext();
            }
            ListNode newNode = new ListNode(data);
            if (previous != null) {
                previous.setNext(newNode);
                newNode.setNext(current);
            }
        } else {
            mRootNode = new ListNode(data);
        }
    }

    private ListNode reverseList(ListNode n) {
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

    void sortedInsert(ListNode node) {
        ListNode current = mRootNode;
        ListNode previous = null;
        int v = node.getVal();
        while (current != null && current.getVal() < v) {
            previous = current;
            current = current.getNext();
        }
        if(previous != null) {
            node.setNext(current);
            previous.setNext(node);
        } else {
            node.setNext(mRootNode);
            mRootNode = node;
        }
    }

    void insertSort() {
        ListNode n = mRootNode;
        LinkedListProblems sorted = new LinkedListProblems(new ListNode(n.getVal()));
        while (n != null) {
            sorted.sortedInsert(new ListNode(n.getVal()));
            n = n.getNext();
        }
        mRootNode = sorted.mRootNode.getNext();
    }

    void append(LinkedListProblems list2) {
        if(mRootNode != null) {
            ListNode current = mRootNode;
            ListNode previous = current;
            while (current != null) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(list2.mRootNode);
        } else {
            mRootNode = list2.mRootNode;
        }
    }

    List<LinkedListProblems> frontBackSplit(LinkedListProblems front, LinkedListProblems back) {
        List<LinkedListProblems> list = new ArrayList<>();
        list.add(front);
        list.add(back);
        if(mRootNode == null || mRootNode.getNext() == null) {
            front.mRootNode = mRootNode;
            back.mRootNode = null;
            return list;
        } else {
            ListNode slow = mRootNode, fast = mRootNode.getNext();
            while (fast != null) {
                fast = fast.getNext();
                if(fast != null) {
                    slow = slow.getNext();
                    fast = fast.getNext();
                }
            }
            back.mRootNode = slow.getNext();
            slow.setNext(null);
            front.mRootNode = mRootNode;
            return list;
        }
    }

    void removeDuplicates() {
        if(mRootNode == null) {
            return;
        }
        ListNode current = mRootNode.getNext();
        ListNode previous = mRootNode;
        while (current != null) {
            if (previous.getVal() == current.getVal()) {
                previous.setNext(current.getNext());
                current = previous.getNext();
            } else {
                previous = current;
                current = current.getNext();
            }
        }
    }

    void moveNode(LinkedListProblems source) {
        ListNode moveNode = source.getRoot();
        if (moveNode.getNext() != null) {
            ListNode next = moveNode.getNext();
            this.push(moveNode);
            source.setRoot(next);
        } else {
            this.push(moveNode);
            source.setRoot(null);
        }
    }

    private void push(ListNode moveNode) {
        moveNode.setNext(mRootNode);
        mRootNode = moveNode;
    }

    /**
     * Method iterates over the source list and use {@link #moveNode(LinkedListProblems)} to pull nodes off
     * the source and alternately put them on 'first' and 'second'. The only strange part is that the nodes
     * will be in the reverse order that they occurred in the source list.
     * @param first First list which will be populated
     * @param second Second list which will be populated
     * @return A list containing the newly created lists, first and second
     */
    List<LinkedListProblems> alternatingSplit(LinkedListProblems first, LinkedListProblems second) {
        List<LinkedListProblems> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        int i = 1;
        while (this.getRoot() != null) {
            if (i % 2 != 0) {
                first.moveNode(this);
            } else {
                second.moveNode(this);
            }
            i++;
        }
        return list;
    }

    List<LinkedListProblems> alternatingSplitPreserveOrder(LinkedListProblems first, LinkedListProblems second) {
        List<LinkedListProblems> list = new ArrayList<>();
        list.add(first);
        list.add(second);

        return list;
    }

    public ListNode getRoot() {
        return mRootNode;
    }

    public void setRoot(ListNode root) {
        this.mRootNode = root;
    }
}
