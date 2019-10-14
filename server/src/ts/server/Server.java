package ts.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    public static HashMap<Byte,Socket> sessionList;

    public static void main(String[] args) {
        sessionList = new HashMap<>();
	    try(ServerSocket serverSocket = new ServerSocket(5000)){
	        while(true) {
                new User(serverSocket.accept()).start();
            }
        }catch(IOException e){
            System.out.println("ts.server.Server exception " + e.getMessage());
        }
    }
}
