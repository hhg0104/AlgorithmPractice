package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NthFibonachiTest {


    @Test
    public void test() {

        int result = getFibonachiUsingDynamicProgramming(9);
        System.out.println(result);
    }

    private int getFibonachi(int nth) {
        if(nth <= 1) {
            return nth;
        }

        return getFibonachi(nth - 1) + getFibonachi(nth - 2);
    }


    private int getFibonachiUsingDynamicProgramming(int nth) {

        int num1 = 0;
        int num2 = 1;
        int num3 = 0;

        for (int i = 2; i <= nth; i++) {
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;

            System.out.println(num3);
        }

        return num2;
    }
}
