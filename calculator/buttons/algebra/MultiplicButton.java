package buttons.algebra;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import buttons.Button;
import go.Calc;

public class MultiplicButton extends Button {

    public static Action multipAction = new MultiplicAction();
    public static Action divAction = new DivAction();

    public MultiplicButton(Action action, String name) {
        super(action, name);
    }

    private static class MultiplicAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calc.currentValue = Float.parseFloat(Calc.textField.getText().replace(',', '.'));
            Calc.textField.setText("0");
            Calc.equalOutput = (String.valueOf(Calc.lastValue)).replace('.', ',') + " * "
                    + (String.valueOf(Calc.currentValue)).replace('.', ',') + " =";

            if (Calc.label.getText() != "" && !Calc.label.getText().contains("=")) {
                Calc.lastValue = Calc.currentValue * Calc.lastValue;
            } else {
                Calc.lastValue = Calc.currentValue;
            }
            Calc.lastAction = multipAction;
            Calc.label.setText((String.valueOf(Calc.lastValue)).replace('.', ',') + "*");
        }

    }

    private static class DivAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calc.currentValue = Float.parseFloat(Calc.textField.getText().replace(',', '.'));
            Calc.textField.setText("0");
            Calc.equalOutput = (String.valueOf(Calc.lastValue)).replace('.', ',') + " / "
                    + (String.valueOf(Calc.currentValue)).replace('.', ',') + " =";

            if (Calc.label.getText() == "" || Calc.label.getText().contains("=")) {
                Calc.lastValue = Calc.currentValue;
            } else {
                if (Calc.currentValue != 0) {
                    Calc.lastValue = Calc.lastValue / Calc.currentValue;
                } else {
                    Calc.equalOutput = "Деление на ноль невозможно";
                    return;
                }
            }
            Calc.lastAction = divAction;
            Calc.lastActionSign = "/";
            Calc.label.setText((String.valueOf(Calc.lastValue)).replace('.', ',') + "/");
        }

    }

}
