package com.spring.boot.test.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSort {

    @Test
    public void test() {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        System.out.println("Before: " + Arrays.toString(arr));
        randomizedQuickSort(arr, 0, n - 1);
        System.out.println("After: " + Arrays.toString(arr));

        Assertions.assertEquals(6, arr.length);
        Assertions.assertEquals(1, arr[0]);
        Assertions.assertEquals(5, arr[1]);
        Assertions.assertEquals(7, arr[2]);
        Assertions.assertEquals(8, arr[3]);
        Assertions.assertEquals(9, arr[4]);
        Assertions.assertEquals(10, arr[5]);

    }

    private void randomizedQuickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        random(nums, start, end);

        int position = partition(nums, start, end);

        randomizedQuickSort(nums, start, position - 1);
        randomizedQuickSort(nums, position + 1, end);
    }

    private void random(int[] nums, int start, int end) {
        int pivot = new Random().nextInt(end - start) + start;
        int temp = nums[pivot];
        nums[pivot] = nums[end];
        nums[end] = temp;
    }

    private int partition(int[] nums, int start, int end){

        int pivot  = nums[end];
        int i = start - 1;
        for (int j = 0; j < end; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        i++;
        swap(nums, i, end);
        return i;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        if (idx1 == idx2) {
            return;
        }

        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
