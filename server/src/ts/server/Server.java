package ts.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    public static HashMap<Byte,Socket> sessionList;

    public static void main(String[] args) {
        sessionList = new HashMap<>();

	    try{
            ServerSocket serverSocket = new ServerSocket(5000);
	        while(true) {
                new User(serverSocket.accept()).start();
            }
        }catch(IOException e){
            System.out.println("ts.server.Server exception " + e.getMessage());
        }
    }
}

/*
Scanner scanner = new Scanner(System.in);
if(scanner.hasNext("EXIT")) {
                    String s = scanner.next();
                    if(s.equalsIgnoreCase("EXIT")) {
                        System.out.println("| C | Exit Command");
                        break;
                    } else if(s.equalsIgnoreCase("CLIENTS")) {
                        System.out.println("| C | Connected clients");
                        for(Map.Entry<Byte,Socket> entry: sessionList.entrySet()) {
                            System.out.println("| C | Addres: "+entry.getValue().getInetAddress()+ " Session: "+entry.getKey());
                        }
                    }
 */