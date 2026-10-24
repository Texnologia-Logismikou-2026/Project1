package com.calculator.view;

public interface CalculatorView {
    void setDisplayText(String text);
    String getDisplayText();
    void showError(String errorMessage);
    void clearDisplay();
}