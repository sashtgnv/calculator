package buttons.algebra;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import buttons.Button;
import go.Calc;

public class ProportionButton extends Button {

    public static Action action = new Action();

    public ProportionButton(Action action, String name) {
        super(action, name);
    }

    private static class Action extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calc.currentValue = Float.parseFloat(Calc.textField.getText().replace(',', '.'));

            Calc.lastValue = 1 / Calc.currentValue;

            Calc.textField.setText((String.valueOf(Calc.lastValue)).replace('.', ','));
            Calc.label.setText(1 + " / " + (String.valueOf(Calc.currentValue)).replace('.', ',') + " =");
        }
    }
}
