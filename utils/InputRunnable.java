package utils;

import utils.InputNumber;

/**
 * Created by Mihir on 3/16/2017.
 */
public class InputRunnable implements Runnable {

    private InputNumber mInput;

    public InputRunnable(InputNumber n) {
        mInput = n;
    }

    @Override
    public void run() {
        int product = mInput.getA() * mInput.getB();
        System.out.println("The product of " + mInput.getA() + " and " + mInput.getB() + " is " + product);
    }
}
