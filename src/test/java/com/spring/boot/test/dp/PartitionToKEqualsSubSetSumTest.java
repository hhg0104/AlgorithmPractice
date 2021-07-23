package com.spring.boot.test.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Given an integer array nums and an integer k,
    return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.


    Example 1:

    Input: nums = [4,3,2,3,5,2,1], k = 4
    Output: true
    Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
    Example 2:

    Input: nums = [1,2,3,4], k = 3
    Output: false


    Constraints:

    1 <= k <= nums.length <= 16
    1 <= nums[i] <= 104
    The frequency of each element is in the range [1, 4].

    Time complexity:
    Space complexity:
 */
public class PartitionToKEqualsSubSetSumTest {

    @Test
    public void test() {

        boolean actual1 = canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
        Assertions.assertEquals(true, actual1);

        boolean actual2 = canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3);
        Assertions.assertEquals(false, actual2);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {

        if (nums.length == 0) {
            return false;
        }

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % k != 0) {
            return false;
        }

        return canPartition(nums, new boolean[nums.length], total / k, 0, 0, k);
    }

    private boolean canPartition(int[] nums, boolean[] visited, int targetSum, int currentSum, int idx, int k) {
        if (k == 1) {
            return true;
        }

        if (currentSum > targetSum) {
            return false;
        }

        if (currentSum == targetSum) {
            return canPartition(nums, visited, targetSum, 0, 0, k - 1);
        }

        for (int i = idx; i < nums.length; i++) {
            if (visited[i] || targetSum < currentSum + nums[i]) {
                continue;
            }

            visited[i] = true;
            if (canPartition(nums, visited, targetSum, currentSum + nums[i], i + 1, k)) {
                return true;
            } else {
                visited[i] = false;
            }
        }

        return false;
    }
}
