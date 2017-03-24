/**
 * This class in an implementation of Set data structure using arrays
 */
public class SetUsingArrays implements ISetUsingArrays{

    private int mCapacity = 0;

    private int[] mArray = null;

    SetUsingArrays(int... args) {
        int size = args.length;
        mArray = new int[size];
        for (int a : args) {
            mArray[mCapacity++] = a;
        }
    }

    public boolean isEmpty() {
        return (mArray == null || this.size() == 0);
    }

    public int size() {
        return mCapacity;
    }

    public void add(int var) {
        if(isEmpty() || !contains(var)) {
            int[] a = new int[mCapacity + 1];
            int i = 0;
            for (int e : mArray) {
                a[i++] = e;
            }
            a[mCapacity] = var;
            mCapacity++;
            mArray = a;
        } else {
            System.out.println("\nSorry the set already contains the element " + var);
        }
    }

    public boolean contains(int var) {
        for(int a : mArray) {
            if(a == var) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        System.out.println("\nI am printing all elements");
        for (int a : mArray) {
            System.out.print(a +", ");
        }
    }


}
