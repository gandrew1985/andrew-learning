package com.andrzej.exception.test;

import java.util.stream.Stream;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            double result = firstChallenge.divide(3,1);
        } catch (ArithmeticException e) {
            System.out.println("Cant divide" + e);
        } finally {
            System.out.println("End");
        }
    }
}
