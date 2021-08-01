package com.spring.boot.test.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
In other words, given two integer arrays val[0..n-1] and wt[0..n-1]
which represent values and weights associated with n items respectively.
Also given an integer W which represents knapsack capacity,
find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 */
public class Knapsack0_1Test {

    @Test
    public void test() {

        int[] weights = {2, 4, 3, 5};
        int[] scores = {30, 70, 50, 60};
        int actual1 = knapsack(5, weights, scores);
        Assertions.assertEquals(80, actual1);
    }

    static int knapSack(int limit, int[] weights, int[] scores) {

        int[][] memo = new int[scores.length + 1][limit + 1];

        for (int i = 0; i <= scores.length; i++) {
            for (int j = 0; j <= limit; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;

                } else if (weights[i - 1] <= j) {
                    memo[i][j] = Math.max(scores[i - 1] + memo[i - 1][j - weights[i - 1]], memo[i - 1][j]);

                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }

        return memo[scores.length][limit];
    }

    private int knapsack(int capacity, int[] weights, int[] values) {

        int[][] memo = new int[weights.length + 1][capacity + 1];

        for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if(j >= weights[i - 1]) {
                    memo[i][j] = Math.max(memo[i - 1][j], values[i - 1] + memo[i - 1][j - weights[i - 1]]);
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }

        return memo[weights.length][capacity];
    }
}
