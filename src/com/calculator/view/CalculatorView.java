package com.calculator.view;

import java.awt.event.ActionListener;
import java.util.function.Consumer;

public interface CalculatorView {
    void setDisplayText(String text);
    String getDisplayText();
    void showError();
    void clearDisplay();
    void addButtonListener(ActionListener listener);

}