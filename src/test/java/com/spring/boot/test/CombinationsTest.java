package com.spring.boot.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
    You may return the answer in any order.

    Example 1:

    Input: n = 4, k = 2
    Output:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
    Example 2:

    Input: n = 1, k = 1
    Output: [[1]]


    Constraints:

    1 <= n <= 20
    1 <= k <= n
*/
public class CombinationsTest {

    @Data
    @AllArgsConstructor
    private class TwoNum {

        private int first;

        private int second;
    }

    @Test
    public void test() {

        List<List<Integer>> answer = combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {

        final List<List<Integer>> answerList = new ArrayList<>();

        if (n == 0 || k == 0) {
            return answerList;
        }

        getCombinations(n, k, 1, answerList, new ArrayList<Integer>());

        return answerList;
    }

    private void getCombinations(int n, int k, int idx, List<List<Integer>> answerList, List<Integer> list) {

        if (list.size() == k) {
            answerList.add(new ArrayList(list));
            return;
        }

        for (int i = idx; i < idx + k; i++) {
            list.add(i);
            getCombinations(n, k, idx + 1, answerList, list);
            list.remove(list.size() - 1);
        }
    }
}
