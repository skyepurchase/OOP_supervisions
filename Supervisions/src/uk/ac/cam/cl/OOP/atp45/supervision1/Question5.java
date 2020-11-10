package uk.ac.cam.cl.OOP.atp45.supervision1;

import java.util.Arrays;

public class Question5 {
    public static void main(String[] args) {
        float[][] matrix1 = arrayOfArrays(2);
        System.out.println(Arrays.deepToString(matrix1));
    }

    static float[][] arrayOfArrays(int n) {
        return new float[n][n];
    }
}
