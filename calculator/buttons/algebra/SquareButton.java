package buttons.algebra;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import java.lang.Math;

import buttons.Button;
import go.Calc;

public class SquareButton extends Button {

    public static Action sqrAction = new SqrAction();
    public static Action sqrtAction = new SqrtAction();

    public SquareButton(Action action, String name) {
        super(action, name);
    }

    private static class SqrAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calc.currentValue = Float.parseFloat(Calc.textField.getText().replace(',', '.'));

            Calc.lastValue = Calc.currentValue * Calc.currentValue;

            Calc.textField.setText((String.valueOf(Calc.lastValue)).replace('.', ','));
            Calc.label.setText((String.valueOf(Calc.currentValue)).replace('.', ',') + " ^ "
                    + 2 + " =");
        }
    }

    private static class SqrtAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calc.currentValue = Float.parseFloat(Calc.textField.getText().replace(',', '.'));

            Calc.lastValue = (float) Math.sqrt(Calc.currentValue);

            Calc.textField.setText((String.valueOf(Calc.lastValue)).replace('.', ','));
            Calc.label.setText(" √ " + (String.valueOf(Calc.currentValue)).replace('.', ',') + " =");
        }
    }

}
