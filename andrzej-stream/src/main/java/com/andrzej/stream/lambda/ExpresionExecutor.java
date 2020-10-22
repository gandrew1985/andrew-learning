package com.andrzej.stream.lambda;

public class ExpresionExecutor {

    public void execute(double a, double b, MathExpresion mathExpresion) {
        double result = mathExpresion.calculateExpresion(a,b);
        System.out.println("Result: " + result);
    }
}
