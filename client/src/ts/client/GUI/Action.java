package ts.client.GUI;

import ts.client.Client;
import ts.client.data.Data;
import ts.client.data.Operation;
import ts.client.data.Package;
import ts.client.data.Status;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;

public class Action implements ActionListener {
    private Menu menu;
    public static boolean exit = false;
    Action(Menu menu) {
        this.menu = menu;
        menu.f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Client.socket.close();
                } catch(IOException w) {
                    System.out.println("Exit err "+w.getMessage());
                }
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
            //menu.operator = 1;
            menu.textField_4.setText(menu.number1 + " + " + menu.number2 + " + " + menu.number3  + " = ");
            run(Operation.ADD);
        }

        if(e.getSource() == menu.button3){
            menu.number1 = Integer.parseInt(menu.textField_1.getText());
            menu.number2 = Integer.parseInt(menu.textField_2.getText());
            menu.number3 = Integer.parseInt(menu.textField_3.getText());
           // menu.operator = 2;
            menu.textField_4.setText(menu.number1 + " - " + menu.number2 + " - " + menu.number3 + " = ");
            run(Operation.SUB);
        }

        if(e.getSource() == menu.button4){
            menu.number1 = Integer.parseInt(menu.textField_1.getText());
            menu.number2 = Integer.parseInt(menu.textField_2.getText());
            menu.number3 = Integer.parseInt(menu.textField_3.getText());
            menu.textField_4.setText(menu.number1 + " / " + menu.number2 + " / " + menu.number3 + " = ");
            //menu.operator = 3;
            run(Operation.DIV);
        }

        if(e.getSource() == menu.button5){
            menu.number1 = Integer.parseInt(menu.textField_1.getText());
            menu.number2 = Integer.parseInt(menu.textField_2.getText());
            menu.number3 = Integer.parseInt(menu.textField_3.getText());
            menu.textField_4.setText(menu.number1 + " * " + menu.number2 + " * " + menu.number3 + " = ");
            //menu.operator = 4;
            run(Operation.MUL);
        }

        if(e.getSource() == menu.button6){
            menu.number1 = 0;
            menu.number2 = 0;
            menu.number3 = 0;
            menu.result = 0;
            menu.textField_4.setText("");
            menu.operator = 5;
        }

        /*
        if(e.getSource() == menu.button1)
        {
            try {
                switch (menu.operator) {
                    case 1:
                        Client.output.write(Package.pack(new Data(Operation.ADD, new float[]{menu.number1, menu.number2, menu.number3}, Status.CORRECT, (byte) 0)));
                        byte[] bytes = new byte[14];
                        Client.input.read(bytes);
                        Data d = Package.unpack(bytes);
                        menu.result = d.getNumbers()[0];
                        menu.textField_4.setText(menu.number1 + " + " + menu.number2 + " + " + menu.number3 + " = " + menu.result);
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
                    default:
                        menu.result = 0;
                }
            }catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }

         */
    }

    private void run(Operation operation) {
        try {
            Client.output.write(Package.pack(new Data(operation, new float[]{menu.number1, menu.number2, menu.number3}, Status.CORRECT, Client.session)));
            byte[] bytes = new byte[14];
            Client.input.read(bytes);
            Data d = Package.unpack(bytes);
            menu.result = d.getNumbers()[0];
            menu.textField_4.setText(menu.number1 + " + " + menu.number2 + " + " + menu.number3 + " = " + menu.result);
        } catch (IOException w) {
            System.out.println("Run error "+w.getMessage());
        }
    }
}
