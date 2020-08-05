/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix_java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author admin
 */
public class TestMatrix {
    public static void main(String[] args) {
        Matrix<Integer> matrix = new Matrix<>(new Integer[][]{{1,2,3},{2,3}});

        System.out.println(matrix);
    }
}
