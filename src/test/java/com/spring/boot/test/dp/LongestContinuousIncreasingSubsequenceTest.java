package com.spring.boot.test.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
    Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.

    A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].


    Example 1:

    Input: nums = [1,3,5,4,7]
    Output: 3
    Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
    Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
    4.
    Example 2:

    Input: nums = [2,2,2,2,2]
    Output: 1
    Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
    increasing.


    Constraints:

    1 <= nums.length <= 104
    -109 <= nums[i] <= 109

    Time complexity: O(n)
    Space complexity: O(n)
 */
public class LongestContinuousIncreasingSubsequenceTest {

    @Test
    public void test() {

        int actual1 = findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
        Assertions.assertEquals(3, actual1);

        int actual2 = findLengthOfLCIS(new int[]{2, 2, 2, 2, 2});
        Assertions.assertEquals(1, actual2);
    }

    public int findLengthOfLCIS(int[] nums) {

        int[] cntArr = new int[nums.length];
        Arrays.fill(cntArr, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cntArr[i] = cntArr[i - 1] + 1;
            }
        }

        int max = 0;
        for (int cnt : cntArr) {
            max = Math.max(max, cnt);
        }

        return max;
    }
}
