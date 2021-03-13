package calculator.components;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.RIGHT;

public class OperationHistory extends JTextPane
{
    private static OperationHistory instance;
    private JScrollPane scroll;

    public static OperationHistory getInstance()
    {
        if (instance == null) {
            instance = new OperationHistory();
        }
        return instance;
    }

    private OperationHistory()
    {
        super();
//        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setFont(new Font("Lato", Font.PLAIN, 18));
        setEditable(false);
        scroll = new JScrollPane(this);
    }
}
