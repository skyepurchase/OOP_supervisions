package uk.ac.cam.cl.OOP.atp45.supervision1;

import java.util.Arrays;

public class Question4 {
    public static void main(String[] args) {
        int[] array = new int[]{-1,2,-3,4,5};
        System.out.println(sum(array));
        System.out.println(Arrays.toString(cumSum(array)));
        System.out.println(Arrays.toString(positive(array)));
    }

    private static int sum(int[] a) {
        int acc = 0;

        for (int i : a) {
            acc = acc + i;
        }

        return acc;
    }

    private static int[] cumSum(int[] a) {
        int[] result = new int[a.length];
        int acc = 0;
        int i = 0;

        while (i < a.length) {
            acc = acc + a[i];
            result[i] = acc;
            i++;
        }

        return result;
    }

    private static int[] positive(int[] a) {
        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            int v = a[i];
            if (v >= 0) {
                result[i] = v; 
            }
        }

        return result;
    }
}
