import data.Data;
import data.Package;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int clientNum = 1;
	    try(ServerSocket serverSocket = new ServerSocket(5000)){
	        while(true) {
	            Socket s = serverSocket.accept();
                System.out.println(s.getInetAddress()+ "    "+s.getInputStream());

                DataInputStream d = new DataInputStream(s.getInputStream());
                byte[] head = new byte[14];
                d.read(head);
                Data data = Package.unpack(head);
                float[] a = data.getNumbers();
                System.out.println(data.getOperation()+" "+a[0] + " " + a[1] + " " + a[2] + " " + data.getStatus() + " " + data.getSession());

                a = new float[]{a[0]+a[1]+a[2],0,0};
                DataOutputStream o = new DataOutputStream(s.getOutputStream());
                o.write(Package.pack(new Data(data.getOperation(),a,data.getStatus(),data.getSession())));
                //Echoer echoer = new Echoer(serverSocket.accept(), clientNum);
                
                //echoer.start();
                //System.out.println(echoer.getStackTrace());
                clientNum++;
            }
        }catch(IOException e){
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
