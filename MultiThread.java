import utils.InputNumber;
import utils.InputRunnable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Mihir on 3/16/2017.
 */
public class MultiThread {

    private static final int CAPACITY = 4;

    private List<Thread> mThreadList = new ArrayList<>(4);

    private Queue<InputNumber> mInputs;

    public MultiThread(ArrayDeque<InputNumber> queue) {
        mInputs = queue;
    }

    private Thread mCurrentThread;

    public void processThreads() {
        createInitialThreads();
        for(int i=0; i<mThreadList.size(); i++) {
            mThreadList.get(i).start();
        }
    }

    private void createInitialThreads() {
        if(mInputs.size() < CAPACITY) {
            createThread(mInputs.size());
        } else {
            createThread(CAPACITY);
        }
    }

    private void createThread(int n) {
        for(int i=0; i<n; i++) {
            if(!mInputs.isEmpty()) {
                mCurrentThread = new Thread(new InputRunnable(mInputs.remove()));
                mThreadList.add(mCurrentThread);
            }
        }
    }
}
