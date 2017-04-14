import utils.ListNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mihir on 12-02-2017.
 */
public class AddTwoNumbers {

    private ListNode mNode1;

    private ListNode mNode2;

    public AddTwoNumbers(ListNode l1, ListNode l2) {
        mNode1 = l1;
        mNode2 = l2;
    }

    public ListNode sumOfTwoNumbers() {
        ListNode first = mNode1;
        ListNode second = mNode2;
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode current = result;
        int sum = 0;
        while(first!=null && second!=null) {
            int total = carry + first.getVal() + second.getVal();
            sum = total%10;
            carry = total/10;
            current.setVal(sum);
            ListNode a = new ListNode(0);
            current.setNext(a);
            first = first.getNext();
            second = second.getNext();
            current = current.getNext();
        }
//        result.setNext(new ListNode(first.getVal() + second.getVal() + carry));
        return result;
    }

    double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //When the arrays are either null or their length is zero
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return -1.0;
        }
        int length1 = (nums1 == null) ? 0 : nums1.length;
        int length2 = (nums2 == null) ? 0 : nums2.length;
        int length = length1 + length2;
        int[] combinedArray = new int[length];
        int i = 0, j = 0, k = 0;
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                combinedArray[k] = nums1[i];
                i++;
                k++;
            } else if (nums1[i] > nums2[j]) {
                combinedArray[k] = nums2[j];
                j++;
                k++;
            } else {
                combinedArray[k] = nums1[i];
                i++;
                j++;
                k++;
            }
        }

        while (i < length1) {
            combinedArray[k] = nums1[i];
            i++;
            k++;
        }

        while (j < length2) {
            combinedArray[k] = nums2[j];
            j++;
            k++;
        }
        int m1 = (length - 1) / 2;
        int m2 = length / 2;
        return (length % 2 != 0) ? combinedArray[m2] : (combinedArray[m1] + combinedArray[m2]) / 2.0;
    }
}
