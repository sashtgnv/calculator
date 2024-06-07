package go;

import javax.swing.*;

import java.awt.*;

import buttons.Button;
import buttons.algebra.*;
import buttons.clean.CleanButton;
import buttons.equal.EqualButton;
import buttons.input.*;

public class Calc {
    private static JFrame frame = new JFrame();
    public static JPanel panel = new JPanel();
    public static JTextField textField = new JTextField(16);
    public static JLabel label = new JLabel("");
    private static Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static Dimension dimension = toolkit.getScreenSize();
    public static Font fontButton = new Font("", 0, 20);
    private static Font fontTextField = new Font("", 0, 30);
    private static Font fontLabel = new Font("", 0, 20);

    public static float currentValue = 0;
    public static float lastValue = 0;
    public static String lastActionSign = "";
    public static String equalOutput = "";
    public static Action lastAction = null;

    public static void main(String[] args) {
        prepareFrame();
        paintPanel();
    }

    static void paintPanel() {
        GridBagConstraints constraints = new GridBagConstraints();

        for (int i = 0; i < 9; i = i + 2) {
            constraints.gridx = i;
            panel.add(Box.createHorizontalStrut(5), constraints);
        }

        constraints.gridy = 0;
        panel.add(Box.createVerticalStrut(30), constraints);
        constraints.gridy = 1;
        panel.add(Box.createVerticalStrut(30), constraints);
        for (int i = 5; i < 18; i = i + 2) {
            constraints.gridy = i;
            panel.add(Box.createVerticalStrut(5), constraints);
        }

        Button buttonEqual = new EqualButton(EqualButton.action, "=");
        buttonEqual.addButton(7, 16);
        Button buttonComma = new CommaButton(CommaButton.action, ",");
        buttonComma.addButton(5, 16);
        Button button0 = new NumButton(NumButton.action, "0");
        button0.addButton(3, 16);
        Button buttonSign = new SignButton(SignButton.action, "+/-");
        buttonSign.addButton(1, 16);

        Button buttonPlus = new PlusButton(PlusButton.plusAction, "+");
        buttonPlus.addButton(7, 14);
        Button button3 = new NumButton(NumButton.action, "3");
        button3.addButton(5, 14);
        Button button2 = new NumButton(NumButton.action, "2");
        button2.addButton(3, 14);
        Button button1 = new NumButton(NumButton.action, "1");
        button1.addButton(1, 14);

        Button buttonMinus = new PlusButton(PlusButton.minusAction, "-");
        buttonMinus.addButton(7, 12);
        Button button6 = new NumButton(NumButton.action, "6");
        button6.addButton(5, 12);
        Button button5 = new NumButton(NumButton.action, "5");
        button5.addButton(3, 12);
        Button button4 = new NumButton(NumButton.action, "4");
        button4.addButton(1, 12);

        Button buttonMultiplication = new MultiplicButton(MultiplicButton.multipAction, "x");
        buttonMultiplication.addButton(7, 10);
        Button button9 = new NumButton(NumButton.action, "9");
        button9.addButton(5, 10);
        Button button8 = new NumButton(NumButton.action, "8");
        button8.addButton(3, 10);
        Button button7 = new NumButton(NumButton.action, "7");
        button7.addButton(1, 10);

        Button buttonDiv = new MultiplicButton(MultiplicButton.divAction, "÷");
        buttonDiv.addButton(7, 8);
        Button buttonSqrt = new SquareButton(SquareButton.sqrtAction, "√");
        buttonSqrt.addButton(5, 8);
        Button buttonSqr = new SquareButton(SquareButton.sqrAction, "x²");
        buttonSqr.addButton(3, 8);
        Button buttonPiece = new ProportionButton(ProportionButton.action, "1/x");
        buttonPiece.addButton(1, 8);

        Button buttonDelete = new Button(CleanButton.oneCleanAction, "⌫");
        buttonDelete.addButton(7, 6);
        Button buttonClear = new CleanButton(CleanButton.fullCleanAction, "C");
        buttonClear.addButton(5, 6);

        textField.setEnabled(true);
        textField.setFont(fontTextField);
        textField.setForeground(Color.black);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setText("0");
        textField.setEditable(false);

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.weightx = 0;
        constraints3.weighty = 0;
        constraints3.gridx = 1;
        constraints3.gridy = 2;
        constraints3.gridheight = 2;
        constraints3.gridwidth = 7;
        constraints3.fill = GridBagConstraints.BOTH;
        panel.add(textField, constraints3);

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.weightx = 0;
        constraints2.weighty = 0;
        constraints2.gridx = 1;
        constraints2.gridy = 1;
        constraints2.gridheight = 1;
        constraints2.gridwidth = 7;
        constraints2.fill = GridBagConstraints.BOTH;
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setFont(fontLabel);
        panel.add(label, constraints2);

        frame.add(panel);
    }

    static void prepareFrame() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Калькулятор");
        frame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 250, 350, 500);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        frame.add(panel);
    }

}