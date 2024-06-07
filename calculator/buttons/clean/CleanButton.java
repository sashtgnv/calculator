package buttons.clean;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import buttons.Button;
import go.Calc;

public class CleanButton extends Button {

    public static Action fullCleanAction = new FullCleanAction();
    public static Action oneCleanAction = new OneCleanAction();

    public CleanButton(Action action, String name) {
        super(action, name);
    }

    // public CleanButton(Action action, String name) {
    // super(action,name);
    // }

    private static class FullCleanAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calc.textField.setText("0");
            Calc.label.setText("");
            Calc.lastValue = 0;
            Calc.lastActionSign = "";
            Calc.lastAction = null;
        }
    }

    private static class OneCleanAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Calc.textField.getText().length() > 1
                    && !(Calc.textField.getText().contains("-") & Calc.textField.getText().length() == 2)) {
                Calc.textField.setText(Calc.textField.getText().substring(0, Calc.textField.getText().length() - 1));
            } else {
                Calc.textField.setText("0");
            }

        }

    }

}
