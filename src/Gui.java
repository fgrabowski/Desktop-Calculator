import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

class Gui implements ActionListener {




    JFrame frame;
    JTextField textField;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton, clrButton;
    JPanel tab;

    Shape shape = new Ellipse2D.Double(0, 0, 200, 200);


    double num1 = 0.0, num2 = 0.0, num3 = 0.0;
    char operator;

    boolean isSolved = false;
    Font font = Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("Helvetica.ttf"));

    Gui() throws IOException, FontFormatException {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocation(500, 200);
        frame.getContentPane().setBackground(new Color(39, 34, 35));

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font.deriveFont(35f));
        textField.setEditable(false);
        textField.setBackground(new Color(39, 34, 35));
        textField.setForeground(new Color(255, 255, 255));
        textField.setHorizontalAlignment(JTextField.RIGHT);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = eqButton;
        functionButton[6] = clrButton;

        for (int i = 0; i < 7; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(font.deriveFont(35f));
            functionButton[i].setFocusable(false);
            functionButton[i].setBackground(new Color(51, 153, 255));
            functionButton[i].setForeground(Color.black);
        }

        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(font.deriveFont(35f));
            numberButton[i].setFocusable(false);
            numberButton[i].setBorder( new LineBorder(new Color(101, 98, 95)) );
            numberButton[i].setOpaque(true);
            numberButton[i].setBackground(new Color(101, 98, 95));
            numberButton[i].setContentAreaFilled(true);
        }

        clrButton.setBounds(205, 430, 145, 50);

        tab = new JPanel();

        tab.setBounds(50, 100, 300, 300);
        tab.setLayout(new GridLayout(4, 4, 10, 10));
        tab.setBackground(new Color(39, 34, 35));


        tab.add(numberButton[1]);
        tab.add(numberButton[2]);
        tab.add(numberButton[3]);
        tab.add(addButton);

        tab.add(numberButton[4]);
        tab.add(numberButton[5]);
        tab.add(numberButton[6]);
        tab.add(subButton);

        tab.add(numberButton[7]);
        tab.add(numberButton[8]);
        tab.add(numberButton[9]);
        tab.add(mulButton);
        tab.add(numberButton[0]);
        tab.add(decButton);
        tab.add(eqButton);
        tab.add(divButton);


        JTabbedPane tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);
        tabbedPane.add("Calculator", tab);
        frame.add(tab);
        frame.add(clrButton);
        frame.add(textField);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        for(int i = 0; i < 10; i++) {
            if(isSolved) {
                textField.setText(" ");
                isSolved = false;
            }
            if (e.getSource() == numberButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }}
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");

        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");

        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");

        }
        if(e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    num3 = num1 + num2;
                    break;
                case '-':
                    num3 = num1 - num2;
                    break;
                case '/':
                    num3 = num1 / num2;
                    break;
                case '*':
                    num3 = num1 * num2;
                    break;
            }
            textField.setText(String.valueOf(num3));
            isSolved = true;
            num1 = num3;

            if (e.getSource() == clrButton) {
                textField.setText("");

            }
            if (e.getSource() == delButton) {
                String string = textField.getText();
                textField.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    textField.setText(textField.getText() + string.charAt(i));
                }
            }
        }

    }
}
