package calculator.components.buttons;

import calculator.Model;
import calculator.components.Display;
import calculator.components.OperationHistory;
import calculator.operations.Operable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationButton extends JButton implements ActionListener
{
    protected Operable op;

    public OperationButton(String text, Operable op)
    {
        super(text);
        setVisible(true);
        this.op = op;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Display d = Display.getInstance();
        Model.operation = getText();
        if (Model.initialized) {
            double a = Model.first;
            double b = Double.parseDouble(d.getText());
            double c = Model.first = op.operate(a, b);
            d.setText(c + "");
            Model.first = b;
            OperationHistory oh = OperationHistory.getInstance();
            oh.setText(oh.getText() + "\n" + a + " " + getText() + " " + b + " = " + c);
        }
        else {
            Model.first = Double.parseDouble(d.getText());
            Model.initialized = true;
        }
        d.setText("0");
    }
}
