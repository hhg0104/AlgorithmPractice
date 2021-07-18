package com.spring.boot.test.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Given a non-empty array nums containing only positive integers,
    find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.


    Example 1:

    Input: nums = [1,5,11,5]
    Output: true
    Explanation: The array can be partitioned as [1, 5, 5] and [11].
    Example 2:

    Input: nums = [1,2,3,5]
    Output: false
    Explanation: The array cannot be partitioned into equal sum subsets.


    Constraints:

    1 <= nums.length <= 200
    1 <= nums[i] <= 100

    Time complexity: O(numbers length * sum)
    Space complexity: O(numbers length * sum)

    O(N * S) where N represents the total numbers and S is the total sum of all numbers.
 */
public class PartitionSubSetSumTest {

    @Test
    public void test() {

        boolean actual1 = canPartition(new int[]{1, 5, 11, 5});
        Assertions.assertEquals(true, actual1);

        boolean actual2 = canPartition(new int[]{1, 2, 3, 5});
        Assertions.assertEquals(false, actual2);
    }

    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length == 0) {
            return true;
        }

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }

        return canPartition(nums, 0, 0, total / 2, new HashMap<String, Boolean>());
    }

    private boolean canPartition(int[] nums, int idx, int sum, int total, Map<String, Boolean> resultMap) {

        String key = idx + "-" + sum;
        if (resultMap.containsKey(key)) {
            return resultMap.get(key);
        }

        if (total == sum) {
            return true;
        }

        if (sum > total) {
            return false;
        }

        if (idx >= nums.length) {
            return false;
        }

        boolean result = canPartition(nums, idx + 1, sum + nums[idx], total, resultMap) || canPartition(nums, idx + 1, sum, total, resultMap);

        resultMap.put(key, result);

        return result;
    }
}
