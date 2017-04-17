import utils.InputNumber;
import utils.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by Mihir on 01-02-2017.
 */
public class Output {

    public static void main(String[] args) {

//        ArrayDeque<InputNumber> numbers = createInputDequeue();
//        MultiThread multiThread = new MultiThread(numbers);
//        multiThread.processThreads();

        linkedListProblems();
    }

    private static void linkedListProblems() {
        ListNode node1 = new ListNode(1);
        node1.setNext(new ListNode(2));
        int i = 0;
        int j = 3;
        ListNode builder = node1.getNext();
        while (i < 5) {
            builder.setNext(new ListNode(j++));
            builder = builder.getNext();
            i++;
        }

        LinkedListProblems linkedList = new LinkedListProblems(node1);
        linkedList.print();
//        linkedList.deleteLastButOneNode();
        linkedList.reverseLinkedList();
        linkedList.print();
        linkedList.rotateLinkedList(4);
        System.out.println("After rotation at position 4");
        linkedList.print();
        System.out.println("Number of 4s are " + linkedList.count(4));
        System.out.println("The first node is " + linkedList.getNth(0));
        System.out.println("The fifth node is " + linkedList.getNth(4));
        System.out.println("Pop one node and value of it is " + linkedList.pop());
        linkedList.print();
        linkedList.push(1);
        linkedList.print();
        linkedList.insertNth(4,99);
        linkedList.print();

        LinkedListProblems sortedList = new LinkedListProblems(new ListNode(6));
        sortedList.push(4);
        sortedList.push(3);
        sortedList.push(2);
        sortedList.push(1);
        sortedList.print();
        sortedList.sortedInsert(new ListNode(5));
        sortedList.print();

        linkedList.insertSort();
        linkedList.print();

        linkedList.append(sortedList);
        linkedList.print();

        LinkedListProblems front = new LinkedListProblems(null);
        LinkedListProblems back = new LinkedListProblems(null);
        java.util.List<LinkedListProblems> list = linkedList.frontBackSplit(front, back);
        for (LinkedListProblems l : list) {
            l.print();
        }

        sortedList.sortedInsert(new ListNode(2));
        sortedList.sortedInsert(new ListNode(5));
        sortedList.sortedInsert(new ListNode(6));
        sortedList.sortedInsert(new ListNode(3));
        sortedList.sortedInsert(new ListNode(3));
        sortedList.print();

        sortedList.removeDuplicates();
        System.out.println("List after duplicates removed");
        sortedList.print();

        System.out.println("List before move node method");
        linkedList.print();
        linkedList.moveNode(sortedList);
        System.out.println("Lists after move node method");
        linkedList.print();
        sortedList.print();
        System.out.println("Lists after alternating split");
        front = new LinkedListProblems(null);
        back = new LinkedListProblems(null);
        list = linkedList.alternatingSplit(front, back);
        list.forEach(LinkedListProblems::print);

        linkedList = new LinkedListProblems();
        linkedList.shuffleMerge(list.get(0), list.get(1));
        linkedList.print();
    }

    private static void primeNumberProblems() {
        PrimeNumberUtil util = new PrimeNumberUtil(456);
        System.out.println("Number of prime numbers are " + util.giveNumberOfPrimes());
        util.print();
        int[] primes = PrimeNumberUtil.generatePrimes(456);
        System.out.println("Number of prime numbers are ---> " + primes.length);
        for(int i : primes) {
            System.out.print(primes[i] + "\t");
        }
    }

    private static void binaryTreeProblems() {
        BinaryTreeProblems problems = new BinaryTreeProblems();
        problems.build123M1();
        System.out.println("Size of tree " + problems.size());
        System.out.println("Max depth " + problems.maxDepth());
        System.out.println("Max depth " + problems.maxDepth(problems.getRoot().getLeft()));
        problems.build123M2();
        System.out.println("Size of tree " + problems.size());
        problems.build123M3();
        System.out.println("Size of tree " + problems.size());
    }

    private static void bstProblems() {
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
    }

    private static void add2NumbersProblems() {
        //ADD 2 linked lists
        ListNode l1 = new ListNode(2);
        l1.setNext(new ListNode(4));
        l1.getNext().setNext(new ListNode(3));

        ListNode l2 = new ListNode(5);
        l2.setNext(new ListNode(6));
        l2.getNext().setNext(new ListNode(4));

        AddTwoNumbers add2 = new AddTwoNumbers(l1, l2);
        ListNode sum = add2.sumOfTwoNumbers();
    }

    private static void longestSubstringProblems() {
        LongestSubstring s = new LongestSubstring();
        System.out.println("Zigzag string of 'PAYPALISHIRING 'is " + s.zigzagConversion("PAYPALISHIRING", 3));

        System.out.println("Is 'abbba' string palindrome? " + s.isPalindrome("abbba"));
        System.out.println("Is 'abba' string palindrome? " + s.isPalindrome("abba"));
        System.out.println("Is 'abcd' string palindrome? " + s.isPalindrome("abcd"));

        System.out.println("Longest palindrome in 'babad' " + s.longestPalindrome("babad"));
        System.out.println("Longest palindrome in 'a' " + s.longestPalindrome("a"));

        System.out.println("Longest palindrome in 'abcda' " + s.longestPalindromeDynamicProg("abcda"));
        System.out.println("Longest palindrome in 'a' " + s.longestPalindromeDynamicProg("a"));

        System.out.println("Is 'banana' a Pyramid Word? " + s.isPyramidWord("banana"));
        System.out.println("Is 'sass' a Pyramid Word? " + s.isPyramidWord("sass"));
    }

    private static void integerProblems() {
        IntegerProblems intProblems = new IntegerProblems(-123);
        System.out.println("reverse of 1 is "+ intProblems.reverseInteger());

        int[] result = intProblems.hashMapMethod(new int[]{3, 2, 4}, 6);
        System.out.println("The solution are " + Arrays.toString(result));

        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double average = intProblems.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median is " + average);
        nums2 = null;
        double avg2 = intProblems.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median is " + avg2);

        System.out.println("Reverse of 987 is " + intProblems.reverseNumber(987,3));
        System.out.println("Largest palindrome for 3 is " + intProblems.largestPalindrome(3));

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
