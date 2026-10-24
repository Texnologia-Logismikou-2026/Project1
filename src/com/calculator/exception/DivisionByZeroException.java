package com.calculator.exception;

public class DivisionByZeroException extends CalculatorException {
    public DivisionByZeroException() {
        super("Cannot divide by zero.");
    }
}