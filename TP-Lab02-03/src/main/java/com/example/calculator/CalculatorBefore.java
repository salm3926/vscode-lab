package com.example.calculator;

public class CalculatorBefore {
    public double calc(double a, double b) {
        double x = a + b;
        double y = a * b;
        return x / y;
    }

    public void prtRes(double res) {
        System.out.println("Result: " + res);
    }
}