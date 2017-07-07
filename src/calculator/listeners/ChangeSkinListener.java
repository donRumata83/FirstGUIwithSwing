package calculator.listeners;

import calculator.view.CalculatorJFrame;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;


import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class ChangeSkinListener implements ActionListener {
    private CalculatorJFrame calc;
    private List<LookAndFeel> array;
    public static int counter = 0;

    public ChangeSkinListener(CalculatorJFrame calc) {
        this.calc = calc;
        this.array = new ArrayList<>();
        array.add(new SmartLookAndFeel());
        array.add(new HiFiLookAndFeel());
        array.add(new NimbusLookAndFeel());
        array.add(new LunaLookAndFeel());
        array.add(new AeroLookAndFeel());
        array.add(new AcrylLookAndFeel());
        array.add(new AluminiumLookAndFeel());
        array.add(new FastLookAndFeel());
        array.add(new NoireLookAndFeel());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (counter != array.size() - 1) {
            try {
                UIManager.setLookAndFeel(array.get(counter));
                counter++;
            } catch (UnsupportedLookAndFeelException e1) {
            }
            SwingUtilities.updateComponentTreeUI(calc);
        } else {
            counter = 0;
            try {
                UIManager.setLookAndFeel(array.get(counter));
                counter++;
            } catch (UnsupportedLookAndFeelException e1) {
            }
            SwingUtilities.updateComponentTreeUI(calc);
        }
    }
}
