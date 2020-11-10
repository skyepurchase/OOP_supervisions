package uk.ac.cam.cl.OOP.atp45.supervision1;

public class LinkedList {
    Node header;
    int length;

    private static class Node {
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

        public void setPointer(Node n) {
            this.pointer = n;
        }
    }

    public LinkedList(int[] arr) {
        length = arr.length;
        header = createLinkedList(arr);
    }

    public void insert(int a, int n) {
        if (n == 0) {
            header = new Node(a, header);
        } else {
            Node previous_node = header;
            Node next_node = header.getPointer();

            while ((next_node != null) && (n>1)) {
                previous_node = next_node;
                next_node = next_node.getPointer();
                n--;
            }

            previous_node.setPointer(new Node(a, next_node));
        }
        length++;
    }

    public void delete(int n) {
        if (n == 0) {
            header = header.getPointer();
            length--;
        } else {
            Node previous_node = header;
            Node current_node = header.getPointer();

            while ((current_node != null) && (n>1)) {
                previous_node = current_node;
                current_node = current_node.getPointer();
                n--;
            }

            if (current_node != null) {
                previous_node.setPointer(current_node.getPointer());
                length--;
            }
        }
    }

    public int getNth(int n) {
        Node current_node = header;

        while ((current_node.getPointer() != null) && (n > 0)) {
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
            System.arraycopy(arr, 1, rest, 0, arr.length - 1);

            return new Node(arr[0], createLinkedList(rest));
        } else {
            return new Node(arr[0]);
        }
    }
}
