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

            /*while(socket.isConnected() && !Action.exit) {
                Data ts.server.data = new Data(Operation.MUL,new float[]{0,0,0}, Status.SESSION_KEY ,(byte)0);
                output = new DataOutputStream(socket.getOutputStream());
                input = new DataInputStream(socket.getInputStream());

                output.write(Package.pack(ts.server.data));

                byte[] a = new byte[14];
                input.read(a);
                ts.server.data = Package.unpack(a);
                float[] n = ts.server.data.getNumbers();
                System.out.println(ts.server.data.getSession()+" "+ts.server.data.getStatus());

                if(ts.server.data.getStatus() == Status.CORRECT) {

                    ts.server.data.setNumbers(new float[]{1.996f,-1.1f,3});
                    ts.server.data.setStatus(Status.RESPONSE);
                    ts.server.data.setOperation(Operation.ADD);
                    output.write(Package.pack(ts.server.data));
                    input.read(a);
                    ts.server.data = (Package.unpack(a));
                } else if(ts.server.data.getStatus() == Status.INVALID_SESSION) {
                    session = ts.server.data.getSession();
                }

             //   n = ts.server.data.getNumbers();
             //   System.out.println(ts.server.data.getSession()+"  "+ n[0]+" "+n[1]+" "+n[2]);
            } */
        } catch (IOException e) {
            System.out.println("ts.client.Client Error: " + e.getMessage());

        }
    }
}
