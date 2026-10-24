package com.calculator.model;

import com.calculator.exception.CalculatorException;
import com.calculator.exception.DivisionByZeroException;

public class BasicCalculatorModel implements CalculatorModel {

    @Override
    public double calculate(double operand1, double operand2, Operator operator) throws CalculatorException {
        if (operator == null) {
            throw new CalculatorException("Operator cannot be null.");
        }

        return switch (operator) {
            case ADD -> operand1 + operand2;
            case SUBTRACT -> operand1 - operand2;
            case MULTIPLY -> operand1 * operand2;
            case DIVIDE -> {
                if (operand2 == 0) {
                    throw new DivisionByZeroException();
                }
                yield operand1 / operand2;
            }
            default -> throw new CalculatorException("Unsupported operator: " + operator);
        };
    }

    @Override
    public double calculateExpression(String expression) throws CalculatorException {
        return parseAndCalculate(expression);
    }

    public double parseAndCalculate(String expression) throws CalculatorException {
        if (expression == null || expression.trim().isEmpty()) {
            throw new CalculatorException("Expression cannot be empty.");
        }

        String cleanExpr = expression.replaceAll("\\s+", "");

        char opChar = ' ';
        int opIndex = -1;

        for (int i = 0; i < cleanExpr.length(); i++) {
            char c = cleanExpr.charAt(i);
            if (i > 0 && (c == '+' || c == '-' || c == '*' || c == '/')) {
                opChar = c;
                opIndex = i;
                break;
            }
        }

        if (opIndex == -1) {
            try {
                return Double.parseDouble(cleanExpr);
            } catch (NumberFormatException e) {
                throw new CalculatorException("Invalid numerical expression: " + expression);
            }
        }

        String leftStr = cleanExpr.substring(0, opIndex);
        String rightStr = cleanExpr.substring(opIndex + 1);

        double num1;
        double num2;

        try {
            num1 = Double.parseDouble(leftStr);
            num2 = Double.parseDouble(rightStr);
        } catch (NumberFormatException e) {
            throw new CalculatorException("Invalid numbers in expression: " + expression);
        }

        Operator operator = switch (opChar) {
            case '+' -> Operator.ADD;
            case '-' -> Operator.SUBTRACT;
            case '*' -> Operator.MULTIPLY;
            case '/' -> Operator.DIVIDE;
            default -> throw new CalculatorException("Unknown operator in expression.");
        };

        return calculate(num1, num2, operator);
    }
}