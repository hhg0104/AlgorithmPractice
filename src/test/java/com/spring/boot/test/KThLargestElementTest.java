package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class KThLargestElementTest {

    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        int ans = findKthLargest(nums, k);

        System.out.println(Arrays.toString(nums));
        Assertions.assertEquals(5, ans);
    }

    private int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }

        find(nums, 0, nums.length - 1, k);
        return nums[k - 1];
    }

    private void find(int[] nums, int start, int end, int k) {

        if (start >= end) {
            return;
        }

        int idx = partitionDesc(nums, start, end);

        if (idx + 1 == k) {
            return;
        }else if (idx + 1 > k) {
            find(nums, start, idx - 1, k);
        } else {
            find(nums, idx + 1, end, k);
        }
    }

    private int partitionDesc(int[] nums, int start, int end) {

        int pivot = nums[end];
        int i = start;

        for (int j = start; j < end; j++) {
            if (nums[j] > pivot) {
                swap(nums, i, j);
                i++;
            }
        }

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
