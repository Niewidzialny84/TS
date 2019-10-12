import GUI.Action;
import GUI.Menu;
import data.Data;
import data.Package;
import data.Status;
import data.Operation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static Socket socket;

    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
            socket = new Socket("localhost", 5000);

            while(socket.isConnected() && !Action.exit) {
                DataOutputStream stream = new DataOutputStream(socket.getOutputStream());
                stream.write(Package.pack(new Data(Operation.DIV,new float[]{-7,2,3}, Status.CORRECT ,(byte)1)));


                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                byte[] a = new byte[14];
                inputStream.read(a);
                Data d = Package.unpack(a);

                float[] n = d.getNumbers();
                System.out.println(d.getSession()+"  "+ n[0]);
            }
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());

        }
    }
}
