package utils;

/**
 * Created by Mihir on 12-02-2017.
 */
public class ListNode {
      int val;
      ListNode next;

      public ListNode(int x) {
          val = x;
      }

      public ListNode getNext() {
          return next;
      }

      public int getVal() {
          return val;
      }

      public void setNext(ListNode e) {
          next = e;
      }

      public void setVal(int a) {
          val = a;
      }
}
