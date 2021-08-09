package com.spring.boot.test.dp;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
    Given an integer array nums, return the number of longest increasing subsequences.

    Notice that the sequence has to be strictly increasing.


    Example 1:

    Input: nums = [1,3,5,4,7]
    Output: 2
    Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
    Example 2:

    Input: nums = [2,2,2,2,2]
    Output: 5
    Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.



    Constraints:

    1 <= nums.length <= 2000
    -106 <= nums[i] <= 106

    Time Complexity: O(n^2)
    Space Complexity: O(n)
*/
public class NumberOfLongestIncreasingSubsequenceTest {

    @Test
    public void test() {

        int length1 = findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        Assertions.assertEquals(2, length1);

        int length2 = findNumberOfLIS(new int[]{2, 2, 2, 2, 2});
        Assertions.assertEquals(5, length2);

        int length3 = findNumberOfLIS(new int[]{5, 4, 7, 6, 10, 8});
        Assertions.assertEquals(8, length3);
    }

    public int findNumberOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[] length = new int[n];
        int[] counts = new int[n];

        Arrays.fill(length, 1);
        Arrays.fill(counts, 1);

        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        counts[i] = counts[j];

                    } else if (length[j] + 1 == length[i]) {
                        counts[i] += counts[j];
                    }
                }
            }

            maxLength = Math.max(maxLength, length[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                result += counts[i];
            }
        }

        return result;
    }
}
