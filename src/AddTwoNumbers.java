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

    String longestPalindrome(String s) {
        int length = s.length();
        int longest = 0;
        String subString = "";
        for(int i=0; i<length; i++) {
            for(int j=i+1; j<length; j++) {
                String sub = s.substring(i,j);
                if(isPalindrome(sub)) {
                    if(longest < sub.length()) {
                        longest = sub.length();
                        subString = sub;
                    }
                }
            }
        }
        return subString;
    }

    String longestPalindromeDynamicProg(String s) {
        int length = s.length();
        if(length == 1) {
            return s;
        }
        boolean[][] table = new boolean[length][length];
        int longestBegin = 0;
        int maxLength = 1;
        for(int i=0; i<length; i++) {
            table[i][i] = true;
        }

        for(int i=0; i<length-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = true;
                longestBegin = i;
                maxLength = 2;
            }
        }

        for(int len=3; len <= length; len++) {
            for (int i=0; i<length-len+1; i++) {
                int j = i + len - 1;
                if((s.charAt(i) == s.charAt(j)) && table[i+1][j-1]) {
                    table[i][j] = true;
                    longestBegin = i;
                    maxLength = len;
                }
            }
        }

        return s.substring(longestBegin, longestBegin+maxLength);
    }

    boolean isPalindrome(String s) {
        int lenth = s.length();
        for(int i=0; i<lenth/2; i++) {
            if(s.charAt(i) != s.charAt(lenth-1-i)) {
                return false;
            }
        }
        return true;
    }

    void printPalindromes() {
        for(int i=10; i<=99; i++) {
            for(int j=10; j<=99; j++) {
                int prod = i*j;
                if(isPalindrome(String.valueOf(prod))) {
                    System.out.println(prod);
                }
            }
        }
    }

    int largestPalindrome(int n) {
        int powerOfTen = (int) Math.pow(10,n);
    int modNumber = 1337;
    int maxInt = powerOfTen - 1;
    long palindrome = maxInt * maxInt;
    int firstHalf = (int) palindrome/powerOfTen;
    int secondHalf = (int) palindrome % powerOfTen;
        if(firstHalf == reverseNumber(secondHalf, n)) {
        return (int) palindrome % modNumber;
    }
        /*if (firstHalf > secondHalf) {
            firstHalf--;
        }*/
    palindrome = (long) firstHalf*(long)powerOfTen + (long)reverseNumber(firstHalf, n);
        while(firstHalf != powerOfTen/10) {
        for (int i = maxInt; i*i > palindrome; i--) {
            if (palindrome % i == 0) {
                return (int) palindrome % modNumber;
            }
        }
        firstHalf--;
        palindrome = (long)firstHalf*(long)powerOfTen + (long)reverseNumber(firstHalf, n);
    }
        return (int) palindrome % modNumber;
}

    public int largestPal(int n) {
        if(n == 1) return 9;
        int m = 1337;
        int mod = (int)Math.pow(10, n);
        int max = (int)Math.pow(10, n)-1;
        long pro = (long)max*(long)max;
        int right = (int)(pro%mod);
        int left = (int)(pro/mod);
        if(left == reverseNumber(right,n)) return (int)(pro%m);
        if(left > right) {left--;}
        pro = (long)left*(long)mod+(long)reverseNumber(left,n);
        while(left != mod/10){
            for(int i = max;i>pro/i;i--){
                if(pro%i == 0 ) {
                    return (int)(pro%m);
                }
            }
            left--;
            pro = (long)left*(long)mod+(long)reverseNumber(left,n);
        }
        return (int)(pro%m);
    }

    int blah(String s) {
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();
        int length = s.length();
        for(int i=0; i<length/2; i++) {
            Character l = s.charAt(i);
            Character r = s.charAt(length-1 - i);
            if(left.containsKey(l)) {
//                left.
            }
        }

        return -1;
    }

    int reverseNumber(int n, int d) {
        int res = 0;
        int powOf10 = (int) Math.pow(10, d-1);
        while(n!=0) {
            int remainder = n%10;
            res += remainder*powOf10;
            powOf10 /= 10;
            n /= 10;
        }
        return res;
    }
}
