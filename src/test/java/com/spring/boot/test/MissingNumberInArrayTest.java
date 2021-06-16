package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

    Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?


    Example 1:

    Input: nums = [3,0,1]
    Output: 2
    Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
    Example 2:

    Input: nums = [0,1]
    Output: 2
    Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
    Example 3:

    Input: nums = [9,6,4,2,3,5,7,0,1]
    Output: 8
    Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
    Example 4:

    Input: nums = [0]
    Output: 1
    Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.


    Constraints:

    n == nums.length
    1 <= n <= 104
    0 <= nums[i] <= n
    All the numbers of nums are unique.
 */
public class MissingNumberInArrayTest {

    @Test
    public void test() {

        int actual1 = findMissingNumber(new int[]{3, 0, 1});
        Assertions.assertEquals(2, actual1);

        int actual2 = findMissingNumber(new int[]{0, 1});
        Assertions.assertEquals(2, actual2);

        int actual3 = findMissingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
        Assertions.assertEquals(8, actual3);

        int actual4 = findMissingNumber(new int[]{0});
        Assertions.assertEquals(1, actual4);
    }

    private int findMissingNumber(int[] arr) {

//        Gauss' Formula -> sum of nums 1 to n
//        int maximumNum = arr.length * (arr.length + 1) / 2;

        int maximumNum = (arr.length + 1) * (arr.length / 2);
        if (arr.length % 2 != 0) {
            maximumNum += (arr.length / 2) + 1;
        }

        for (int i = 0; i < arr.length; i++) {
            maximumNum -= arr[i];
        }

        return maximumNum;
    }
}
