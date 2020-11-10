package uk.ac.cam.cl.OOP.atp45.supervision1;


import org.junit.Test;

public class Question7Tests {

    @Test
    public void getNthReturnsCorrectValues() {
        int[] arr = new int[]{1,2,3,4};
        LinkedList list = new LinkedList(arr);

        assert list.getNth(0) == 1;
        assert list.getNth(1) == 2;
        assert list.getNth(2) == 3;
        assert list.getNth(3) == 4;
    }

    @Test
    public void getLengthReturnsCorrectValue() {
        int[] arr = new int[]{1,2,3,4};
        LinkedList list = new LinkedList(arr);

        assert list.getLength() == 4;
    }

    @Test
    public void queryHeadReturnsCorrectValue() {
        int[] arr = new int[]{1,2,3,4};
        LinkedList list = new LinkedList(arr);

        assert list.queryHead() == 1;
    }

    @Test
    public void insertValueInCorrectLocation() {
        int[] arr = new int[]{1,2,3,4};
        LinkedList list = new LinkedList(arr);

        list.insert(0, 0);
        assert list.queryHead() == 0;
        assert list.getNth(1) == 1;
        assert list.getLength() == 5;

        list.insert(5, 5);
        assert list.getNth(5) == 5;
        assert list.getLength() == 6;

        list.insert(25, 3);
        assert list.getNth(2) == 2;
        assert list.getNth(3) == 25;
        assert list.getNth(4) == 3;
        assert list.getLength() == 7;
    }

    @Test
    public void deleteRemovesCorrectValues() {
        int[] arr = new int[]{1,2,3,4};
        LinkedList list = new LinkedList(arr);

        list.delete(0);
        assert list.queryHead() == 2;
        assert list.getLength() == 3;

        list.delete(1);
        assert list.queryHead() == 2;
        assert list.getNth(1) == 4;
        assert list.getLength() == 2;

        list.delete(1);
        assert list.queryHead() == 2;
        assert list.getLength() == 1;
    }
}
