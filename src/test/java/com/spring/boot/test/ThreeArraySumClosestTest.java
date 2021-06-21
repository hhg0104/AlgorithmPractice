package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.Arrays;

/*
    Given an array nums of n integers and an integer target,
    find three integers in nums such that the sum is closest to target.
    Return the sum of the three integers. You may assume that each input would have exactly one solution.

    Example 1:

    Input: nums = [-1,2,1,-4], target = 1
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


    Constraints:

    3 <= nums.length <= 10^3
    -10^3 <= nums[i] <= 10^3
    -10^4 <= target <= 10^4
 */
public class ThreeArraySumClosestTest {

    @Test
    public void test() {

        int actual1 = threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        Assertions.assertEquals(2, actual1);

        int actual2 = threeSumClosest(new int[]{-1, 0, 1, 1, 55}, 3);
        Assertions.assertEquals(2, actual2);
    }

    // O(nlogn + n^2) -> (n^2)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];

                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }

                if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return target - diff;
    }
}
