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

  /*
   * Task: Implement a method that takes in a String parameter and returns a boolean indicating
   *       whether or not the input is a "pyramid word."
   *
   *       A word is a "pyramid word" if the letters it is made up of occur in a certain frequency.
   *       There must be exactly one letter that occurs exactly once in the word. Then there may be a
   *       different letter that occurs twice, another different letter that occurs three times, and
   *       so on.  The key is that no two letters should appear with the same frequency and there
   *       must be no gaps in the sequence (e.g. 1, 2, 4).
   *
   *  Examples:
   *
   * banana sleeveless
   *
   *   b       v
   *   nn      ll
   *  aaa     sss
   *          eeee
   *
   *
   *  Counter-examples:
   *     bandana - both the "b" and "d" occur once, and you can't have two different letters occurring
   *               the same number of times
   *     sass    - there is no letter that occurs two times, and you can't have a gap in the sequence
   */

    // Build a hash map with character counts
    // Since a Pyramid should have no repetitions, and it should be in increasing order, the counters should strictly
    // be in increasing order. If they are not, method returns false.
    boolean isPyramidWord(String s) {
        HashMap<Character,Integer> charCounter = new HashMap<>();
        for(int it=0; it<s.length(); it++) {
            char c = s.charAt(it);
            if(charCounter.containsKey(c)) {
                int val = charCounter.get(c);
                val++;
                charCounter.put(c, val);
            } else {
                charCounter.put(c,1);
            }
        }
        List<Integer> vals = new ArrayList<>();
        vals.addAll(charCounter.values());
        Collections.sort(vals);
        int i = vals.get(0);
        for(int val : vals) {
            if(val != i) {
                return false;
            }
            i++;
        }
        return true;
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