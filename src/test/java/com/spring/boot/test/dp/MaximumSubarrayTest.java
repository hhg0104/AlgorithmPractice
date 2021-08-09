package com.spring.boot.test.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum.

    A subarray is a contiguous part of an array.


    Example 1:

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Example 2:

    Input: nums = [1]
    Output: 1
    Example 3:

    Input: nums = [5,4,-1,7,8]
    Output: 23


    Constraints:

    1 <= nums.length <= 3 * 104
    -105 <= nums[i] <= 105


    Follow up: If you have figured out the O(n) solution,
    try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarrayTest {

    @Test
    public void test() {

        int actual1 = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        Assertions.assertEquals(6, actual1);

        int actual2 = maxSubArray(new int[]{1});
        Assertions.assertEquals(1, actual2);

        int actual3 = maxSubArray(new int[]{5, 4, -1, 7, 8});
        Assertions.assertEquals(23, actual3);
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
            ans = Math.max(ans, sum[i]);
        }

        return ans;
    }
}
