package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

    Given A = [1, 2, 3], the function should return 4.

    Given A = [−1, −3], the function should return 1.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].
*/
public class FindSmallestPositiveIntegerDoesNotOccurInArray {

    @Test
    public void testFindNum() {
        int result1 = findNum(new int[]{1, 2, 3});
        Assertions.assertEquals(4, result1);

        int result2 = findNum(new int[]{1, 3, 6, 4, 1, 2});
        Assertions.assertEquals(5, result2);

        int result3 = findNum(new int[]{-1, -3});
        Assertions.assertEquals(1, result3);
    }

    public int findNum(int[] A) {
        // write your code in Java SE 8

        int maxNum = 0;
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            maxNum = Math.max(maxNum, num);
        }

        if (maxNum == 0) {
            return 1;
        }

        int[] totalNums = new int[maxNum];
        for (int i = 0; i < totalNums.length; i++) {
            totalNums[i] = i + 1;
        }

        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            if (num > 0 && totalNums[num - 1] > 0) {
                totalNums[num - 1] = -totalNums[num - 1];
            }
        }

        for (int i = 0; i < totalNums.length; i++) {
            int num = totalNums[i];
            if (num > 0) {
                return num;
            }
        }

        return maxNum + 1;
    }
}
