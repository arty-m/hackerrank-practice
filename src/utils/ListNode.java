package utils;

/**
 * Created by Mihir on 12-02-2017.
 */
public class ListNode {
      private int val;
      private ListNode next;

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
