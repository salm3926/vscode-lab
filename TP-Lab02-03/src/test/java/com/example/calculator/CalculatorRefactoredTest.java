package com.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the refactored Calculator class (Lab 03 - Rename Variables/Methods).
 * These tests verify that the refactoring (renaming calc -> calculateSumProductRatio,
 * prtRes -> printResult, etc.) did NOT change the external behavior.
 */
public class CalculatorRefactoredTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void testCalculateSumProductRatio() {
        // (3 + 5) / (3 * 5) = 8 / 15 = 0.5333...
        double result = calculator.calculateSumProductRatio(3, 5);
        assertEquals(8.0 / 15.0, result, 0.0001);
    }

    @Test
    public void testCalculateSumProductRatioWithOne() {
        // (1 + 1) / (1 * 1) = 2 / 1 = 2.0
        double result = calculator.calculateSumProductRatio(1, 1);
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testCalculateSumProductRatioWithLargeNumbers() {
        // (10 + 20) / (10 * 20) = 30 / 200 = 0.15
        double result = calculator.calculateSumProductRatio(10, 20);
        assertEquals(0.15, result, 0.0001);
    }

    @Test
    public void testCalculateSumProductRatioWithNegatives() {
        // (-2 + 4) / (-2 * 4) = 2 / -8 = -0.25
        double result = calculator.calculateSumProductRatio(-2, 4);
        assertEquals(-0.25, result, 0.0001);
    }
}
