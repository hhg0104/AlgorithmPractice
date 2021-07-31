package com.spring.boot.test.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSort {

    @Test
    public void test() {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        System.out.println(Arrays.toString(arr));
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
        swap(arr, i + 1, end);
        return (i + 1);
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
