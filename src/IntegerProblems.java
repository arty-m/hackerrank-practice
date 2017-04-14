import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mihir on 3/26/2017.
 */
public class IntegerProblems {
    private int mInput;

    public IntegerProblems(int x) {
        mInput = x;
    }

    public int reverseInteger() {
        int result = 0;
        int x = mInput;
        while(x!=0) {
            int remainder = x % 10;
            int newResult = (result * 10) + remainder;
            if ((newResult - remainder)/10 != result) {
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int avg1 = 0, avg2 = 0;
        for(int i=0; i< nums1.length; i++) {
            avg1 += nums1[i];
        }
        avg1 = avg1/nums1.length;
        for(int i=0; i< nums2.length; i++) {
            avg2 += nums2[i];
        }
        avg2 = avg2/nums2.length;
        return (avg1 + avg2) / 2;
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

    public int[] bruteForceMethod(int[] input, int target) {
        for (int i=0; i<input.length; i++) {
            for(int j=i+1; j<input.length; j++) {
                if(input[j] == target - input[i]) {
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    int[] hashMapMethod(int[] input, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<input.length; i++) {
            int complement =  Math.abs(target - input[i]);
            map.put(complement,i);
        }
        for(int i=0; i<input.length; i++) {
            if(map.containsKey(input[i])) {
                int n2ndOne = map.get(input[i]);
                if(i != n2ndOne)
                    return new int[] {i, n2ndOne};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int myAtoi(String s) {
        int length = s.length();
        if (s.charAt(0) != '+' || s.charAt(0) != '-') {
            return 0;
        }
        char currentChar;
        boolean isNegative = false;
        int result = 0;
        currentChar = s.charAt(0);
        if(currentChar == '+') {
            isNegative = false;
        } else if(currentChar == '-') {
            isNegative = true;
        } else {
            result = (int)currentChar;
        }
        for(int i=1; i<length; i++) {
            currentChar = s.charAt(i);
//            if()
        }
        return result;
    }

    void makeTheNumbersMatch(int a, int b, int x, int y) {
        while(a != x || b != y) {
            if(a > x) {
                a--;
            } else if(a < x) {
                a++;
            }
            if(b > y) {
                b--;
            } else if(b < y){
                b++;
            }
        }
        System.out.println("The numbers are a=" + a + " b=" + b + " x=" + x + " y=" + y);
    }
}
