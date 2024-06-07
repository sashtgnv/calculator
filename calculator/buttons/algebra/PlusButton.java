package buttons.algebra;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import buttons.Button;
import go.Calc;

public class PlusButton extends Button {

    public static Action plusAction = new PlusAction();
    public static Action minusAction = new MinusAction();

    public PlusButton(Action action, String name) {
        super(action, name);
    }

    private static class PlusAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calc.currentValue = Float.parseFloat(Calc.textField.getText().replace(',', '.'));
            Calc.textField.setText("0");
            Calc.equalOutput = (String.valueOf(Calc.lastValue)).replace('.', ',') + " + "
                    + (String.valueOf(Calc.currentValue)).replace('.', ',') + " =";
            if (Calc.label.getText() != "" && !Calc.label.getText().contains("=")) {
                Calc.lastValue += Calc.currentValue;
            } else {
                Calc.lastValue = Calc.currentValue;
            }
            Calc.lastAction = plusAction;
            Calc.lastActionSign = "+";
            Calc.label.setText((String.valueOf(Calc.lastValue)).replace('.', ',') + "+");
        }
    }

    private static class MinusAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calc.currentValue = Float.parseFloat(Calc.textField.getText().replace(',', '.'));
            Calc.textField.setText("0");
            Calc.equalOutput = (String.valueOf(Calc.lastValue)).replace('.', ',') + " - "
                    + (String.valueOf(Calc.currentValue)).replace('.', ',') + " =";

            if (Calc.label.getText() != "" && !Calc.label.getText().contains("=")) {
                Calc.lastValue -= Calc.currentValue;
            } else {
                Calc.lastValue = Calc.currentValue;
            }
            Calc.lastAction = minusAction;
            Calc.label.setText((String.valueOf(Calc.lastValue)).replace('.', ',') + "-");
        }
    }

}
