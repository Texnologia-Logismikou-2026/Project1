package com.calculator.controller;

import com.calculator.exception.CalculatorException;
import com.calculator.model.CalculatorModel;
import com.calculator.view.CalculatorView;
import com.calculator.service.HistoryService;
import com.calculator.view.calcform;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class CalculatorController implements ActionListener {

    private final CalculatorModel model;
    private final CalculatorView view;
    private final HistoryService historyService;


    public CalculatorController(CalculatorModel model, CalculatorView view, HistoryService historyService) {
        this.model = model;
        this.view = view;
        this.historyService = historyService;
        this.view.addButtonListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            buttonClick(e);
        } catch (CalculatorException ex) {
            view.showError();
        }
    }
    public void buttonClick(ActionEvent click) throws CalculatorException {
        String input = ((JButton)click.getSource()).getText();
        inputHandle(input);
    }

    public void buttonTyped(KeyEvent type) throws CalculatorException {
        String input = String.valueOf(type.getKeyChar());
        inputHandle(input);
    }

    public void inputHandle(String input) throws CalculatorException {

        String expresion = view.getDisplayText();

        switch (input){
            case "=":
            case "M+":
            case "M-":
                if (expresion.isBlank()){
                    return;
                }
                try {
                    double result = model.calculateExpression(expresion);
                    if (input.equals("M+")){
                        historyService.addM(result);
                    }
                    if (input.equals("M-")){
                        historyService.subM(result);
                    }
                    view.setDisplayText(String.valueOf(result));


                } catch (CalculatorException exception) {
                    view.showError();
                }

                break;
            case "clear":
                view.clearDisplay();
                break;
            case ".":
                addDec(expresion);
                break;
            case "+":
            case "-":
            case "/":
            case  "*":
                addOp(expresion,input);
                break;

            case "MC":
                historyService.clearM();
                break;

            case "BACKSPACE":
                if (!expresion.isEmpty()) {
                    view.setDisplayText(
                            expresion.substring(0, expresion.length() - 1)
                    );
                }
                break;

            default:
                if (input.matches("[0-9]")){
                    addDigit(expresion,input);
                }
                break;
        }
    }

    public void addDigit(String expresion,String input){
        view.setDisplayText(expresion+input);
    }

    public void addOp(String expresion,String op){
        if (expresion.isEmpty()){                                           //this method is for ensuring opperators
            if (op.equals("-")){                                            //aren't used twice in a row
                view.setDisplayText("-");
            }
            return;
        }
        char lastChar = expresion.charAt(expresion.length() - 1);

        if (isOperator(lastChar)) {

            view.setDisplayText(
                    expresion.substring(0, expresion.length() - 1)
                            + op);
        } else {
            view.setDisplayText(expresion + op);
        }
    }

    public void addDec(String expresion){
        int lastOperator = Math.max(                                //this method finds the last time an opperator
                expresion.lastIndexOf('+'),                     //was used to so a decimal point isn't used twice
                Math.max(                                           //on a single opperrand
                        expresion.lastIndexOf('-'),
                        Math.max(
                                expresion.lastIndexOf('*'),
                                expresion.lastIndexOf('/'))));

        String currentNumber = expresion.substring(lastOperator + 1);

        if (!currentNumber.contains(".")) {
            view.setDisplayText(expresion + ".");
        }
    }

    public boolean isOperator(char lastChar) {
        return lastChar == '+'
                || lastChar == '-'
                || lastChar == '*'
                || lastChar == '/';
    }


}