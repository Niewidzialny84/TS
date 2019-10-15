package ts.client;

import ts.client.GUI.Menu;
import ts.client.data.Data;
import ts.client.data.Package;
import ts.client.data.Status;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static Socket socket;
    public static DataOutputStream output;
    public static DataInputStream input;
    public static byte session;

    public static void main(String[] args) {
        String host = "localhost";
        if(args.length == 1) {
            host = args[0];
        }


        try {
            socket = new Socket(host, 5000);

            if(socket.isConnected()) {
                output = new DataOutputStream(socket.getOutputStream());
                input = new DataInputStream(socket.getInputStream());
             //   output.write(Package.pack(new Data(Operation.MUL,new float[]{0,0,0}, Status.SESSION_KEY ,(byte)0)));

                byte[] a = new byte[14];
                input.read(a);
                Data data = Package.unpack(a);
                if(data.getStatus() == Status.SESSION_KEY) {
                    session = data.getSession();
                    System.out.println(Client.socket.getInetAddress()+" | R | Session: "+data.getSession()+" -- "+data.getStatus());
                    Menu menu = new Menu();
                } else {
                    System.out.println(Client.socket.getInetAddress()+" | R | Session: "+data.getSession()+" -- "+data.getStatus());
                    System.out.println(Client.socket.getInetAddress()+" | E | Session: "+data.getSession()+" -- WRONG SESSION PACKAGE CLOSING");
                }


            }
        } catch (IOException e) {
            System.out.println("ts.client.Client Error: " + e.getMessage());

        }
    }
}
