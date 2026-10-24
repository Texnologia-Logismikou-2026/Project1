package com.calculator.model;

import com.calculator.exception.CalculatorException;
import com.calculator.exception.DivisionByZeroException;
import java.util.ArrayList;
import java.util.List;

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
        if (expression == null || expression.trim().isEmpty()) {
            throw new CalculatorException("Expression cannot be empty.");
        }

        String cleanExpr = expression.replaceAll("\\s+", "");

        try {
            List<Double> numbers = new ArrayList<>();
            List<Character> operators = new ArrayList<>();

            int i = 0;
            while (i < cleanExpr.length()) {
                char c = cleanExpr.charAt(i);
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    // Handle negative numbers at the beginning or after another operator
                    if (c == '-' && (i == 0 || cleanExpr.charAt(i - 1) == '+' || cleanExpr.charAt(i - 1) == '-' || cleanExpr.charAt(i - 1) == '*' || cleanExpr.charAt(i - 1) == '/')) {
                        int start = i;
                        i++;
                        while (i < cleanExpr.length() && (Character.isDigit(cleanExpr.charAt(i)) || cleanExpr.charAt(i) == '.')) {
                            i++;
                        }
                        numbers.add(Double.parseDouble(cleanExpr.substring(start, i)));
                    } else {
                        operators.add(c);
                        i++;
                    }
                } else {
                    int start = i;
                    while (i < cleanExpr.length() && (Character.isDigit(cleanExpr.charAt(i)) || cleanExpr.charAt(i) == '.')) {
                        i++;
                    }
                    numbers.add(Double.parseDouble(cleanExpr.substring(start, i)));
                }
            }

            if (numbers.isEmpty()) {
                throw new CalculatorException("Invalid expression.");
            }

            // First pass: Multiplication and Division (Operator Precedence)
            for (int j = 0; j < operators.size(); j++) {
                char op = operators.get(j);
                if (op == '*' || op == '/') {
                    double n1 = numbers.get(j);
                    double n2 = numbers.get(j + 1);
                    double res;
                    if (op == '*') {
                        res = n1 * n2;
                    } else {
                        if (n2 == 0) {
                            throw new DivisionByZeroException();
                        }
                        res = n1 / n2;
                    }
                    numbers.set(j, res);
                    numbers.remove(j + 1);
                    operators.remove(j);
                    j--;
                }
            }

            // Second pass: Addition and Subtraction
            double result = numbers.get(0);
            for (int j = 0; j < operators.size(); j++) {
                char op = operators.get(j);
                double n2 = numbers.get(j + 1);
                if (op == '+') {
                    result += n2;
                } else if (op == '-') {
                    result -= n2;
                }
            }

            return result;

        } catch (NumberFormatException e) {
            throw new CalculatorException("Invalid numerical expression: " + expression);
        }
    }
}