import utils.ListNode;

import java.util.Hashtable;

/**
 * Created by Mihir on 3/12/2017.
 */
public class LinkedListQs {

    public void removeDuplicates(ListNode head) {
        Hashtable table = new Hashtable();
        ListNode previous = null;
        ListNode n = head;
        while(n != null) {
            if(table.containsKey(n.getVal())) {
                previous.setNext(n.getNext());
            } else {
                table.put(n.getVal(), true);
                previous = n;
            }
            n = n.getNext();
        }
    }


}
