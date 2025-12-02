package com.example.mipt_praktika3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    // Addition Tests
    @Test
    public void testAddPositiveNumbers() {
        assertEquals(8.0, calculator.add(5, 3), 0.001);
    }

    @Test
    public void testAddNegativeNumbers() {
        assertEquals(-8.0, calculator.add(-5, -3), 0.001);
    }

    @Test
    public void testAddZero() {
        assertEquals(5.0, calculator.add(5, 0), 0.001);
    }

    @Test
    public void testAddDecimals() {
        assertEquals(8.7, calculator.add(5.5, 3.2), 0.001);
    }

    // Subtraction Tests
    @Test
    public void testSubtractPositive() {
        assertEquals(6.0, calculator.subtract(10, 4), 0.001);
    }

    @Test
    public void testSubtractNegativeResult() {
        assertEquals(-5.0, calculator.subtract(3, 8), 0.001);
    }

    @Test
    public void testSubtractDecimals() {
        assertEquals(7.3, calculator.subtract(10.5, 3.2), 0.001);
    }

    // Multiplication Tests
    @Test
    public void testMultiplyPositive() {
        assertEquals(20.0, calculator.multiply(4, 5), 0.001);
    }

    @Test
    public void testMultiplyByZero() {
        assertEquals(0.0, calculator.multiply(5, 0), 0.001);
    }

    @Test
    public void testMultiplyNegative() {
        assertEquals(20.0, calculator.multiply(-4, -5), 0.001);
    }

    @Test
    public void testMultiplyDecimals() {
        assertEquals(10.0, calculator.multiply(2.5, 4.0), 0.001);
    }

    // Division Tests
    @Test
    public void testDividePositive() {
        assertEquals(5.0, calculator.divide(10, 2), 0.001);
    }

    @Test
    public void testDivideDecimal() {
        assertEquals(3.5, calculator.divide(7, 2), 0.001);
    }

    @Test
    public void testDivideNegative() {
        assertEquals(-5.0, calculator.divide(-10, 2), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }

    // Square Root Tests
    @Test
    public void testSquareRootPerfectSquare() {
        assertEquals(4.0, calculator.squareRoot(16), 0.001);
    }

    @Test
    public void testSquareRootZero() {
        assertEquals(0.0, calculator.squareRoot(0), 0.001);
    }

    @Test
    public void testSquareRootDecimal() {
        assertEquals(2.5, calculator.squareRoot(6.25), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testSquareRootNegative() {
        calculator.squareRoot(-16);
    }

    // Sign Change Tests
    @Test
    public void testChangeSignPositive() {
        assertEquals(-5.0, calculator.changeSign(5), 0.001);
    }

    @Test
    public void testChangeSignNegative() {
        assertEquals(5.0, calculator.changeSign(-5), 0.001);
    }

    @Test
    public void testChangeSignZero() {
        assertEquals(0.0, calculator.changeSign(0), 0.001);
    }
}