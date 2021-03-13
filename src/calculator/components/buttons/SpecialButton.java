package calculator.components.buttons;

import calculator.operations.SpeciallyOperable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialButton extends JButton implements ActionListener
{
    protected SpeciallyOperable op;

    public SpecialButton(String text, SpeciallyOperable op)
    {
        super(text);
        this.op = op;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        op.operate();
    }
}
