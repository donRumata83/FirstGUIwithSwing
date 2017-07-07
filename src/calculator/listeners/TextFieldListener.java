package calculator.listeners;


import calculator.view.CalculatorJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class TextFieldListener implements FocusListener {

    private JTextField field;

    public TextFieldListener(JTextField field) {
        this.field = field;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (field.getText().trim().equals(CalculatorJFrame.ENTER)) field.setText("");
        field.setForeground(Color.GRAY);
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (field.getText().trim().equals("")) field.setText(CalculatorJFrame.ENTER);
        field.setForeground(Color.GRAY);
    }
}
