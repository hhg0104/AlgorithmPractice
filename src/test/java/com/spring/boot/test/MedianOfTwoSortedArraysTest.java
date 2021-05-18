package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        float answer1 = getMedianOfTwoSortedArray(new int[]{1, 3}, new int[]{2});
        Assertions.assertEquals(2, answer1);

        float answer2 = getMedianOfTwoSortedArray(new int[]{1, 2}, new int[]{3, 4});
        Assertions.assertEquals(2.5f, answer2);

        float answer3 = getMedianOfTwoSortedArray(new int[]{0, 0}, new int[]{0, 0});
        Assertions.assertEquals(0, answer3);

        float answer4 = getMedianOfTwoSortedArray(new int[]{}, new int[]{1});
        Assertions.assertEquals(1, answer4);

        float answer5 = getMedianOfTwoSortedArray(new int[]{2}, new int[]{});
        Assertions.assertEquals(2, answer5);

        float answer6 = getMedianOfTwoSortedArray(new int[]{-5, 3, 6, 12, 15}, new int[]{-12, -10, -6, -3, 4, 10});
        Assertions.assertEquals(3, answer6);

        float answer7 = getMedianOfTwoSortedArray(new int[]{2, 3, 5, 8}, new int[]{10, 12, 14, 16, 18, 20});
        Assertions.assertEquals(11, answer7);
    }

    private float getMedianOfTwoSortedArray(int[] arr1, int[] arr2) {

        int totalLength = arr1.length + arr2.length;
        int midIdx = totalLength / 2;

        int idx1 = 0;
        int idx2 = 0;

        int[] newArr = new int[midIdx + 1];
        int newIdx = 0;

        while (idx1 < arr1.length || idx2 < arr2.length) {

            Integer num1 = null;
            Integer num2 = null;

            if (idx1 < arr1.length) {
                num1 = arr1[idx1];
            }

            if (idx2 < arr2.length) {
                num2 = arr2[idx2];
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
}
