package ru.otus.algo;

public class Primes {

    public int bruteForce(int n) {
        int counter = 0;
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                counter++;
            }
        }
        return counter;
    }

}
