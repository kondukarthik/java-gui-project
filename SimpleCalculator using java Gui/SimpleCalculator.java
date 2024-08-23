import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
    private JPanel panel;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator = ' ';
    private boolean isOperatorSet = false;
    public SimpleCalculator() {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        display = new JTextField();
        display.setBounds(50, 25, 300, 50);
        display.setEditable(false);
        add(display);
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");
        operationButtons = new JButton[]{addButton, subButton, mulButton, divButton, eqButton, clrButton};
        for (JButton button : operationButtons) {
            button.addActionListener(this);
        }
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(clrButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                if (isOperatorSet) {
                    display.setText(String.valueOf(i));
                    isOperatorSet = false;
                } else {
                    display.setText(display.getText().concat(String.valueOf(i)));
                }
            }
        }
        if (e.getSource() == clrButton) {
            display.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
            operator = ' ';
            isOperatorSet = false;
        }
        if (e.getSource() == addButton) {
            setOperator('+');
        } else if (e.getSource() == subButton) {
            setOperator('-');
        } else if (e.getSource() == mulButton) {
            setOperator('*');
        } else if (e.getSource() == divButton) {
            setOperator('/');
        }
        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
            isOperatorSet = true;
        }
    }
    private void setOperator(char op) {
        if (operator != ' ') {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        } else {
            num1 = Double.parseDouble(display.getText());
        }
        operator = op;
        isOperatorSet = true;
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
