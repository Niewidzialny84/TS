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
import java.util.Random;

public class Client {
    public static Socket socket;
    private static byte session;

    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
            socket = new Socket("localhost", 5000);
            Random random = new Random();
            session = (byte)(random.nextInt(1) + 31);

            while(socket.isConnected() && !Action.exit) {
                Data data = new Data(Operation.MUL,new float[]{0,0,0}, Status.SESSION_KEY ,(byte)0);

                DataOutputStream stream = new DataOutputStream(socket.getOutputStream());
                stream.write(Package.pack(data));

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                byte[] a = new byte[14];
                inputStream.read(a);
                data = Package.unpack(a);
                float[] n = data.getNumbers();
                System.out.println(data.getSession()+"  "+ n[0]+" "+n[1]+" "+n[2]);

                if(data.getStatus() == Status.CORRECT) {
                    data.setNumbers(new float[]{1,2.75f,3});
                    data.setStatus(Status.RESPONSE);
                    stream.write(Package.pack(data));
                    inputStream.read(a);
                    data = (Package.unpack(a));
                } else if(data.getStatus() == Status.INVALID_SESSION) {
                    session = data.getSession();
                }

                n = data.getNumbers();
                System.out.println(data.getSession()+"  "+ n[0]+" "+n[1]+" "+n[2]);
            }
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());

        }
    }
}
