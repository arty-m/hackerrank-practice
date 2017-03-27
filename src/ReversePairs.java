import java.util.*;

/**
 * Class contains logic for reversing pairs
 */
public class ReversePairs {
    private int[] mArray;

    public ReversePairs(int[] arr) {
        mArray = arr;
    }

    public int reversePairs() {
        int[] nums = mArray;
        int length = nums.length;
        List<Integer> b = new ArrayList<>(length);
        for(int i=0; i<length; i++) {
            if(nums[i] < Integer.MAX_VALUE/2) {
                b.add(2*nums[i], i);
            } else if(nums[i] > Integer.MIN_VALUE && nums[i] < Integer.MIN_VALUE/2) {
                b.add(Integer.MIN_VALUE, i);
            } else {
                b.add(Integer.MAX_VALUE, i);
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
