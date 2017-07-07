package calculator.view;

import calculator.listeners.ButtonListener;
import calculator.listeners.ChangeSkinListener;
import calculator.listeners.TextFieldListener;

import javax.swing.*;
import java.awt.*;


public class CalculatorJFrame extends JFrame {
    public static final String ENTER = "Enter number";

    private JPanel enterPanel;
    private JPanel buttonPanel;
    private JPanel resultPanel;

    private JTextField firstNumber;
    private JTextField secondNumber;

    private MyButton plus;
    private MyButton minus;
    private MyButton multiply;
    private MyButton divide;

    private JTextField result;

    private ButtonListener listener;


    public CalculatorJFrame() throws HeadlessException {
        super("Calculator");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.listener = new ButtonListener();
        listener.setCalc(this);


        this.setSize(500, 520);
        this.setMinimumSize(new Dimension(500, 520));
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout(2, 10));

        addEnterPanel();
        addButtonPanel();
        addResultPanel("");


        this.getContentPane().add(enterPanel, BorderLayout.NORTH);
        this.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        this.getContentPane().add(resultPanel, BorderLayout.SOUTH);


        this.setVisible(true);

    }


    private void addEnterPanel() {
        EnterFieldsPanel enterPanel = new EnterFieldsPanel();
        enterPanel.add(new JLabel("First Number"));
        this.firstNumber = new JTextField(ENTER, 10);
        firstNumber.setForeground(Color.GRAY);
        firstNumber.addFocusListener(new TextFieldListener(firstNumber));
        enterPanel.add(firstNumber);
        enterPanel.add(new JLabel("Second Number"));
        secondNumber = new JTextField(ENTER, 10);
        secondNumber.setForeground(Color.GRAY);
        enterPanel.add(secondNumber);
        secondNumber.addFocusListener(new TextFieldListener(secondNumber));
        this.enterPanel = enterPanel;

    }

    private void addButtonPanel() {
        ButtonsPanel buttonPanel = new ButtonsPanel();
        this.plus = new MyButton("Plus");
        plus.setActionCommand("Plus");
        plus.addActionListener(listener);
        buttonPanel.add(plus);
        this.minus = new MyButton("Minus");
        minus.setActionCommand("Minus");
        minus.addActionListener(listener);
        buttonPanel.add(minus);
        this.multiply = new MyButton("Multiply");
        multiply.setActionCommand("Multiply");
        multiply.addActionListener(listener);
        buttonPanel.add(multiply);
        this.divide = new MyButton("Divide");
        divide.setActionCommand("Divide");
        divide.addActionListener(listener);
        buttonPanel.add(divide);
        this.buttonPanel = buttonPanel;
    }

    public void addResultPanel(String text) {
        ResultPanel resultPanel = new ResultPanel();

        JTextField field = new JTextField(20);
        if (!text.equals("")) field.setText(text);
        field.setFocusable(false);
        this.result = field;
        resultPanel.add(field);
        this.resultPanel = resultPanel;

        MyButton changeSkin = new MyButton("Change Skin");
        changeSkin.addActionListener(new ChangeSkinListener(this));
        resultPanel.add(changeSkin);
    }


    public double getFirstNumber() {
        try {
            return Double.parseDouble(firstNumber.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to enter the number!");
            firstNumber.setText(ENTER);

        }
        return 0;
    }

    public double getSecondNumber() {
        try {
            return Double.parseDouble(secondNumber.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to enter the number!");
            secondNumber.setText(ENTER);

        }
        return 0;
    }

    public void setResult(double i) {
        result.setText(String.valueOf(i));
    }
}
