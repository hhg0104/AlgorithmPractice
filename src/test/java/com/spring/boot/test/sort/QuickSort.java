package com.spring.boot.test.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSort {

    @Test
    public void test() {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        System.out.println("Before: " + Arrays.toString(arr));
        quickSort(arr, 0, n - 1);
        System.out.println("After: " + Arrays.toString(arr));

        Assertions.assertEquals(6, arr.length);
        Assertions.assertEquals(1, arr[0]);
        Assertions.assertEquals(5, arr[1]);
        Assertions.assertEquals(7, arr[2]);
        Assertions.assertEquals(8, arr[3]);
        Assertions.assertEquals(9, arr[4]);
        Assertions.assertEquals(10, arr[5]);

    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);

            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];

        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        i++;
        swap(arr, i, end);

        return i;
    }

    private void swap(int[] arr, int idx1, int idx2) {
        if (idx1 == idx2) {
            return;
        }
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
