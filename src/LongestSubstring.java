import java.util.*;

/**
 * Created by Mihir on 16-02-2017.
 */
public class LongestSubstring {

    public int longest(String s) {
        Set<Character> set = new LinkedHashSet<Character>();
        char[] charArray = s.toCharArray();
        int longest = 0;
        int n = s.length();
        for(int i=0, j=0; j<n; j++) {
            if(!set.contains(charArray[j])) {
                set.add(charArray[j++]);
                longest = Math.max(longest, j-i);
            } else {
                Character interested = charArray[i];
                Iterator<Character> iter = set.iterator();
                while (iter.hasNext()) {
                    Character c = iter.next();
                    i++;
                    if(c == interested) {
                        set.clear();
                        break;
                    }
                }
            }

        }
        return longest;
    }

    public int longestSlidingWindow(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, maxLength = 0;
        int n = s.length();
        while(i<n && j<n) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j-i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
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


    /**
     * Given a string and the number of rows, outputs the Zig Zag pattern string.
     * Original problem in https://leetcode.com/problems/zigzag-conversion/
     * @param input The input string
     * @param rows Number of rows used for zig zag
     * @return The zig zagged string
     */
    String zigzagConversion(String input, int rows) {
        if(rows == 1 || input.length() <= rows) {
            return input;
        }
        StringBuffer[] sb = new StringBuffer[rows];
        for(int i=0; i< rows; i++) {
            sb[i] = new StringBuffer();
        }
        int indexIncrementer = 1;
        int index = 0;
        for(int i=0;i<input.length();i++){
            sb[index].append(input.charAt(i));
            //Each character is added to the next row, so index should be incremented
            if(index == 0) {
                indexIncrementer = 1;
            }
            // If index is the last row, subsequent character should be added to the last but one row.
            // Also unless we reach the first row, the index should be decremented.
            if(index == rows-1) {
                indexIncrementer = -1;
            }
            index+=indexIncrementer;
        }

        for(int idx=1; idx<rows; idx++) {
            sb[0].append(sb[idx]);
        }
        System.out.println("Returned string is " + sb[0].toString());
        return sb[0].toString();
    }
}