package buttons.input;

import buttons.Button;
import buttons.clean.CleanButton;
import go.Calc;

import java.awt.event.ActionEvent;

public class CommaButton extends Button {

    public static Action action = new Action();

    public CommaButton(Action action, String name) {
        super(action, name);
    }

    static class Action extends ActionAdd {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!Calc.textField.getText().contains(",") && !Calc.label.getText().contains("=")) {
                super.actionPerformed(e);
            }
            else  {
                CleanButton.fullCleanAction.actionPerformed(e);
            }
        }
    }
}