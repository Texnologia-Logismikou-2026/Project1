package com.calculator.model;

import com.calculator.exception.CalculatorException;
import com.calculator.exception.DivisionByZeroException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicCalculatorModelTest {

    // ===== calculate(): the 4 basic operators =====

    @Test
    void shouldAddTwoNumbers() throws CalculatorException {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // let's perform the operation
        double result = calculator.calculate(8, 4, Operator.ADD);
        // with assert, let's check if the result is what we expect
        assertEquals(12, result, 0.0001);
    }

    @Test
    void shouldSubtractTwoNumbers() throws CalculatorException {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // let's perform the operation
        double result = calculator.calculate(10, 3, Operator.SUBTRACT);
        // with assert, let's check if the result is what we expect
        assertEquals(7, result, 0.0001);
    }

    @Test
    void shouldMultiplyTwoNumbers() throws CalculatorException {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // let's perform the operation
        double result = calculator.calculate(6, 7, Operator.MULTIPLY);
        // with assert, let's check if the result is what we expect
        assertEquals(42, result, 0.0001);
    }

    @Test
    void shouldDivideTwoNumbers() throws CalculatorException {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // let's perform the operation
        double result = calculator.calculate(8, 4, Operator.DIVIDE);
        // with assert, let's check if the result is what we expect
        assertEquals(2, result, 0.0001);
    }

    // ===== calculate(): edge cases =====

    @Test
    void shouldHandleDecimalNumbers() throws CalculatorException {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // let's perform the operation with decimal numbers
        double result = calculator.calculate(0.1, 0.2, Operator.ADD);
        // with assert, let's check if the result is what we expect (the tolerance handles rounding)
        assertEquals(0.3, result, 0.0001);
    }

    @Test
    void shouldHandleNegativeNumbers() throws CalculatorException {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // let's perform the operation with negative numbers
        double result = calculator.calculate(-4, -2, Operator.MULTIPLY);
        // with assert, let's check if the result is what we expect
        assertEquals(8, result, 0.0001);
    }

    @Test
    void shouldChainConsecutiveOperations() throws CalculatorException {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // let's perform two operations in a row: (2 + 3) * 4
        double first = calculator.calculate(2, 3, Operator.ADD);
        double second = calculator.calculate(first, 4, Operator.MULTIPLY);
        // with assert, let's check if the final result is what we expect
        assertEquals(20, second, 0.0001);
    }

    // ===== calculate(): exceptions =====

    @Test
    void shouldThrowWhenDividingByZero() {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // with assertThrows, let's check that dividing by zero throws the right exception
        assertThrows(DivisionByZeroException.class,
                () -> calculator.calculate(5, 0, Operator.DIVIDE));
    }

    @Test
    void shouldThrowWhenOperatorIsNull() {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // with assertThrows, let's check that a missing operator throws an exception
        assertThrows(CalculatorException.class,
                () -> calculator.calculate(5, 3, null));
    }

    // ===== calculateExpression(): normal cases =====

    @Test
    void shouldCalculateSimpleExpression() throws CalculatorException {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // let's perform the operation written as text
        double result = calculator.calculateExpression("10 + 4");
        // with assert, let's check if the result is what we expect
        assertEquals(14, result, 0.0001);
    }

    @Test
    void shouldRespectOperatorPrecedence() throws CalculatorException {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // let's perform the operation: * must be done before +
        double result = calculator.calculateExpression("2 + 3 * 4");
        // with assert, let's check that we get 14 (and not 20)
        assertEquals(14, result, 0.0001);
    }

    @Test
    void shouldCalculateConsecutiveOperations() throws CalculatorException {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // let's perform several operations in one expression: 10 - 6 + 2
        double result = calculator.calculateExpression("10 - 2 * 3 + 4 / 2");
        // with assert, let's check if the result is what we expect
        assertEquals(6, result, 0.0001);
    }

    @Test
    void shouldHandleNegativeNumberInExpression() throws CalculatorException {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // let's perform an operation starting with a negative number
        double result = calculator.calculateExpression("-5 + 3");
        // with assert, let's check if the result is what we expect
        assertEquals(-2, result, 0.0001);
    }

    // ===== calculateExpression(): exceptions =====

    @Test
    void shouldThrowWhenDividingByZeroInExpression() {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // with assertThrows, let's check that dividing by zero throws the right exception
        assertThrows(DivisionByZeroException.class,
                () -> calculator.calculateExpression("10 / 0"));
    }

    @Test
    void shouldThrowWhenExpressionIsEmpty() {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // with assertThrows, let's check that an empty expression throws an exception
        assertThrows(CalculatorException.class,
                () -> calculator.calculateExpression("   "));
    }

    @Test
    void shouldThrowWhenExpressionIsNull() {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // with assertThrows, let's check that a null expression throws an exception
        assertThrows(CalculatorException.class,
                () -> calculator.calculateExpression(null));
    }

    @Test
    void shouldThrowWhenExpressionIsInvalid() {
        // here we gonna set up the calculator we want to test
        BasicCalculatorModel calculator = new BasicCalculatorModel();
        // with assertThrows, let's check that letters instead of numbers throw an exception
        assertThrows(CalculatorException.class,
                () -> calculator.calculateExpression("abc"));
    }
}
