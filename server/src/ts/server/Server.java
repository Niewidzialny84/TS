package ts.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    public static HashMap<Byte,Socket> sessionList; //map of all connected clients at the moment

    public static void main(String[] args) {
        sessionList = new HashMap<>();

	    try{
	        //creating server socket on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            while(true) {
                //waiting for incoming connection and starting a new thread when user connects
                new User(serverSocket.accept()).start();
            }
        }catch(IOException e){
            System.out.println("ts.server.Server exception " + e.getMessage());
        }
    }
}