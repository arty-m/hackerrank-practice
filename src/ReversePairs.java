import java.util.*;

/**
 * Class contains logic for reversing pairs
 */
public class ReversePairs {
    private int[] mArray;

    public ReversePairs(int[] arr) {
        mArray = arr;
    }

    // Example output that can be used
//
//    //This is for number of interesting reverse pairs problem
//    int[] input = {2147483647,2147483647,-2147483647,-2147483647,-2147483647, 2147483647};
//    ReversePairs r = new ReversePairs(input);
//        System.out.println("Number of interesting reverse pairs are "+ r.reversePairs());

    public int reversePairs() {
        int[] nums = mArray;
        int length = nums.length;
        List<Integer> b = new ArrayList<>(length);
        for(int i=0; i<length; i++) {
            if(nums[i] < Integer.MAX_VALUE/2) {
                b.add(2*nums[i]);
            } else if(nums[i] > Integer.MIN_VALUE && nums[i] < Integer.MIN_VALUE/2) {
                b.add(Integer.MIN_VALUE);
            } else {
                b.add(Integer.MAX_VALUE);
            }
        }


        int numberOfPairs = 0;

        for(int i=0; i<length; i++) {
            for(int j=i+1; i<j && j<length; j++) {
                if(nums[i] > b.get(j)) {
                    numberOfPairs++;
                }
            }
        }
        return numberOfPairs;
    }
}
