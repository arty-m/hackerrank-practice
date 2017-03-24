import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mihir on 12-02-2017.
 */
public class TwoSum {
    private int[] mInput;

    private int mTarget;

    public TwoSum(int[] nums, int target) {
        mInput = nums;
        mTarget = target;
    }

    public int[] bruteForceMethod() {
        for (int i=0; i<mInput.length; i++) {
            for(int j=i+1; j<mInput.length; j++) {
                if(mInput[j] == mTarget - mInput[i]) {
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    int[] hashMapMethod() {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<mInput.length; i++) {
            int complement =  Math.abs(mTarget - mInput[i]);
            map.put(complement,i);
        }
        for(int i=0; i<mInput.length; i++) {
            if(map.containsKey(mInput[i])) {
                    int n2ndone = map.get(mInput[i]);
                    if(i != n2ndone)
                        return new int[] {i, n2ndone};
                }
            }
        throw new IllegalArgumentException("No two sum solution");
    }
}
