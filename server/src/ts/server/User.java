package ts.server;

import ts.server.data.Data;
import ts.server.data.Operation;
import ts.server.data.Package;
import ts.server.data.Status;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class User extends Thread{
    private Socket socket;
    private byte session;
    public User(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            Data data = new Data();
            byte[] buffer = new byte[14];

            for(byte i=1;i<63;i++) {
                if(!Server.sessionList.containsKey(i)) {
                    Server.sessionList.put(i,socket);
                    session = i;
                }
            }

            output.write(Package.pack(new Data(Operation.SUB,new float[]{0,0,0}, Status.SESSION_KEY,session)));

            while(true) {
                input.read(buffer);
                data = Package.unpack(buffer);

                System.out.println(socket.getInetAddress()+" "+session+" "+data.getStatus()+" "+data.getOperation()+" "+data.getNumbers()[0]+" "+data.getNumbers()[1]+" "+data.getNumbers()[2]);
                output.write(Package.pack(new Data(Operation.SUB,new float[]{Calculate.calculate(data.getOperation(),data.getNumbers()),0,0},data.getStatus(),session)));
            }

        } catch (IOException w) {
            System.out.println("ts.server.Server exception "+w.getMessage());
        }
    }
}
