package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    private static JFrame f;
    private static JTextField textField_1, textField_2, textField_3, textField_4;
    private static JButton button1, button2, button3, button4, button5, button6;
    private static float number1, number2, number3, result;
    private static int operator;
    private static Border blackline;
    private static Border emptyBorder;
    private static Font font = new Font("Britannic Bold", Font.PLAIN, 14);

    public Menu(){
        f = new JFrame("Button Example");
        blackline = BorderFactory.createLineBorder(Color.black);
        emptyBorder = BorderFactory.createEmptyBorder();

        //enter name label
        JLabel labe1_1 = new JLabel();
        JLabel labe1_2 = new JLabel();
        JLabel labe1_3 = new JLabel();
        JLabel labe1_4 = new JLabel();

        labe1_1.setText("First number :");
        labe1_1.setFont(font);
        labe1_1.setBounds(10, 15, 100, 100);

        labe1_2.setText("Second number :");
        labe1_2.setFont(font);
        labe1_2.setBounds(10, 65, 200, 100);

        labe1_3.setText("Third number :");
        labe1_3.setFont(font);
        labe1_3.setBounds(10, 115, 200, 100);

        labe1_4.setText("Result :");
        labe1_4.setFont(font);
        labe1_4.setBounds(10, 285, 200, 100);

        //textfields to enter numbers
        textField_1 = new JTextField();
        textField_1.setBounds(120, 50, 125, 30);
        textField_1.setBackground(Color.GRAY.brighter());
        textField_1.setFont(font);
        textField_1.setBorder(blackline);

        textField_2 = new JTextField();
        textField_2.setBounds(120, 100, 125, 30);
        textField_2.setBackground(Color.GRAY.brighter());
        textField_2.setFont(font);
        textField_2.setBorder(blackline);

        textField_3 = new JTextField();
        textField_3.setBounds(120, 150, 125, 30);
        textField_3.setBackground(Color.GRAY.brighter());
        textField_3.setFont(font);
        textField_3.setBorder(blackline);

        textField_4 = new JTextField();
        textField_4.setBounds(60, 320, 185, 30);
        textField_4.setBackground(Color.GRAY.brighter());
        textField_4.setFont(font);
        textField_4.setBorder(blackline);
        //textField_4.setEditable(false);

        //Result button
        button1 = new JButton("Result");
        button1.setBounds(20,260,225, 40);
        button1.setBackground(Color.ORANGE);
        button1.addActionListener(this);
        button1.setBorder(blackline);
        button1.setFont(font);

        //+ button
        button2 = new JButton("+");
        button2.setBounds(20,200,45, 45);
        button2.setForeground(Color.white);
        button2.setBackground(Color.DARK_GRAY);
        button2.addActionListener(this);
        button2.setBorder(blackline);
        button2.setFont(font);

        //- button
        button3 = new JButton("-");
        button3.setBounds(80,200,45, 45);
        button3.setForeground(Color.white);
        button3.setBackground(Color.DARK_GRAY);
        button3.addActionListener(this);
        button3.setBorder(blackline);
        button3.setFont(font);

        /// button
        button4 = new JButton("/");
        button4.setBounds(140,200,45, 45);
        button4.setForeground(Color.white);
        button4.setBackground(Color.DARK_GRAY);
        button4.addActionListener(this);
        button4.setBorder(blackline);
        button4.setFont(font);

        //* button
        button5 = new JButton("*");
        button5.setBounds(200,200,45, 45);
        button5.setForeground(Color.white);
        button5.setBackground(Color.DARK_GRAY);
        button5.addActionListener(this);
        button5.setBorder(blackline);
        button5.setFont(font);

        //cls button
        button6 = new JButton("C");
        button6.setBounds(260,200,45, 100);
        button6.setBackground(Color.ORANGE);
        button6.addActionListener(this);
        button6.setBorder(blackline);
        button6.setFont(font);


        JPanel p = new JPanel();

        //add to frame
        f.add(labe1_1);
        f.add(textField_1);
        f.add(labe1_2);
        f.add(textField_2);
        f.add(labe1_3);
        f.add(textField_3);
        f.add(button2);
        f.add(button4);
        f.add(button3);
        f.add(button5);
        f.add(button6);
        f.add(button1);
        f.add(labe1_4);
        f.add(textField_4);


        //f.add(p);
        f.setSize(330,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.show();
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==button2){
            number1 = Integer.parseInt(textField_1.getText());
            number2 = Integer.parseInt(textField_2.getText());
            number3 = Integer.parseInt(textField_3.getText());
            operator = 1;
            textField_4.setText(number1 + " + " + number2 + " + " + number3  + " = ");
        }

        if(e.getSource() == button3){
            number1 = Integer.parseInt(textField_1.getText());
            number2 = Integer.parseInt(textField_2.getText());
            number3 = Integer.parseInt(textField_3.getText());
            operator = 2;
            textField_4.setText(number1 + " - " + number2 + " - " + number3 + " = ");
        }

        if(e.getSource() == button4){
            number1 = Integer.parseInt(textField_1.getText());
            number2 = Integer.parseInt(textField_2.getText());
            number3 = Integer.parseInt(textField_3.getText());
            textField_4.setText(number1 + " / " + number2 + " / " + number3 + " = ");
            operator = 3;
        }

        if(e.getSource() == button5){
            number1 = Integer.parseInt(textField_1.getText());
            number2 = Integer.parseInt(textField_2.getText());
            number3 = Integer.parseInt(textField_3.getText());
            textField_4.setText(number1 + " * " + number2 + " * " + number3 + " = ");
            operator = 4;
        }

        if(e.getSource() == button6){
            number1 = 0;
            number2 = 0;
            number3 = 0;
            result = 0;
            textField_4.setText("");
            operator = 5;
        }

        if(e.getSource() == button1)
        {
            switch(operator)
            {
                case 1:
                    result = number1 + number2 + number3;
                    textField_4.setText(number1 + " + " + number2 + " + " + number3  + " = " + result);
                    break;

                case 2:
                    result = number1 - number2 - number3;
                    textField_4.setText(number1 + " - " + number2 + " - " + number3 + " = " + result);
                    break;

                case 3:
                    result = number1 / number2 / number3;
                    textField_4.setText(number1 + " / " + number2 + " / " + number3 + " = " + result);
                    break;

                case 4:
                    result = number1 * number2 * number3;
                    textField_4.setText(number1 + " * " + number2 + " * " + number3 + " = " + result);
                    break;

                case 5:
                    textField_4.setText("");
                    break;


                default: result = 0;
            }
        }

    }

}

