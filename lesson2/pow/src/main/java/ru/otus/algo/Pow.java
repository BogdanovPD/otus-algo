package ru.otus.algo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.log;

public class Pow {

    private RoundingMode roundingMode;

    public Pow(RoundingMode roundingMode) {
        this.roundingMode = roundingMode;
    }

    public double iter(double number, long pow) {
        if (pow == 0) {
            return 1.0;
        }
        double k = number;
        for (int i = 1; i < pow; i++) {
            k*=number;
        }
        return getTruncatedDouble(k);
    }

    public double pow2(double number, long pow) {
        if (pow == 0) {
            return 1.0;
        }
        if (pow == 1) {
            return getTruncatedDouble(number);
        }
        long log2Pow = (long) (log(pow) / log(2));
        long delta = pow - ((long)iter(2, log2Pow));
        double k = number;
        for (int i = 0; i < log2Pow; i++) {
            k*=k;
        }
        if (delta > 0) {
            for (int i = 0; i < delta; i++) {
                k*=number;
            }
        }
        return getTruncatedDouble(k);
    }

    public double expansion(double number, long pow) {
        if (pow == 0) {
            return 1.0;
        }
        if (pow == 1) {
            return getTruncatedDouble(number);
        }
        List<Integer> expansionIndexes = new ArrayList<>();
        long e = pow;
        int counter = 0;
        while (e != 0) {
            if (e % 2 != 0) {
                expansionIndexes.add(counter);
            }
            counter++;
            e/=2;
        }
        double k = number;
        double s = 1.0;
        for (int i = 0; i < counter; i++) {
            if (expansionIndexes.contains(i)) {
                s*=k;
            }
            k*=k;
        }
        return getTruncatedDouble(s);
    }

    private double getTruncatedDouble(double number) {
        return BigDecimal.valueOf(number)
                .setScale(11, roundingMode)
                .doubleValue();
    }

}
