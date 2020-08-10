package main.java.com.jatrix;

import java.util.Arrays;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(new double[][]{
                {5,6,7,8},
                {3,1,-4,0},
                {2,2,5,-4},
                {0,-5,-10,9},
        });


        System.out.println("Current matrix: ");
        System.out.println(m1);

        Matrix[] matrices = StrassenMultiplication.split(m1);
        for (int i = 0; i < matrices.length; i++) {
            System.out.println(matrices[i]+"\n");
        }

        Matrix joinedMatrix = StrassenMultiplication.join(matrices[0],matrices[1],matrices[2],matrices[3]);

        System.out.println(joinedMatrix.equals(m1));


    }
}
