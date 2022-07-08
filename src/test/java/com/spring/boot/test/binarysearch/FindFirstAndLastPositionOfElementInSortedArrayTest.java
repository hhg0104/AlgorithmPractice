package com.spring.boot.test.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Given an array of integers nums sorted in ascending order,
    find the starting and ending position of a given target value.

    If target is not found in the array, return [-1, -1].

    You must write an algorithm with O(log n) runtime complexity.


    Example 1:

    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
    Example 2:

    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]
    Example 3:

    Input: nums = [], target = 0
    Output: [-1,-1]


    Constraints:

    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
    nums is a non-decreasing array.
    -109 <= target <= 109

    Time complexity: 0(2logN) -> 0(logN)
    Space complexity: 0(1)
 */
public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    public void test() {

        int[] result1 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        Assertions.assertEquals(2, result1.length);
        Assertions.assertEquals(3, result1[0]);
        Assertions.assertEquals(4, result1[1]);

        int[] result2 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        Assertions.assertEquals(2, result2.length);
        Assertions.assertEquals(-1, result2[0]);
        Assertions.assertEquals(-1, result2[1]);

        int[] result3 = searchRange(new int[]{1, 4}, 4);
        Assertions.assertEquals(2, result3.length);
        Assertions.assertEquals(1, result3[0]);
        Assertions.assertEquals(1, result3[1]);

        int[] result4 = searchRange(new int[]{2, 2}, 1);
        Assertions.assertEquals(2, result4.length);
        Assertions.assertEquals(-1, result4[0]);
        Assertions.assertEquals(-1, result4[1]);

        int[] result5 = searchRange(new int[]{}, 0);
        Assertions.assertEquals(2, result5.length);
        Assertions.assertEquals(-1, result5[0]);
        Assertions.assertEquals(-1, result5[1]);
    }

    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int first = findFirst(nums, target, 0, nums.length - 1);
        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = findLast(nums, target, 0, nums.length - 1);
        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target, int start, int end) {

        if (end < start) {
            return -1;
        }

        if (end == start && nums[start] != target) {
            return -1;
        }

        int pivot = start + (end - start) / 2;

        if ((pivot == 0 || nums[pivot - 1] < target) && nums[pivot] == target) {
            return pivot;

        } else {
            if (nums[pivot] < target) {
                return findFirst(nums, target, pivot + 1, end);

            } else {
                return findFirst(nums, target, start, pivot - 1);
            }
        }
    }

    private int findLast(int[] nums, int target, int start, int end) {

        if (end < start) {
            return -1;
        }

        if (end == start && nums[start] != target) {
            return -1;
        }

        int pivot = start + (end - start) / 2;

        if ((pivot == nums.length - 1 || nums[pivot + 1] > target) && nums[pivot] == target) {
            return pivot;

        } else {
            if (nums[pivot] > target) {
                return findLast(nums, target, start, pivot - 1);

            } else {
                return findLast(nums, target, pivot + 1, end);
            }
        }
    }
}
