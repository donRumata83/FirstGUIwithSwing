package calculator.listeners;


import calculator.CalcFunctions;
import calculator.view.CalculatorJFrame;
import calculator.view.MyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class ButtonListener implements ActionListener {
    private CalculatorJFrame calc;
    private List<LookAndFeel> array = new ArrayList<>();

    public ButtonListener() {

    }

    public void setCalc(CalculatorJFrame calc) {
        this.calc = calc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof MyButton)) return;

        switch (e.getActionCommand()) {
            case "Plus" : calc.setResult(CalcFunctions.plus(calc.getFirstNumber(), calc.getSecondNumber()));
                break;
            case "Minus" :calc.setResult(CalcFunctions.minus(calc.getFirstNumber(), calc.getSecondNumber()));
                break;
            case "Divide" :calc.setResult(CalcFunctions.divide(calc.getFirstNumber(), calc.getSecondNumber()));
                break;
            case "Multiply" :calc.setResult(CalcFunctions.multiply(calc.getFirstNumber(), calc.getSecondNumber()));
                break;
        }
    }

}
