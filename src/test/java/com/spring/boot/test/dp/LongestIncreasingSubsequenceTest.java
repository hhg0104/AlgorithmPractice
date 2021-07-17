package com.spring.boot.test.dp;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Given an integer array nums, return the length of the longest strictly increasing subsequence.

    A subsequence is a sequence that can be derived from an array
    by deleting some or no elements without changing the order of the remaining elements.
    For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].


    Example 1:

    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    Example 2:

    Input: nums = [0,1,0,3,2,3]
    Output: 4
    Example 3:

    Input: nums = [7,7,7,7,7,7,7]
    Output: 1


    Constraints:

    1 <= nums.length <= 2500
    -104 <= nums[i] <= 104

    Time Complexity: O(n^2)
    Space Complexity: O(n)
*/
public class LongestIncreasingSubsequenceTest {

    @Data
    @AllArgsConstructor
    private class TwoNum {

        private int first;

        private int second;
    }

    @Test
    public void test() {

        int length1 = lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});

        Assertions.assertEquals(4, length1);

        int length2 = lengthOfLIS(new int[]{0,1,0,3,2,3});

        Assertions.assertEquals(4, length2);

        int length3 = lengthOfLIS(new int[]{7,7,7,7,7,7,7});

        Assertions.assertEquals(1, length3);

    }

    public int lengthOfLIS(int[] nums) {

        int[] subsequenceArr = new int[nums.length];
        Arrays.fill(subsequenceArr, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    subsequenceArr[i] = Math.max(subsequenceArr[j] + 1, subsequenceArr[i]);
                }
            }
        }

        int max = 0;
        for (int subsequence : subsequenceArr) {
            max = Math.max(subsequence, max);
        }

        return max;
    }
}
