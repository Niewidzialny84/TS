package ts.client.GUI;

import ts.client.Client;
import ts.client.data.Data;
import ts.client.data.Operation;
import ts.client.data.Package;
import ts.client.data.Status;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
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
                    Client.output.write(Package.pack(new Data(Operation.ADD,new float[]{0,0,0},Status.CLOSING,Client.session)));
                    Client.socket.setKeepAlive(false);
                    Client.output.close();
                    Client.input.close();
                    Client.socket.close();
                } catch(IOException w) {
                    System.out.println(Client.socket.getInetAddress()+" | E | Session: "+Client.session+" -- Client exception: "+w.getMessage());
                }
                exit = true;
                System.out.println(Client.socket.getInetAddress()+" | E | Session: "+Client.session+" -- Client exception: Exit");
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==menu.button2){
            if(parse()) {
                menu.sign1.setText("+");
                menu.sign2.setText("+");
                run(Operation.ADD);
            }
        }

        if(e.getSource() == menu.button3){
            if(parse()) {
                menu.sign1.setText("-");
                menu.sign2.setText("-");
                run(Operation.SUB);
            }
        }

        if(e.getSource() == menu.button4){
            if(parse()) {
                parse();
                menu.sign1.setText("/");
                menu.sign2.setText("/");
                run(Operation.DIV);
            }
        }

        if(e.getSource() == menu.button5){
            if(parse()) {
                menu.sign1.setText("*");
                menu.sign2.setText("*");
                run(Operation.MUL);
            }
        }

        if(e.getSource() == menu.button6){
            cls();
        }
    }

    private void run(Operation operation) {
        try {
            Data d = new Data(operation, new float[]{menu.number1, menu.number2, menu.number3}, Status.CORRECT, Client.session);

            System.out.println(Client.socket.getInetAddress()+" | S | Session: "+d.getSession()+" -- "+d.getStatus()+" "+d.getOperation()+" "+d.getNumbers()[0]+" "+d.getNumbers()[1]+" "+d.getNumbers()[2]);
            Client.output.write(Package.pack(d));
            byte[] bytes = new byte[14];
            Client.input.read(bytes);
            d = Package.unpack(bytes);

            System.out.println(Client.socket.getInetAddress()+" | R | Session: "+d.getSession()+" -- "+d.getStatus()+" "+d.getNumbers()[0] );
            menu.result = d.getNumbers()[0];

            switch (d.getStatus()) {
                case ERROR:
                    cls();
                    menu.textField_4.setText("Server Error");
                    break;
                case NUMBER_DIV:
                    cls();
                    menu.textField_4.setText("Div by 0");
                    break;
                case NUMBER_INFINITE:
                    cls();
                    menu.textField_4.setText("Overflow");
                    break;
                case NUMBER_NAN:
                    cls();
                    menu.textField_4.setText("Not a number");
                    break;
                case CORRECT:
                default:
                    menu.textField_4.setText(""+menu.result);
                    break;
            }
        } catch (IOException w) {
            System.out.println(Client.socket.getInetAddress()+" | E | Session: "+Client.session+" -- Client run exception: "+w.getMessage());
            System.exit(0);
        }
    }

    private boolean parse() {
        try {
            menu.number1 = Float.parseFloat(menu.textField_1.getText());
            menu.number2 = Float.parseFloat(menu.textField_2.getText());
            menu.number3 = Float.parseFloat(menu.textField_3.getText());
            menu.input1.setText(""+menu.number1);
            menu.input2.setText(""+menu.number2);
            menu.input3.setText(""+menu.number3);
            return true;
        } catch (Exception e) {
            System.out.println(Client.socket.getInetAddress()+" | E | Session: "+Client.session+" -- Client parse exception (Invalid numbers)");
            cls();
            menu.textField_4.setText("Wrong input");
            return false;
        }
    }

    private void cls() {
        menu.number1 = 0;
        menu.number2 = 0;
        menu.number3 = 0;
        menu.result = 0;
        menu.textField_1.setText("");
        menu.textField_2.setText("");
        menu.textField_3.setText("");
        menu.sign1.setText("");
        menu.sign2.setText("");
        menu.input1.setText("");
        menu.input2.setText("");
        menu.input3.setText("");
        menu.textField_4.setText("");
    }
}
