package com.spring.boot.test.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
    An array is called "switching" if the odd and even elements are equal.

    Example:

    [2,4,2,4] is a switching array because the members in even positions (indexes 0 and 2) and odd positions (indexes 1 and 3) are equal.

    If A = [3,7,3,7, 2, 1, 2], the switching sub-arrays are:

    == > [3,7,3,7] and [2,1,2]

    Therefore, the longest switching sub-array is [3,7,3,7] with length = 4.

    As another example if A = [1,5,6,0,1,0], the the only switching sub-array is [0,1,0].

    Another example: A= [7,-5,-5,-5,7,-1,7], the switching sub-arrays are [7,-1,7] and [-5,-5,-5].

    Question:

    Write a function that receives an array and find its longest switching sub-array.
*/
public class LongestOddEvenSubsequence {

    @Test
    public void test() {

        int result1 = findLongestOddEvenSubsequence(new int[]{7, -5, -5, -5, 7, -1, 7});
        Assertions.assertEquals(3, result1);

        int result2 = findLongestOddEvenSubsequence(new int[]{3, 2, 3, 2, 3});
        Assertions.assertEquals(5, result2);

    }

    public int findLongestOddEvenSubsequence(int[] nums) {

        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }

        int[] subsequenceArr = new int[nums.length];
        Arrays.fill(subsequenceArr, 2);

        for (int i = length - 1; i >= 1; i--) {

            int idx1 = i;
            int idx2 = i - 1;

            while (idx1 - 2 >= 0) {
                int num = nums[idx1];
                int num2 = nums[idx2];

                if (num == nums[idx1 - 2]) {
                    subsequenceArr[i] = subsequenceArr[i] + 1;
                    if (idx2 -2 >= 0 && num2 == nums[idx2 - 2]) {
                        subsequenceArr[i] = subsequenceArr[i] + 1;
                    } else {
                        break;
                    }
                } else {
                    break;
                }

                idx1 -= 2;
                idx2 -= 2;
            }
        }

        int longestNum = 0;
        for (int len : subsequenceArr) {
            longestNum = Math.max(longestNum, len);
        }

        return longestNum;
    }
}
