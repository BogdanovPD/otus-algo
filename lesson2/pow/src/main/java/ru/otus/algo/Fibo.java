package ru.otus.algo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static java.lang.Math.sqrt;

public class Fibo {

    public BigInteger iter(int numberToFind) {
        if (numberToFind == 0) {
            return BigInteger.ZERO;
        }
        BigInteger prev = BigInteger.ZERO;
        BigInteger lastCurr;
        BigInteger curr = BigInteger.ONE;
        for (int i = 1; i < numberToFind; i++) {
            lastCurr = curr;
            curr = prev.add(curr);
            prev = lastCurr;
        }
        return curr;
    }

    public BigInteger recursive(int depth) {
        if (depth == 0) {
            return BigInteger.ZERO;
        }
        if (depth == 1) {
            return BigInteger.ONE;
        }
        return recursive(depth - 1).add(recursive(depth - 2));
    }

    public BigInteger golden(int numberToFind) {
        if (numberToFind == 0) {
            return BigInteger.ZERO;
        }
        if (numberToFind == 1) {
            return BigInteger.ONE;
        }
        if (numberToFind == 2) {
            return BigInteger.ONE;
        }
        if (numberToFind == 3) {
            return BigInteger.TWO;
        }
        BigDecimal phi = BigDecimal.ONE.add(BigDecimal.valueOf(sqrt(5))).divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);
        BigDecimal res = phi.pow(numberToFind).divide(BigDecimal.valueOf(sqrt(5)), RoundingMode.HALF_UP);
        res = res.setScale(0, RoundingMode.HALF_UP);
        return res.toBigInteger();
    }

}
