package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.


    Example 1:

    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Example 2:

    Input: nums = []
    Output: []
    Example 3:

    Input: nums = [0]
    Output: []


    Constraints:

    0 <= nums.length <= 3000
    -105 <= nums[i] <= 105
 */
public class ThreeArraySumTest {

    @Test
    public void test() {

        List<List<Integer>> actual1 = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        Assertions.assertEquals(2, actual1.size());
        Assertions.assertEquals(-1, actual1.get(0).get(0));
        Assertions.assertEquals(-1, actual1.get(0).get(1));
        Assertions.assertEquals(2, actual1.get(0).get(2));
        Assertions.assertEquals(-1, actual1.get(1).get(0));
        Assertions.assertEquals(0, actual1.get(1).get(1));
        Assertions.assertEquals(1, actual1.get(1).get(2));

        List<List<Integer>> actual2 = threeSum(new int[]{});
        Assertions.assertEquals(0, actual2.size());

        List<List<Integer>> actual3 = threeSum(new int[]{0});
        Assertions.assertEquals(0, actual3.size());
    }

    // O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {

        // {-4, -1, -1, 0, 1, 2}
        Arrays.sort(nums);

        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i< nums.length; i++) {
            int num1 = nums[i];

            if (i > 0 && (nums[i] == nums[i-1])) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;
            int twoSum = 0 - num1;

            while (start < end) {
                if (start > i + 1 && (nums[start] == nums[start - 1])) {
                    start++;
                    continue;
                }

                if (nums[start] + nums[end] > twoSum) {
                    end--;

                } else if (nums[start] + nums[end] < twoSum) {
                    start++;

                } else {
                    List<Integer> result = Arrays.asList(num1, nums[start], nums[end]);
                    resultList.add(result);

                    start++;
                    end--;
                }
            }
        }

        return resultList;
    }
}
