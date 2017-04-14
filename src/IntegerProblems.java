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
