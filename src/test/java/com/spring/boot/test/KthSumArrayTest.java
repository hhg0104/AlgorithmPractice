package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KthSumArrayTest {

    private static final int[] ARR = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    @org.junit.jupiter.api.Test
    public void test() {
        int k = 3;
        int n = 9;

        List<List<Integer>> answerList = getSumList(3, 9, ARR);
        String resultStr = answerList.stream()
                .map(list -> list.stream().map(Object::toString).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));

        System.out.println(resultStr);

        Assertions.assertEquals(answerList.size(), 3);
        Assertions.assertEquals(answerList.get(0).get(0), 1);
        Assertions.assertEquals(answerList.get(0).get(1), 2);
        Assertions.assertEquals(answerList.get(0).get(2), 6);

        Assertions.assertEquals(answerList.get(1).get(0), 1);
        Assertions.assertEquals(answerList.get(1).get(1), 3);
        Assertions.assertEquals(answerList.get(1).get(2), 5);

        Assertions.assertEquals(answerList.get(2).get(0), 2);
        Assertions.assertEquals(answerList.get(2).get(1), 3);
        Assertions.assertEquals(answerList.get(2).get(2), 4);
    }

    private List<List<Integer>> getSumList(int k, int n, int[] arr) {

        List<List<Integer>> sumList = new ArrayList<>();

        calculateRecursively(k, n, arr, n, 0, 0, sumList, new ArrayList<>());

        return sumList;
    }

    private void calculateRecursively(int k, int n, int[] arr, int targetNum, int currentIdx, int currentSum,
                                      List<List<Integer>> sumList, List<Integer> list) {

        if (k == 0) {
            if (targetNum == currentSum) {
                sumList.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = currentIdx; i < arr.length; i++) {
            int num = arr[i];
            if (currentSum + num > targetNum) {
                break;
            }

            list.add(num);
            calculateRecursively(k - 1, n, arr, targetNum, i + 1, currentSum + num, sumList, list);
            list.remove(list.size() - 1);
        }
    }
}
