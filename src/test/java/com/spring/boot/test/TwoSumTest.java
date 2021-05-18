package com.spring.boot.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers nums and an integer target,
    return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution,
    and you may not use the same element twice.

    You can return the answer in any order.

    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]

    Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
*/
public class TwoSumTest {

    @Data
    @AllArgsConstructor
    private class TwoNum {

        private int first;

        private int second;
    }

    @Test
    public void test() {

        int[] arr1 = {2, 7, 11, 15};
        TwoNum answer1 = getIndexesOfSumOfTwoNum(arr1, 9);

        Assertions.assertEquals(0, answer1.getFirst());
        Assertions.assertEquals(1, answer1.getSecond());

        int[] arr2 = {3, 2, 4};
        TwoNum answer2 = getIndexesOfSumOfTwoNum(arr2, 6);

        Assertions.assertEquals(1, answer2.getFirst());
        Assertions.assertEquals(2, answer2.getSecond());

        int[] arr3 = {3, 3};
        TwoNum answer3 = getIndexesOfSumOfTwoNum(arr3, 6);

        Assertions.assertEquals(0, answer3.getFirst());
        Assertions.assertEquals(1, answer3.getSecond());

        int[] arr4 = {3, 4, 7};
        TwoNum answer4 = getIndexesOfSumOfTwoNum(arr4, 15);
        Assertions.assertNull(answer4);

        TwoNum answer5 = getIndexesOfSumOfTwoNum(new int[]{}, 5);
        Assertions.assertNull(answer5);

        TwoNum answer6 = getIndexesOfSumOfTwoNum(null, 15);
        Assertions.assertNull(answer6);
    }

    private TwoNum getIndexesOfSumOfTwoNum(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int num = arr[i];
            int restNum = target - num;

            if (map.containsKey(restNum)) {
                return new TwoNum(map.get(restNum), i);
            }

            map.put(num, i);
        }

        return null;
    }
}
