package com.calculator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calcform {
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

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            calcform form = new calcform();

            JFrame frame = new JFrame("Calculator");
            frame.setContentPane(form.panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 420);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setMinimumSize(new Dimension(250, 350));
        });

    }
    public calcform() {
        a7Button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2,true));
        clearButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        a1Button.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        a4Button.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        a8Button.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        a9Button.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        mulButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        minusButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        addButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        resultButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        a6Button.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        a3Button1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        dotButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        a5Button.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        a2Button.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        a0Button.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        slashButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        rootButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        powerButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        backspaceButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        backspaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        powerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rootButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        slashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        dotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a3Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void setDisplayText(String text) {
        textfieldforcalc.setText(text);
    }

    public String getDisplayText() {
        return textfieldforcalc.getText();
    }

    public void showError(String message) {
        textfieldforcalc.setText(message);
    }

    public void clearDisplay() {
        textfieldforcalc.setText("");
    }

}
