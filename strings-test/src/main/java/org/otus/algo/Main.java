package org.otus.algo;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(args[0].trim().length());
    }
}
