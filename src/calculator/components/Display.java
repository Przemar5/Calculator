package calculator.components;

import calculator.CalculatorView;

import javax.swing.*;
import java.awt.*;

public class Display extends JTextField
{
    private static Display instance;

    public static Display getInstance()
    {
        if (instance == null) {
            instance = new Display("0");
        }
        return instance;
    }

    private Display(String text)
    {
        super(text);
//        setHorizontalTextPosition(RIGHT);
        setHorizontalAlignment(RIGHT);
        setFont(new Font("Lato", Font.PLAIN, 32));
//        setSize(480, 42);
        setBounds(0, 0, 480, 54);
        setVisible(true);
    }
}
