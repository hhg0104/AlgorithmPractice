package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
A rectangular map consisting of N rows and M columns of square areas is given.
Each area is painted with a certain color.
Two areas on the map belong to the same country if the following conditions are met:
The map can be described by a zero-indexed matrix A consisting of N rows and M columns of integers.
The color of each area is described by the corresponding element of the matrix.
Two areas have the same color if and only if their corresponding matrix elements have the same value.

For example, consider the following matrix A consisting of seven rows and three columns:
A[0][0] = 5;
        A[0][1] = 4;
        A[0][2] = 4;
        A[1][0] = 4;
        A[1][1] = 3;
        A[1][2] = 4;
        A[2][0] = 3;
        A[2][1] = 2;
        A[2][2] = 4;
        A[3][0] = 2;
        A[3][1] = 2;
        A[3][2] = 2;
        A[4][0] = 3;
        A[4][1] = 3;
        A[4][2] = 4;
        A[5][0] = 1;
        A[5][1] = 4;
        A[5][2] = 4;
        A[6][0] = 4;
        A[6][1] = 1;
        A[6][2] = 1;

        Matrix A describes a map that is colored with five colors.
        The areas on the map belong to eleven different countries (C1−C11), as shown in the following figure:
        Write a function that, given a zero-indexed matrix A consisting of N rows and M columns of integers,
        returns the number of different countries to which the areas of the map described by matrix A belong.

        For example, given matrix A consisting of seven rows and three columns corresponding to the example above,
        the function should return 11.
 */
public class CountMapColorArea {

    @Test
    public void testFindNum() {

        int[][] A = new int[7][3];
        A[0][0] = 5;
        A[0][1] = 4;
        A[0][2] = 4;
        A[1][0] = 4;
        A[1][1] = 3;
        A[1][2] = 4;
        A[2][0] = 3;
        A[2][1] = 2;
        A[2][2] = 4;
        A[3][0] = 2;
        A[3][1] = 2;
        A[3][2] = 2;
        A[4][0] = 3;
        A[4][1] = 3;
        A[4][2] = 4;
        A[5][0] = 1;
        A[5][1] = 4;
        A[5][2] = 4;
        A[6][0] = 4;
        A[6][1] = 1;
        A[6][2] = 1;

        int result1 = findAreaCount(A);
        Assertions.assertEquals(11, result1);
    }

    public int findAreaCount(int[][] A) {

        int rows = A.length;
        int columns = A[0].length;

        // copy array to check if the area already included
        int[][] checkArr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                checkArr[i][j] = A[i][j];
            }
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (checkArr[i][j] != -1) {
                    checkSide(A, checkArr, rows, columns, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void checkSide(int[][] arr, int[][] checkArr, int rows, int columns, int i, int j) {

        if (checkArr[i][j] == -1) {
            return;
        }

        checkArr[i][j] = -1;
        if (i + 1 < rows && arr[i + 1][j] == arr[i][j]) {
            checkSide(arr, checkArr, rows, columns, i + 1, j);
        }

        if (i - 1 >= 0 && arr[i - 1][j] == arr[i][j]) {
            checkSide(arr, checkArr, rows, columns, i - 1, j);
        }

        if (j + 1 < columns && arr[i][j + 1] == arr[i][j]) {
            checkSide(arr, checkArr, rows, columns, i, j + 1);
        }

        if (j - 1 >= 0 && arr[i][j - 1] == arr[i][j]) {
            checkSide(arr, checkArr, rows, columns, i, j - 1);
        }
    }
}
