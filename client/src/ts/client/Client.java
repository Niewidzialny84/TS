package ts.client;

import ts.client.GUI.Menu;
import ts.client.data.Data;
import ts.client.data.Package;
import ts.client.data.Status;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static Socket socket;
    public static DataOutputStream output;
    public static DataInputStream input;
    public static byte session;

    public static void main(String[] args) {
        //reading the args and setting the host address to localhost or other when is set
        String host = "localhost";
        if(args.length == 1) {
            host = args[0];
        }

        try {
            //creating socket on host ip and port 5000
            socket = new Socket(host, 5000);

            //checking if socket connected at least one time
            if(socket.isConnected()) {
                //setting input and output variables from socket stream
                output = new DataOutputStream(socket.getOutputStream());
                input = new DataInputStream(socket.getInputStream());

                //preparing for getting session key
                byte[] a = new byte[14];
                input.read(a); //reading form server which session was assigned
                Data data = Package.unpack(a); //unpacking data
                if(data.getStatus() == Status.SESSION_KEY) { //checking if the status is correct
                    session = data.getSession(); //assigning recived session to local variable
                    System.out.println(Client.socket.getInetAddress()+" | R | Session: "+data.getSession()+" -- "+data.getStatus());
                    Menu menu = new Menu(); //opening GUI
                } else {
                    System.out.println(Client.socket.getInetAddress()+" | R | Session: "+data.getSession()+" -- "+data.getStatus());
                    System.out.println(Client.socket.getInetAddress()+" | E | Session: "+data.getSession()+" -- WRONG SESSION PACKAGE CLOSING");
                }
            }
        } catch (IOException e) {
            System.out.println("ts.client.Client Error: " + e.getMessage());

        }
    }
}
