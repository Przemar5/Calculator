package calculator;

import calculator.components.ButtonPanel;
import calculator.components.Display;
import calculator.components.OperationHistory;
import calculator.components.buttons.NumberButton;
import calculator.components.buttons.OperationButton;
import calculator.components.buttons.SpecialButton;
import calculator.operations.Operable;
import calculator.operations.SpeciallyOperable;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame
{
    private Display display;
    private OperationHistory opHistory;

    public CalculatorView()
    {
        setSize(480, 300);
        setTitle("Calculator");
        setLocationRelativeTo(null);
        setVisible(true);
        setMinimumSize(new Dimension(200, 280));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.gridwidth = 4;
        opHistory = OperationHistory.getInstance();
        add(opHistory, gbc);

        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.fill = GridBagConstraints.VERTICAL;
        JScrollPane scroll = new JScrollPane(opHistory);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 4;
        display = Display.getInstance();
        add(display, gbc);

        JButton[][] buttons = new JButton[][]{
                {
                        new NumberButton("7"),
                        new NumberButton("8"),
                        new NumberButton("9"),
                        new OperationButton("*", (a, b) -> a * b),
                },
                {
                        new NumberButton("4"),
                        new NumberButton("5"),
                        new NumberButton("6"),
                        new OperationButton("/", (a, b) -> a / b),
                },
                {
                        new NumberButton("1"),
                        new NumberButton("2"),
                        new NumberButton("3"),
                        new OperationButton("+", (a, b) -> a / b),
                },
                {
                        new NumberButton("0"),
                        new NumberButton("."),
                        new OperationButton("%", (a, b) -> a % b),
                        new OperationButton("-", (a, b) -> a / b),
                },
        };
        addPanelOfButtons(buttons, gbc);
        addCommonSpecialButtonsRow(buttons.length + 2, gbc);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addPanelOfButtons(JButton[][] buttons, GridBagConstraints gbc)
    {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                addButton(buttons[i][j], gbc,i + 2, j, 1, 1);
            }
        }
    }

    private void addButton(JButton b, GridBagConstraints gbc,
                           int row, int col, int wx, int wy)
    {
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.weightx = wx;
        gbc.weighty = wy;
        add(b, gbc);
    }

    private void addCommonSpecialButtonsRow(int row, GridBagConstraints gbc)
    {
        SpecialButton acb = new SpecialButton("AC", () -> {
            Display d = Display.getInstance();
            Model.initialized = false;
            Model.operation = "";
            d.setText("0");
        });
        addButton(acb, gbc, row, 0, 2, 1);

        SpecialButton cb = new SpecialButton("C", () -> {
            Display d = Display.getInstance();
            d.setText("0");
        });
        addButton(cb, gbc, row, 1, 1, 1);

        SpecialButton eb = new SpecialButton("=", () -> {
            Display d = Display.getInstance();
            OperationHistory oh = OperationHistory.getInstance();
            String answer = Model.first + " " +
                    Model.operation + " " + d.getText() + " = " +
                    Model.calculate(Double.parseDouble(d.getText()));
            answer = (oh.getText() == "") ? answer : oh.getText() + "\n" + answer;
            oh.setText(answer);
            d.setText("0");
        });
        addButton(eb, gbc, row, 2, 1, 1);
    }
}
