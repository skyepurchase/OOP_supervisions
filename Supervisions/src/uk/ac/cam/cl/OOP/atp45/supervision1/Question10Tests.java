package uk.ac.cam.cl.OOP.atp45.supervision1;

import org.junit.Test;

public class Question10Tests {
    @Test
    public void lengthReturnsCorrectValue() {
        int[] arr = new int[]{1,2,3,4};
        Stack stack = new Stack(arr);

        assert stack.length() == 4;
    }

    @Test
    public void peakReturnsCorrectValue() {
        int[] arr = new int[]{1,2,3,4};
        Stack stack = new Stack(arr);

        assert stack.peak() == 1;
    }

    @Test
    public void popReturnsAndRemovesValue() {
        int[] arr = new int[]{1,2,3,4};
        Stack stack = new Stack(arr);

        assert stack.pop() == 1;
        assert stack.length() == 3;
        assert stack.peak() == 2;
    }

    @Test
    public void pushAddsValueCorrectly() {
        int[] arr = new int[]{1,2,3,4};
        Stack stack = new Stack(arr);

        stack.push(0);
        assert stack.length() == 5;
        assert stack.pop() == 0;
        assert stack.peak() == 1;
    }
}
