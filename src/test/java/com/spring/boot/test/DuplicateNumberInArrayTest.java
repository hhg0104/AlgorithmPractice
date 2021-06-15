package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

    There is only one repeated number in nums, return this repeated number.

    You must solve the problem without modifying the array nums and uses only constant extra space.


    Example 1:

    Input: nums = [1,3,4,2,2]
    Output: 2
    Example 2:

    Input: nums = [3,1,3,4,2]
    Output: 3
    Example 3:

    Input: nums = [1,1]
    Output: 1
    Example 4:

    Input: nums = [1,1,2]
    Output: 1
 */
public class DuplicateNumberInArrayTest {

    @Test
    public void test() {

        int actual1 = getDuplicateNumbers(new int[]{1,3,4,2,2});
        Assertions.assertEquals(2, actual1);

        int actual2 = getDuplicateNumbers(new int[]{3,1,3,4,2});
        Assertions.assertEquals(3, actual2);

        int actual3 = getDuplicateNumbers(new int[]{1,1});
        Assertions.assertEquals(1, actual3);

        int actual4 = getDuplicateNumbers(new int[]{1,1,2});
        Assertions.assertEquals(1, actual4);
    }

    public int getDuplicateNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num] > 0) {
                nums[num] = -nums[num];
            } else {
                return num;
            }
        }

        return -1;
    }
}
