package com.spring.boot.test.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    You are given an integer array coins representing coins of different denominations
    and an integer amount representing a total amount of money.

    Return the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.


    Example 1:

    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
    Example 2:

    Input: coins = [2], amount = 3
    Output: -1
    Example 3:

    Input: coins = [1], amount = 0
    Output: 0
    Example 4:

    Input: coins = [1], amount = 1
    Output: 1
    Example 5:

    Input: coins = [1], amount = 2
    Output: 2


    Constraints:

    1 <= coins.length <= 12
    1 <= coins[i] <= 231 - 1
    0 <= amount <= 104

    Time Complexity: O(coins.length * amount)
    Space Complexity: O(amount)
 */
public class CoinChangeTest {

    @Test
    public void test() {

        int actual1 = coinChange(new int[]{1, 2, 5}, 11);
        Assertions.assertEquals(3, actual1);

        int actual2 = coinChange(new int[]{2}, 3);
        Assertions.assertEquals(-1, actual2);

        int actual3 = coinChange(new int[]{1}, 0);
        Assertions.assertEquals(0, actual3);

        int actual4 = coinChange(new int[]{1}, 1);
        Assertions.assertEquals(1, actual4);

        int actual5 = coinChange(new int[]{1}, 2);
        Assertions.assertEquals(2, actual5);
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        int[] coinCountCache = new int[amount + 1];
        Arrays.fill(coinCountCache, amount + 1);
        coinCountCache[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int lastIndex = i - coins[j];
                if (lastIndex >= 0) {
                    coinCountCache[i] = Math.min(coinCountCache[i], coinCountCache[lastIndex] + 1);
                }
            }
        }

        return coinCountCache[amount] > amount ? -1 : coinCountCache[amount];
    }
}
