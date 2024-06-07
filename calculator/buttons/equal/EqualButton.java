package buttons.equal;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import buttons.Button;
import go.Calc;

public class EqualButton extends Button {

    public static Action action = new Action();

    public EqualButton(Action action, String name) {
        super(action, name);
    }

    public static class Action extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Calc.lastAction!=null) {
                Calc.lastAction.actionPerformed(e);
                Calc.textField.setText((String.valueOf(Calc.lastValue)).replace('.', ','));
                Calc.label.setText(Calc.equalOutput);
        }
        }
    }

}
