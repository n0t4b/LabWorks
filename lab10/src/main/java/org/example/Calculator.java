package org.example;

public class Calculator {
    public double add(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            throw new IllegalArgumentException("Cannot perform addition with NaN");
        }
        return a + b;
    }

    public double subtract(double a, double b) {
        if (Double.isInfinite(a) || Double.isInfinite(b)) {
            throw new IllegalArgumentException("Cannot perform subtraction with Infinity");
        }
        return a - b;
    }

    public double multiply(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            throw new IllegalArgumentException("Cannot perform multiplication with NaN");
        }
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        if (Double.isNaN(a)) {
            throw new IllegalArgumentException("Cannot calculate square root of NaN");
        }
        return Math.sqrt(a);
    }

    public double power(double base, double exponent) {
        if (Double.isNaN(base) || Double.isNaN(exponent)) {
            throw new IllegalArgumentException("Cannot perform power operation with NaN");
        }
        return Math.pow(base, exponent);
    }
}
