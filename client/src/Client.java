import GUI.Menu;
import data.Data;
import data.Package;
import data.operation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Menu menu = new Menu();

        try (Socket socket = new Socket("localhost", 5000)) {

            DataOutputStream stream = new DataOutputStream(socket.getOutputStream());

            stream.write(Package.pack(new Data(operation.DIV,new float[]{-7,2,3},(byte) 1,(byte)1)));

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            byte[] a = new byte[14];
            inputStream.read(a);
            Data d = Package.unpack(a);

            float[] n = d.getNumbers();
            System.out.println(d.getSession()+"  "+ n[0]);

        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());

        }
    }
}
