package calculator.components;

import calculator.components.buttons.NumberButton;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel
{
    public ButtonPanel()
    {
        super();
        setLayout(new GridLayout(4, 5));
        add(new NumberButton("1"));
        setVisible(true);
    }
}
