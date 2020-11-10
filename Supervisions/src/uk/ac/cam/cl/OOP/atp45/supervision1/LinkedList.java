package uk.ac.cam.cl.OOP.atp45.supervision1;

public class LinkedList {
    Node header;
    int length;

    private class Node {
        int value;
        Node pointer;

        public Node(int value) {
            this.value = value;
            this.pointer = null;
        }

        public Node(int value, Node pointer) {
            this.value = value;
            this.pointer = pointer;
        }

        public int getValue() {
            return this.value;
        }

        public Node getPointer() {
            return this.pointer;
        }
    }

    public LinkedList(int[] arr) {
        length = arr.length;
        header = createLinkedList(arr);
    }

    public void prepend(int a) {
        int current_value = header.getValue();
        Node current_pointer = header.getPointer();
        Node current_Node = new Node(current_value, current_pointer);
        header = new Node(a, current_Node);
        length++;
    }

    public void pop() {
        length--;
        header = header.getPointer();
    }

    public int getNth(int n) {
        Node current_node = header;

        while (n > 0) {
            current_node = current_node.getPointer();
            n--;
        }

        return current_node.getValue();
    }

    public int queryHead() {
        return header.getValue();
    }

    public int getLength() {
        return length;
    }

    private Node createLinkedList(int[] arr) {
        if (arr.length > 1) {
            int[] rest = new int[arr.length - 1];
            for (int i = 1; i < arr.length; i++) {
                rest[i - 1] = arr[i];
            }

            return new Node(arr[0], createLinkedList(rest));
        } else {
            return new Node(arr[0]);
        }
    }
}
