import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Mihir on 10-02-2017.
 */
public class PrimeNumberUtil {
    private int mNumber;

    private Set<Integer> mCompositeNumberSet = new LinkedHashSet<>();
    private Set<Integer> mPrimeNumberSet = new LinkedHashSet<>();

    public PrimeNumberUtil(int n) {
        mNumber = n;
//        mEvenNumberSet.add(2);
//        mPrimeNumberSet.add(2);
    }

    public int giveNumberOfPrimes() {
        buildCompositeNumberSet();
//        buildPrimes();
        mPrimeNumberSet.clear();
        for(int i=2; i<= mNumber; i++) {
            if(isPrime(i)) {
                mPrimeNumberSet.add(i);
            }
        }
        return mPrimeNumberSet.size();
    }

    private void buildPrimes() {
        for(int i=2; i<mNumber; i++) {
            for(int n : mPrimeNumberSet) {
                if(! (i%n == 0)) {
                    mPrimeNumberSet.add(i);
                }
            }
        }
    }

    public boolean isPrime(int n) {
        for(int i=2; i<n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    private void buildCompositeNumberSet() {
        for(int i=2; i<mNumber; i++) {
            if(!mCompositeNumberSet.contains(i) && mNumber % i == 0) {
                addMultiplesToSet(i);
            }
        }
    }

    public static int [] generatePrimes(int max) {
        boolean[] isComposite = new boolean[max + 1];
        for (int i = 2; i * i <= max; i++) {
            if (!isComposite [i]) {
                for (int j = i; i * j <= max; j++) {
                    isComposite [i*j] = true;
                }
            }
        }
        int numPrimes = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) numPrimes++;
        }
        int [] primes = new int [numPrimes];
        int index = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) primes [index++] = i;
        }
        return primes;
    }

    private void addMultiplesToSet(int n) {
        int multiple = n;
        while(multiple < mNumber) {
            int counter = 1;
            mCompositeNumberSet.add(multiple);
            counter++;
            multiple = multiple*counter;;
        }
        for(int i=0; multiple<mNumber; i++) {
            multiple = multiple*i;
            mCompositeNumberSet.add(multiple);
        }
    }

    public void print() {
        System.out.println(String.format("The prime number until %d are:", mNumber));
        for(int i=2; i< mNumber; i++) {
            if(mCompositeNumberSet.contains(i)) {
                System.out.print(i + "\t");
            }
        }
        System.out.print("\n");
        System.out.println(String.format("The prime number until %d are:", mNumber));
        for(int i : mPrimeNumberSet) {
                System.out.print(i + "\t");
        }
        System.out.print("\n");
    }
}
