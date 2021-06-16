package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thymeleaf.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Given a sorted array arr[] of N integers, The task is to find the multiple missing elements in the array between the ranges [arr[0], arr[N-1]].

    Examples:

    Input: arr[] = {6, 7, 10, 11, 13}
    Output: 8 9 12
    Explanation:
    The elements of the array are present in the range of the maximum and minimum array element [6, 13]. Therefore, the total values will be {6, 7, 8, 9, 10, 11, 12, 13}.
    The elements from the above range which are missing from the array are {8, 9, 12}.


    Input: arr[] = {1, 2, 4, 6}
    Output: 3 5
 */
public class MissingNumberInSortedArrayTest {

    @Test
    public void test() {

        List<Integer> actual1 = findMissingNumber(new int[]{6, 7, 10, 11, 13});
        {
            Assertions.assertEquals(3, actual1.size());

            Assertions.assertEquals(8, actual1.get(0));
            Assertions.assertEquals(9, actual1.get(1));
            Assertions.assertEquals(12, actual1.get(2));
        }

        List<Integer> actual2 = findMissingNumber(new int[]{1, 2, 4, 6});
        {
            Assertions.assertEquals(2, actual2.size());

            Assertions.assertEquals(3, actual2.get(0));
            Assertions.assertEquals(5, actual2.get(1));
        }
    }

    // O(Maximum Array Length)
    private List<Integer> findMissingNumber(int[] arr) {

        if (arr == null || arr.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> resultList = new ArrayList<>();

        int oldNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int newNum = arr[i];
            int diff = newNum - oldNum;
            if (diff > 1) {
                int idx = 1;
                while (idx < diff) {
                    resultList.add(oldNum + idx);
                    idx++;
                }
            }
            oldNum = newNum;
        }

        return resultList;
    }
}
