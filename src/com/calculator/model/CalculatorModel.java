package com.calculator.model;

import com.calculator.exception.CalculatorException;

public interface CalculatorModel {
    double calculate(double operand1, double operand2, Operator operator) throws CalculatorException;
    double calculateExpression(String expression) throws CalculatorException;
}