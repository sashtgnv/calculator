package buttons;

import javax.swing.*;

import go.Calc;

import java.awt.*;

public class Button extends JButton {

    public Button(String name) {
        super(name);
    }

    public Button(Action action, String name) {
        super(action);
        setText(name);
    }

    public void addButton(int x, int y) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 85;
        constraints.weighty = 1;
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        this.setFont(Calc.fontButton);
        Calc.panel.add(this, constraints);

    }
}
