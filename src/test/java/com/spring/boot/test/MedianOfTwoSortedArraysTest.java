package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

/*
    Given two sorted arrays nums1 and nums2 of size m and n respectively,
    return the median of the two sorted arrays.

    The overall run time complexity should be O(log (m+n)).


    Example 1:

    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.
    Example 2:

    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    Example 3:

    Input: nums1 = [0,0], nums2 = [0,0]
    Output: 0.00000
    Example 4:

    Input: nums1 = [], nums2 = [1]
    Output: 1.00000
    Example 5:

    Input: nums1 = [2], nums2 = []
    Output: 2.00000


    Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArraysTest {

    @Test
    public void test() {

        float answer1 = getMedianOfTwoSortedArray3(new int[]{1, 3}, new int[]{2});
        Assertions.assertEquals(2, answer1);

        float answer2 = getMedianOfTwoSortedArray3(new int[]{1, 2}, new int[]{3, 4});
        Assertions.assertEquals(2.5f, answer2);

        float answer3 = getMedianOfTwoSortedArray3(new int[]{0, 0}, new int[]{0, 0});
        Assertions.assertEquals(0, answer3);

        float answer4 = getMedianOfTwoSortedArray3(new int[]{}, new int[]{1});
        Assertions.assertEquals(1, answer4);

        float answer5 = getMedianOfTwoSortedArray3(new int[]{2}, new int[]{});
        Assertions.assertEquals(2, answer5);

        float answer6 = getMedianOfTwoSortedArray3(new int[]{-5, 3, 6, 12, 15}, new int[]{-12, -10, -6, -3, 4, 10});
        Assertions.assertEquals(3, answer6);

        float answer7 = getMedianOfTwoSortedArray3(new int[]{2, 3, 5, 8}, new int[]{10, 12, 14, 16, 18, 20});
        Assertions.assertEquals(11, answer7);
    }

    private float getMedianOfTwoSortedArray(int[] nums1, int[] nums2) {

        int totalLength = nums1.length + nums2.length;
        int midIdx = totalLength / 2;

        int idx1 = 0;
        int idx2 = 0;

        int[] newArr = new int[midIdx + 1];
        int newIdx = 0;

        while (idx1 < nums1.length || idx2 < nums2.length) {

            Integer num1 = null;
            Integer num2 = null;

            if (idx1 < nums1.length) {
                num1 = nums1[idx1];
            }

            if (idx2 < nums2.length) {
                num2 = nums2[idx2];
            }

            if (num1 == null) {
                newArr[newIdx] = num2;
                idx2++;

            } else if (num2 == null) {
                newArr[newIdx] = num1;
                idx1++;

            } else {
                if (num1 > num2) {
                    newArr[newIdx] = num2;
                    idx2++;

                } else {
                    newArr[newIdx] = num1;
                    idx1++;
                }
            }

            if (midIdx == newIdx) {
                if (isOdd(totalLength)) {
                    return newArr[midIdx];

                } else {
                    int sum = (newArr[midIdx - 1] + newArr[midIdx]);
                    if (isOdd(sum)) {
                        return (sum / 2) + 0.5f;

                    } else {
                        return (sum / 2);
                    }
                }
            }

            newIdx++;
        }

        return -1;
    }

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }

    private float getMedianOfTwoSortedArray2(int[] nums1, int[] nums2) throws InvalidParameterException {

        int idx1 = 0;
        int idx2 = 0;

        int sumOfLength = nums1.length + nums2.length;
        int mid = sumOfLength / 2;

        int[] newArr = new int[mid + 1];
        int newArrIdx = 0;

        while (idx1 < nums1.length && idx2 < nums2.length && newArrIdx <= mid) {

            int num1 = nums1[idx1];
            int num2 = nums2[idx2];

            if (num1 < num2) {
                newArr[newArrIdx] = num1;
                idx1++;

            } else {
                newArr[newArrIdx] = num2;
                idx2++;
            }

            newArrIdx++;
        }

        while (idx1 < nums1.length && newArrIdx <= mid) {
            int num = nums1[idx1];
            newArr[newArrIdx] = num;

            idx1++;
            newArrIdx++;
        }

        while (idx2 < nums2.length && newArrIdx <= mid) {
            int num = nums2[idx2];
            newArr[newArrIdx] = num;

            idx2++;
            newArrIdx++;
        }

        if (isOdd(sumOfLength)) {
            return newArr[mid];

        } else {
            int sumOfVal = newArr[mid - 1] + newArr[mid];
            if (isOdd(sumOfVal)) {
                return sumOfVal / 2 + 0.5f;
            }
            return sumOfVal / 2;
        }
    }

    private float getMedianOfTwoSortedArray3(int[] nums1, int[] nums2) throws InvalidParameterException {

        int idx1 = 0;
        int idx2 = 0;

        int sumOfLength = nums1.length + nums2.length;
        int mid = sumOfLength / 2 + 1;

        int[] newArr = new int[mid];
        int newArrIdx = 0;

        while ((idx1 < nums1.length || idx2 < nums2.length) && newArrIdx < mid) {

            int num1 = (idx1 > nums1.length - 1) ? Integer.MAX_VALUE : nums1[idx1];
            int num2 = (idx2 > nums2.length - 1) ? Integer.MAX_VALUE : nums2[idx2];

            if (num1 < num2) {
                newArr[newArrIdx] = num1;
                idx1++;

            } else {
                newArr[newArrIdx] = num2;
                idx2++;
            }

            newArrIdx++;
        }

        if (isOdd(sumOfLength)) {
            return newArr[newArr.length - 1];

        } else {
            int sumOfVal = newArr[mid - 2] + newArr[mid - 1];
            if (isOdd(sumOfVal)) {
                return sumOfVal / 2 + 0.5f;
            }
            return sumOfVal / 2;
        }
    }
}
