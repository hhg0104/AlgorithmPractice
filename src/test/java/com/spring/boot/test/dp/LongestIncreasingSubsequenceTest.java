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

    @Test
    public void test() {

        int length1 = lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18});
        Assertions.assertEquals(4, length1);

        int length2 = lengthOfLIS(new int[]{0,1,0,3,2,3});
        Assertions.assertEquals(4, length2);

        int length3 = lengthOfLIS2(new int[]{7,7,7,7,7,7,7});
        Assertions.assertEquals(1, length3);

    }

    public int lengthOfLIS(int[] nums) {

        int[] subsequenceArr = new int[nums.length];
        Arrays.fill(subsequenceArr, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
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
    public int lengthOfLIS2(int[] arr) {

        int n = arr.length;
        int lis[] = new int[n];
        int i, j, max = 0;

        /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++)
            lis[i] = 1;

        /* Compute optimized LIS values in
           bottom up manner */
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
//                    if (lis[i] < lis[j] + 1) {
                        lis[i] = Math.max(lis[j] + 1, lis[i]);
//                    } else {
//                        System.out.println(i + " : " + j);
//                        continue;
//                    }
                }
            }
        }

        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }
}
