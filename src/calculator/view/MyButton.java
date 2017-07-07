package calculator.view;

import javax.swing.*;
import java.awt.*;


public class MyButton extends JButton {
    public MyButton(String text) {
        super(text);
        this.setPreferredSize(new Dimension(100,100));
    }
}
