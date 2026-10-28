package com.calculator.view;

import com.calculator.controller.CalculatorController;
import com.calculator.model.BasicCalculatorModel;
import com.calculator.model.CalculatorModel;
import com.calculator.service.HistoryService;
import com.calculator.service.InMemoryHistoryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class calcform implements CalculatorView {

    private JPanel panel1;
    private JButton a7Button;
    private JButton clearButton;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton mulButton;
    private JButton minusButton;
    private JButton addButton;
    private JButton resultButton;
    private JButton a6Button;
    private JButton a3Button1;
    private JButton dotButton;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a0Button;
    private JButton slashButton;
    private JButton rootButton;
    private JButton powerButton;
    private JButton backspaceButton;
    private JPanel buttonpan;
    private JTextField textfieldforcalc;

    public calcform() {
        // Εξασφάλιση ότι τα components έχουν αρχικοποιηθεί
        initComponents();
        styleButtons();
    }

    private void initComponents() {
        if (panel1 == null) {
            panel1 = new JPanel(new BorderLayout(5, 5));
            panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            textfieldforcalc = new JTextField();
            textfieldforcalc.setFont(new Font("Arial", Font.BOLD, 22));
            textfieldforcalc.setHorizontalAlignment(JTextField.RIGHT);
            textfieldforcalc.setEditable(false);
            panel1.add(textfieldforcalc, BorderLayout.NORTH);

            buttonpan = new JPanel(new GridLayout(5, 4, 5, 5));

            // Γραμμή 1
            clearButton = new JButton("C");
            backspaceButton = new JButton("⌫");
            powerButton = new JButton("^");
            slashButton = new JButton("/");

            // Γραμμή 2
            a7Button = new JButton("7");
            a8Button = new JButton("8");
            a9Button = new JButton("9");
            mulButton = new JButton("*");

            // Γραμμή 3
            a4Button = new JButton("4");
            a5Button = new JButton("5");
            a6Button = new JButton("6");
            minusButton = new JButton("-");

            // Γραμμή 4
            a1Button = new JButton("1");
            a2Button = new JButton("2");
            a3Button1 = new JButton("3");
            addButton = new JButton("+");

            // Γραμμή 5
            rootButton = new JButton("√");
            a0Button = new JButton("0");
            dotButton = new JButton(".");
            resultButton = new JButton("=");

            // Τοποθέτηση στο Grid Panel
            buttonpan.add(clearButton);
            buttonpan.add(backspaceButton);
            buttonpan.add(powerButton);
            buttonpan.add(slashButton);

            buttonpan.add(a7Button);
            buttonpan.add(a8Button);
            buttonpan.add(a9Button);
            buttonpan.add(mulButton);

            buttonpan.add(a4Button);
            buttonpan.add(a5Button);
            buttonpan.add(a6Button);
            buttonpan.add(minusButton);

            buttonpan.add(a1Button);
            buttonpan.add(a2Button);
            buttonpan.add(a3Button1);
            buttonpan.add(addButton);

            buttonpan.add(rootButton);
            buttonpan.add(a0Button);
            buttonpan.add(dotButton);
            buttonpan.add(resultButton);

            panel1.add(buttonpan, BorderLayout.CENTER);
        }
    }

    private void styleButtons() {
        JButton[] buttons = {
                a7Button, clearButton, a1Button, a4Button, a8Button, a9Button,
                mulButton, minusButton, addButton, resultButton, a6Button,
                a3Button1, dotButton, a5Button, a2Button, a0Button,
                slashButton, rootButton, powerButton, backspaceButton
        };

        for (JButton btn : buttons) {
            if (btn != null) {
                btn.setFont(new Font("Arial", Font.BOLD, 16));
                btn.setFocusPainted(false);
                btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
            }
        }
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setDisplayText(String text) {
        if (textfieldforcalc != null) {
            textfieldforcalc.setText(text);
        }
    }

    public String getDisplayText() {
        return (textfieldforcalc != null) ? textfieldforcalc.getText() : "";
    }

    @Override
    public void showError() {
        if (textfieldforcalc != null) {
            textfieldforcalc.setText("Error");
        }
    }

    public void showError(String message) {
        if (textfieldforcalc != null) {
            textfieldforcalc.setText(message);
        }
    }

    public void clearDisplay() {
        if (textfieldforcalc != null) {
            textfieldforcalc.setText("");
        }
    }

    @Override
    public void addButtonListener(ActionListener listener) {
        JButton[] buttons = {
                a7Button, clearButton, a1Button, a4Button, a8Button, a9Button,
                mulButton, minusButton, addButton, resultButton, a6Button,
                a3Button1, dotButton, a5Button, a2Button, a0Button,
                slashButton, rootButton, powerButton, backspaceButton
        };

        for (JButton btn : buttons) {
            if (btn != null) {
                btn.addActionListener(listener);
            }
        }
    }
}