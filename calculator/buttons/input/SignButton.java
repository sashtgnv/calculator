package buttons.input;

import java.awt.event.ActionEvent;

import buttons.Button;
import buttons.clean.CleanButton;
import go.Calc;

public class SignButton extends Button {

    public static Action action = new Action();

    public SignButton(Action action, String name) {
        super(action, name);
    }

    static class Action extends ActionAdd {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!Calc.textField.getText().equals("0") && !Calc.textField.getText().contains("-")
                    && !Calc.label.getText().contains("=")) {
                Calc.textField.setText("-" + Calc.textField.getText());
            } else if (Calc.textField.getText().contains("-") && !Calc.label.getText().contains("=")) {
                Calc.textField.setText(Calc.textField.getText().substring(1));
            }
            else {
                CleanButton.fullCleanAction.actionPerformed(e);
            }
        }
    }

}
