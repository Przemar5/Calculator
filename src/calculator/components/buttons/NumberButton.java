package calculator.components.buttons;

import calculator.components.Display;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends JButton implements ActionListener
{
    public NumberButton(String text)
    {
        super(text);
        setVisible(true);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Display d = Display.getInstance();
        String t = d.getText();

        if (Double.parseDouble(t) == 0)
            d.setText(getText());
        else if (t.length() < 10)
            d.setText(t + getText());
    }
}
