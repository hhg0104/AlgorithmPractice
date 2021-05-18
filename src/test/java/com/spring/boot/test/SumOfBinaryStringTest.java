package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SumOfBinaryStringTest {


    @Test
    public void sumOfBinaryNums() {
        String newBinary = sumOfBinaryNumbers2("11010,00101001");
        System.out.println(newBinary);

        Assertions.assertEquals(newBinary, "1000011");
    }

    private String sumOfBinaryNumbers2(String binaryStr) {

        if(binaryStr == null || binaryStr.isEmpty()) {
            return null;
        }

        String[] binaryArr = binaryStr.split(",");
        if(binaryArr.length != 2) {
            throw new IllegalArgumentException("Parameter should be consisted of 2 binary strings [ex. 11010,00101001]");
        }

        String binary1 = binaryArr[0];
        String binary2 = binaryArr[1];

        int idx1 = binary1.length() - 1;
        int idx2 = binary2.length() - 1;

        StringBuilder sumBinaryStrBuilder = new StringBuilder();
        int carry = 0;

        while( idx1 >= 0 || idx2 >= 0) {

            int sum = carry;

            if(idx1 >= 0) {
                sum += ((binary1.charAt(idx1) == '1')? 1 : 0);
            }
            if(idx2 >= 0) {
                sum += ((binary2.charAt(idx2) == '1')? 1 : 0);
            }

            carry = sum / 2;
            sumBinaryStrBuilder.append(sum % 2);

            idx1--;
            idx2--;
        }

        String sumBinaryStr = sumBinaryStrBuilder.reverse().toString();
        return sumBinaryStr.substring(sumBinaryStr.indexOf("1"));
    }

    public String sumOfBinaryNumbers(String binaryArrStr) {

        if(binaryArrStr == null || binaryArrStr.isEmpty()) {
            throw new IllegalArgumentException("'binaryStr' must no be null or empty.");
        }

        String[] binaryNums = binaryArrStr.split(",");
        if(binaryNums.length != 2) {
            throw new IllegalArgumentException("'binaryArrStr' must be contained 2 binary number string separated by comma. (ex. 110011,1010)");
        }

        String binary1 = binaryNums[0];
        String binary2 = binaryNums[1];

        int idx1 = binary1.length() - 1;
        int idx2 = binary2.length() - 1;

        int carry = 0;

        StringBuilder newBinarySb = new StringBuilder();

        while(idx1 >= 0 || idx2 >= 0) {

            int sum = carry;

            if (idx1 >= 0) {
                sum += binary1.charAt(idx1) - '0';
            }

            if (idx2 >= 0) {
                sum += binary2.charAt(idx2) - '0';
            }

            newBinarySb.append(sum % 2);

            carry = sum / 2;

            idx1--;
            idx2--;
        }

        if (carry > 0) {
            newBinarySb.append('1');
        }

        String newBinaryStr = newBinarySb.reverse().toString();

        return newBinaryStr.substring(newBinaryStr.indexOf("1"));
    }
}
