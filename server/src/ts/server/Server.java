package ts.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    public static HashMap<Byte,Socket> sessionList;

    public static void main(String[] args) {
        sessionList = new HashMap<>();
        int clientNum = 1;
	    try(ServerSocket serverSocket = new ServerSocket(5000)){
	        while(true) {
                new User(serverSocket.accept()).start();

	            /*
	            Socket s = serverSocket.accept();

                System.out.println(s.getInetAddress()+ "    "+s.getInputStream());

                DataInputStream d = new DataInputStream(s.getInputStream());
                byte[] head = new byte[14];
                d.read(head);
                Data ts.server.data = Package.unpack(head);
                float[] a = ts.server.data.getNumbers();
                System.out.println(head[0]+" "+ts.server.data.getOperation()+" "+a[0] + " " + a[1] + " " + a[2] + " " + ts.server.data.getStatus() + " " + ts.server.data.getSession());

                a = new float[]{a[0]+a[1]+a[2],0,0};
                DataOutputStream o = new DataOutputStream(s.getOutputStream());
                o.write(Package.pack(new Data(ts.server.data.getOperation(),a, Status.CORRECT,ts.server.data.getSession())));

                d.read(head);
                ts.server.data = Package.unpack(head);
                a = ts.server.data.getNumbers();
                System.out.println(head[0]+" "+ts.server.data.getOperation()+" "+a[0] + " " + a[1] + " " + a[2] + " " + ts.server.data.getStatus() + " " + ts.server.data.getSession());

                o.write(Package.pack(new Data(ts.server.data.getOperation(),a, Status.CORRECT,ts.server.data.getSession())));

                clientNum++;
	             */
            }
        }catch(IOException e){
            System.out.println("ts.server.Server exception " + e.getMessage());
        }
    }
}
