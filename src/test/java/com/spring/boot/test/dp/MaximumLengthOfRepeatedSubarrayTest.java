package com.spring.boot.test.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

    Example 1:

    Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
    Output: 3
    Explanation: The repeated subarray with maximum length is [3,2,1].
    Example 2:

    Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
    Output: 5


    Constraints:

    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 100
 */
public class MaximumLengthOfRepeatedSubarrayTest {

    @Test
    public void test() {

        int actual1 = findLengthFromBack(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
        Assertions.assertEquals(3, actual1);

        int actual2 = findLengthFromBack(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0});
        Assertions.assertEquals(5, actual2);

        int actual3 = findLengthFromBack(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4});
        Assertions.assertEquals(3, actual3);
    }

    public int findLengthFromFront(int[] nums1, int[] nums2) {

        int[][] numsArr = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    numsArr[i + 1][j + 1] = numsArr[i][j] + 1;
                }
            }
        }

        int ans = 0;
        int maxIdx = 0;
        for (int i = 0; i < nums1.length + 1; i++) {
            for (int j = 0; j < nums2.length + 1; j++) {
                if (numsArr[i][j] > ans) {
                    ans = numsArr[i][j];
                    maxIdx = i - 1;
                }
            }
        }

        // extra work for printing out the maximum subarray
        printRepeatedSubarray(maxIdx, ans, nums1);

        return ans;
    }

    private void printRepeatedSubarray(int maxIdx, int maxCnt, int[] nums1) {
        List<String> ansList = new ArrayList<>();
        int start = maxIdx - maxCnt + 1;
        int end = maxIdx;
        for (int i = start; i <= end; i++) {
            ansList.add(String.valueOf(nums1[i]));
        }

        System.out.println(String.join(",", ansList));
    }

    public int findLengthFromBack(int[] nums1, int[] nums2) {

        int[][] numsArr = new int[nums1.length + 1][nums2.length + 1];

        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    numsArr[i][j] = numsArr[i + 1][j + 1] + 1;
                }
            }
        }

        int ans = 0;
        int maxIdx = 0;
        for (int i = 0; i < nums1.length + 1; i++) {
            for (int j = 0; j < nums2.length + 1; j++) {
                if (numsArr[i][j] > ans) {
                    ans = numsArr[i][j];
                    maxIdx = i;
                }
            }
        }

        // extra work for printing out the maximum subarray
        List<String> ansList = new ArrayList<>();
        for (int i = maxIdx; i < maxIdx + ans; i++) {
            ansList.add(String.valueOf(nums1[i]));
        }
        System.out.println(String.join(",", ansList));

        return ans;
    }
}
