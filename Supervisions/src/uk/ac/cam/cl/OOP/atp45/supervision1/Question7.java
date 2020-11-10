package uk.ac.cam.cl.OOP.atp45.supervision1;

public class Question7 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        LinkedList list = new LinkedList(arr);

        System.out.println(list.queryHead());
        // 1
        System.out.println(list.getNth(2));
        // 3
        System.out.println(list.getLength());
        // 4
        list.pop();
        System.out.println(list.getLength());
        // 3
        System.out.println(list.queryHead());
        // 2
        list.prepend(0);
        System.out.println(list.getLength());
        // 4
        System.out.println(list.queryHead());
        // 0
    }
}
