package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(15, calculator.add(10, 5));
        assertEquals(0, calculator.add(-5, 5));
    }

    @Test
    public void testMultiplication() {
        assertEquals(50, calculator.multiply(10, 5));
        assertEquals(0, calculator.multiply(0, 5));
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, calculator.subtract(10, 5));
        assertEquals(-10, calculator.subtract(-5, 5));
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.divide(10, 5));
        assertEquals(0, calculator.divide(0, 5));
        assertEquals(-2, calculator.divide(10, -5));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    @Test
    public void testReverseString() {
        assertEquals("olleH", calculator.reverseString("Hello"));
        assertEquals("", calculator.reverseString(""));
        assertEquals(null, calculator.reverseString(null));
        assertEquals("a", calculator.reverseString("a"));
    }
}