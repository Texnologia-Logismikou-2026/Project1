package com.calculator.controller;

import com.calculator.model.CalculatorModel;
import com.calculator.service.HistoryService;
import com.calculator.view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CalculatorController {

    private final CalculatorModel model;
    private final CalculatorView view;
    private final HistoryService historyService;

    public CalculatorController(CalculatorModel model, CalculatorView view, HistoryService historyService) {
        this.model = model;
        this.view = view;
        this.historyService = historyService;

        // Σύνδεση του listener σε όλα τα κουμπιά του View
        this.view.addButtonListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = ((JButton) e.getSource()).getText();

            switch (text) {
                case "C":
                    view.clearDisplay();
                    break;

                case "⌫":
                    String currentText = view.getDisplayText();
                    if (!currentText.isEmpty()) {
                        view.setDisplayText(currentText.substring(0, currentText.length() - 1));
                    }
                    break;

                case "=":
                    String expr = view.getDisplayText().trim();
                    if (!expr.isEmpty()) {
                        try {
                            double res = model.calculateExpression(expr);
                            view.setDisplayText(String.valueOf(res));
                            historyService.addEntry(expr, res);
                        } catch (Exception ex) {
                            view.showError();
                        }
                    }
                    break;

                default:
                    // Αριθμοί και τελεστές (+, -, *, /, ^, √, .)
                    view.setDisplayText(view.getDisplayText() + text);
                    break;
            }
        }
    }
}