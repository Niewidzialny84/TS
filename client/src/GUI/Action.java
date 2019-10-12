package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Action implements ActionListener {
    private Menu menu;
    public static boolean exit = false;
    Action(Menu menu) {
        this.menu = menu;
        menu.f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit = true;
                System.out.println("Game ende");
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==menu.button2){
            menu.number1 = Integer.parseInt(menu.textField_1.getText());
            menu.number2 = Integer.parseInt(menu.textField_2.getText());
            menu.number3 = Integer.parseInt(menu.textField_3.getText());
            menu.operator = 1;
            menu.textField_4.setText(menu.number1 + " + " + menu.number2 + " + " + menu.number3  + " = ");
        }

        if(e.getSource() == menu.button3){
            menu.number1 = Integer.parseInt(menu.textField_1.getText());
            menu.number2 = Integer.parseInt(menu.textField_2.getText());
            menu.number3 = Integer.parseInt(menu.textField_3.getText());
            menu.operator = 2;
            menu.textField_4.setText(menu.number1 + " - " + menu.number2 + " - " + menu.number3 + " = ");
        }

        if(e.getSource() == menu.button4){
            menu.number1 = Integer.parseInt(menu.textField_1.getText());
            menu.number2 = Integer.parseInt(menu.textField_2.getText());
            menu.number3 = Integer.parseInt(menu.textField_3.getText());
            menu.textField_4.setText(menu.number1 + " / " + menu.number2 + " / " + menu.number3 + " = ");
            menu.operator = 3;
        }

        if(e.getSource() == menu.button5){
            menu.number1 = Integer.parseInt(menu.textField_1.getText());
            menu.number2 = Integer.parseInt(menu.textField_2.getText());
            menu.number3 = Integer.parseInt(menu.textField_3.getText());
            menu.textField_4.setText(menu.number1 + " * " + menu.number2 + " * " + menu.number3 + " = ");
            menu.operator = 4;
        }

        if(e.getSource() == menu.button6){
            menu.number1 = 0;
            menu.number2 = 0;
            menu.number3 = 0;
            menu.result = 0;
            menu.textField_4.setText("");
            menu.operator = 5;
        }

        if(e.getSource() == menu.button1)
        {
            switch(menu.operator)
            {
                case 1:
                    menu.result = menu.number1 + menu.number2 + menu.number3;
                    menu.textField_4.setText(menu.number1 + " + " + menu.number2 + " + " + menu.number3  + " = " + menu.result);
                    break;

                case 2:
                    menu.result = menu.number1 - menu.number2 - menu.number3;
                    menu.textField_4.setText(menu.number1 + " - " + menu.number2 + " - " + menu.number3 + " = " + menu.result);
                    break;

                case 3:
                    menu.result = menu.number1 / menu.number2 / menu.number3;
                    menu.textField_4.setText(menu.number1 + " / " + menu.number2 + " / " + menu.number3 + " = " + menu.result);
                    break;

                case 4:
                    menu.result = menu.number1 * menu.number2 * menu.number3;
                    menu.textField_4.setText(menu.number1 + " * " + menu.number2 + " * " + menu.number3 + " = " + menu.result);
                    break;

                case 5:
                    menu.textField_4.setText("");
                    break;
                default: menu.result = 0;
            }
        }
    }
}
