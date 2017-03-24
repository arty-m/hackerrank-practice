import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by Mihir on 02-02-2017.
 */
public class SetUsingArraysTest {

    private ISetUsingArrays mSet;

    protected void setUp() throws Exception {
        mSet = mock(ISetUsingArrays.class);
    }


    @Test
    public void testIsEmpty() throws Exception {
        mSet = mock(ISetUsingArrays.class);
        when(mSet.size()).thenReturn(1);
        assertTrue(!mSet.isEmpty());
        when(mSet.size()).thenReturn(0);
        assertTrue(!mSet.isEmpty());
    }


    public void size() throws Exception {

    }


    public void add() throws Exception {

    }


    public void contains() throws Exception {

    }


    public void print() throws Exception {

    }

}