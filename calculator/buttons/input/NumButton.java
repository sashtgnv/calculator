package buttons.input;

import buttons.Button;
import buttons.clean.CleanButton;
import go.Calc;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class NumButton extends Button {

    public static Action action = new Action();

    public NumButton(Action action, String name) {
        super(action, name);
    }

    static class Action extends ActionAdd {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!Calc.label.getText().contains("=")){
                if (Calc.textField.getText().equals("0")) {
                Calc.textField.setText(((JButton) e.getSource()).getText());
                } else {
                super.actionPerformed(e);
                }
            } else {
                CleanButton.fullCleanAction.actionPerformed(e);
            }
            
        }
    }
}
