package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
    Count the number of prime numbers less than a non-negative number, n.


    Example 1:
    Input: n = 10
    Output: 4
    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

    Example 2:
    Input: n = 0
    Output: 0

    Example 3:
    Input: n = 1
    Output: 0


    Constraints:

    0 <= n <= 5 * 106
 */
public class CountPrimesTest {

    @Test
    public void test() {

        int actual1 = countPrimes(10);
        Assertions.assertEquals(4, actual1);

        int actual2 = countPrimes(0);
        Assertions.assertEquals(0, actual2);

        int actual3 = countPrimes(1);
        Assertions.assertEquals(0, actual3);
    }

    int countPrimes(int n) {

        if (n < 3) {
            return 0;
        }

        boolean[] primes = new boolean[n];
        Arrays.fill(primes, 2, primes.length, true);

        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                cnt++;
            }
        }

        return cnt;
    }

}
