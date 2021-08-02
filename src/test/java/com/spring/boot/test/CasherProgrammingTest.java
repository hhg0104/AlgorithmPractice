package com.spring.boot.test;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Cash Register
 * 프로그래밍 챌린지 설명:
 * The goal of this challenge is to design a cash register program. You will be given two decimal numbers. The first is the purchase price (PP) of the item. The second is the cash (CH) given by the customer. Your register currently has the following bills/coins within it:
 * 'PENNY': .01,
 * 'NICKEL': .05,
 * 'DIME': .10,
 * 'QUARTER': .25,
 * 'HALF DOLLAR': .50,
 * 'ONE': 1.00,
 * 'TWO': 2.00,
 * 'FIVE': 5.00,
 * 'TEN': 10.00,
 * 'TWENTY': 20.00,
 * 'FIFTY': 50.00,
 * 'ONE HUNDRED': 100.00
 * The aim of the program is to calculate the change that has to be returned to the customer.
 *
 * Input:
 * Your program should read lines of text from standard input. Each line contains two numbers
 * which are separated by a semicolon.
 * The first is the Purchase price (PP) and the second is the cash(CH) given by the customer.
 *
 * Input:
 * For each line of input print a single line to standard output
 * which is the change to be returned to the customer.
 * In case the CH < PP, print out ERROR. If CH == PP, print out ZERO.
 * For all other cases print the amount that needs to be returned,
 * in terms of the currency values provided. The output should be alphabetically sorted.
 */
public class CasherProgrammingTest {

    enum Money {
        PENNY(BigDecimal.valueOf(.01)),
        NICKEL(BigDecimal.valueOf(.05)),
        DIME(BigDecimal.valueOf(.10)),
        QUARTER(BigDecimal.valueOf(.25)),
        HALF_DOLLAR(BigDecimal.valueOf(.50)),
        ONE(BigDecimal.valueOf(1.00)),
        TWO(BigDecimal.valueOf(2.00)),
        FIVE(BigDecimal.valueOf(5.00)),
        TEN(BigDecimal.valueOf(10.00)),
        TWENTY(BigDecimal.valueOf(20.00)),
        FIFTY(BigDecimal.valueOf(50.00)),
        ONE_HUNDRED(BigDecimal.valueOf(100.00));

        private BigDecimal amount;

        Money(BigDecimal amount) {
            this.amount = amount;
        }

        public BigDecimal getAmount() {
            return this.amount;
        }

        @Override
        public String toString() {
            return this.name().replace("_", " ");
        }
    }

    @Test
    public void cashierProgram() {
        String changeMoney = calculateChangeMoney("15.94;16.00");
        System.out.println(changeMoney);
    }

    public String calculateChangeMoney(String priceAndMoney) {

        String[] binaryNums = priceAndMoney.split(";");
        if (binaryNums.length != 2) {
            throw new IllegalArgumentException("'priceAndMoney' must be contained 2 floats string separated by semicolon. (ex. 15.94;16.00)");
        }

        String[] priceAndMoneyArr = priceAndMoney.split(";");

        double totalPrice = Double.valueOf(priceAndMoneyArr[0]);
        double customerMoney = Double.valueOf(priceAndMoneyArr[1]);

        if (totalPrice > customerMoney) {
            return "ERROR";
        }

        BigDecimal change = BigDecimal.valueOf(customerMoney).subtract(BigDecimal.valueOf(totalPrice));

        List<Money> changes = new ArrayList<>();
        if (change.compareTo(BigDecimal.ZERO) == 0) {
            return "ZERO";
        }

        Money[] moneyEnums = Money.values();
        for (int i = moneyEnums.length - 1; i >= 0; i--) {

            if (change.compareTo(BigDecimal.ZERO) == 0) {
                break;
            }

            Money moneyEnum = moneyEnums[i];
            int divided = change.divide(moneyEnum.getAmount()).intValue();
            if (divided > 0) {
                changes.add(moneyEnum);
                change = change.subtract(moneyEnum.getAmount().multiply(BigDecimal.valueOf(divided)));
            }
        }

        return changes
                .stream()
                .map(c -> c.toString())
                .collect(Collectors.joining(","));
    }
}
