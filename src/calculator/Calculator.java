package calculator;


import calculator.view.CalculatorJFrame;


import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Calculator {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());

        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();

        }

        CalculatorJFrame calc = new CalculatorJFrame();


    }
}
