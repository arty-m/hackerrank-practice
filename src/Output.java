import utils.InputNumber;
import utils.ListNode;
import utils.Node;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by Mihir on 01-02-2017.
 */
public class Output {

    public static void main(String[] args) {
        SetUsingArrays mSet = new SetUsingArrays(1,2,3,4);
        SetUsingArrays mSet2 = new SetUsingArrays();
        System.out.println("Is this set empty? " + mSet.isEmpty());
        System.out.println("Is this set empty? " + mSet2.isEmpty());
//        mSet.print();
        mSet.add(5);
        mSet.add(5);
//        mSet.print();

//        PrimeNumberUtil util = new PrimeNumberUtil(456);
//        System.out.println("Number of prime numbers are " + util.giveNumberOfPrimes());
//        util.print();
//        int[] primes = util.generatePrimes(456);
//        System.out.println("Number of prime numbers are ---> " + primes.length);
//        for(int i=0; i< primes.length; i++) {
//            System.out.print(primes[i] + "\t");
//        }

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(6);
        bst.insert(2);
        bst.insert(7);
        int n = 6;
        System.out.println(String.format("Searching for %d in the BST and is the element is present? %b", n, bst.find(n)));
        n = 10;
        System.out.println(String.format("Searching for %d in the BST and is the element is present? %b", n, bst.find(n)));
        n = 2;
        System.out.println(String.format("Searching for %d in the BST and is the element is present? %b", n, bst.find(n)));

        TwoSum ts = new TwoSum(new int[]{3, 2, 4}, 6);
        int[] result = ts.hashMapMethod();
        System.out.println("The solution are " + Arrays.toString(result));

        ListNode l1 = new ListNode(2);
        l1.setNext(new ListNode(4));
        l1.getNext().setNext(new ListNode(3));

        ListNode l2 = new ListNode(5);
        l2.setNext(new ListNode(6));
        l2.getNext().setNext(new ListNode(4));

        AddTwoNumbers add2 = new AddTwoNumbers(l1, l2);
        ListNode sum = add2.sumOfTwoNumbers();

        LongestSubstring s = new LongestSubstring();
        int length = s.longest("pwwkew");
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double average = s.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median is " + average);
        nums2 = null;
        double avg2 = add2.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median is " + avg2);

        System.out.println("Is 'abbba' string palindrome? " + add2.isPalindrome("abbba"));
        System.out.println("Is 'abba' string palindrome? " + add2.isPalindrome("abba"));
        System.out.println("Is 'abcd' string palindrome? " + add2.isPalindrome("abcd"));

        System.out.println("Longest palindrome in 'babad' " + add2.longestPalindrome("babad"));
        System.out.println("Longest palindrome in 'a' " + add2.longestPalindrome("a"));

        System.out.println("Longest palindrome in 'abcda' " + add2.longestPalindromeDynamicProg("abcda"));
        System.out.println("Longest palindrome in 'a' " + add2.longestPalindromeDynamicProg("a"));

        System.out.println("Reverse of 987 is " + add2.reverseNumber(987,3));
        System.out.println("Largest palindrome for 3 is " + add2.largestPalindrome(3));

//        ArrayDeque<InputNumber> numbers = createInputDequeue();
//        MultiThread multiThread = new MultiThread(numbers);
//        multiThread.processThreads();

        System.out.println("Zigzag string of 'PAYPALISHIRING 'is " + s.zigzagConversion("PAYPALISHIRING", 3));

        //This is for number of interesting reverse pairs problem
        int[] input = {2147483647,2147483647,-2147483647,-2147483647,-2147483647, 2147483647};
        ReversePairs r = new ReversePairs(input);
        System.out.println("Number of interesting reverse pairs are "+ r.reversePairs());

        IntegerProblems intProblems = new IntegerProblems(-123);
        System.out.println("reverse of 1 is "+ intProblems.reverseInteger());

        System.out.println("Is 'banana' a Pyramid Word? " + s.isPyramidWord("banana"));
        System.out.println("Is 'sass' a Pyramid Word? " + s.isPyramidWord("sass"));

        BinaryTreeProblems problems = new BinaryTreeProblems();
        problems.build123M1();
        System.out.println("Size of tree " + problems.size());
        System.out.println("Max depth " + problems.maxDepth());
        System.out.println("Max depth " + problems.maxDepth(problems.getRoot().getLeft()));
        problems.build123M2();
        System.out.println("Size of tree " + problems.size());
        problems.build123M3();
        System.out.println("Size of tree " + problems.size());

        intProblems.makeTheNumbersMatch(10, 7, 3, 14);
        intProblems.makeTheNumbersMatch(7, 10, 3, 14);

        intProblems.makeTheNumbersMatch(10, 10, 3, 14);
    }

    private static ArrayDeque<InputNumber> createInputDequeue() {
        ArrayDeque<InputNumber> deque = new ArrayDeque<>();
        for(int i=0; i<30; i++) {
            deque.add(new InputNumber(10, i));
        }
        return deque;
    }
}
