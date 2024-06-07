package buttons.input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import go.Calc;

public class ActionAdd extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        Calc.textField.setText(Calc.textField.getText() + ((JButton) e.getSource()).getText());
    }
}
