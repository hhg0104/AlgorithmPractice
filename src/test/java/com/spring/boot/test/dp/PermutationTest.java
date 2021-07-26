package com.spring.boot.test.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.


    Example 1:

    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    Example 2:

    Input: nums = [0,1]
    Output: [[0,1],[1,0]]
    Example 3:

    Input: nums = [1]
    Output: [[1]]


    Constraints:

    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.
 */
public class PermutationTest {

    @Test
    public void test() {

        List<List<Integer>> actual1 = permute(new int[]{1,2,3});
        for (List<Integer> list : actual1) {
            for (int num: list) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> ansList = new ArrayList<>();
        permute(nums, new boolean[nums.length], new ArrayList<>(), ansList);

        return ansList;
    }

    private void permute(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> ansList) {
        if (list.size() == nums.length) {
            ansList.add(new ArrayList(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            list.add(nums[i]);
            used[i] = true;
            permute(nums, used, list, ansList);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}

