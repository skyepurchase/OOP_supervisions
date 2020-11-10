package uk.ac.cam.cl.OOP.atp45.supervision1;

public class Stack{
    LinkedList stack;

    public Stack(int[] arr) {
        stack = new LinkedList(arr);
    }

    public void push(int a) {
        stack.insert(a, 0);
    }

    public int pop() {
        int value = stack.queryHead();
        stack.delete(0);
        return value;
    }

    public int peak() {
        return stack.queryHead();
    }

    public int length() {
        return stack.getLength();
    }
}
