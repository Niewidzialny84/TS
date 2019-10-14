package ts.client;

import ts.client.GUI.Action;
import ts.client.GUI.Menu;
import ts.client.data.Data;
import ts.client.data.Package;
import ts.client.data.Status;
import ts.client.data.Operation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class Client {
    public static Socket socket;
    public static DataOutputStream output;
    public static DataInputStream input;
    public static byte session;

    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", 5000);
            Random random = new Random();
            if(socket.isConnected()) {
                output = new DataOutputStream(socket.getOutputStream());
                input = new DataInputStream(socket.getInputStream());
             //   output.write(Package.pack(new Data(Operation.MUL,new float[]{0,0,0}, Status.SESSION_KEY ,(byte)0)));

                byte[] a = new byte[14];
                input.read(a);
                session = Package.unpack(a).getSession();

                Menu menu = new Menu();
            }
        } catch (IOException e) {
            System.out.println("ts.client.Client Error: " + e.getMessage());

        }
    }
}
