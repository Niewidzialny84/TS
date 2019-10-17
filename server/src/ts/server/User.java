package ts.server;

import ts.server.data.Data;
import ts.server.data.Operation;
import ts.server.data.Package;
import ts.server.data.Status;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class User extends Thread{
    private Socket socket;
    private byte session = 1;
    public User(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InetAddress address = socket.getInetAddress();
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            byte[] buffer = new byte[14];

            for(Byte i=1;i<30;i++) {
                if(!Server.sessionList.containsKey(i)) {
                    Server.sessionList.put(i,socket);
                    session = i;
                    break;
                }
            }

            Data data = new Data(Operation.SUB,new int[]{0,0,0}, Status.SESSION_KEY,session);

            if(!socket.isClosed() && !socket.isInputShutdown() && !socket.isOutputShutdown()) {
                System.out.println(address+" | S | Session: "+data.getSession()+" -- "+data.getStatus());
                output.write(Package.pack(data));
            }

            while(true) {
                input.read(buffer);

                data = Package.unpack(buffer);
                System.out.println(address+" | R | Session: "+data.getSession()+" -- "+data.getStatus()+" "+data.getOperation()+" "+data.getNumbers()[0]+" "+data.getNumbers()[1]+" "+data.getNumbers()[2]);

                if(data.getStatus() == Status.CLOSING) {
                    input.close();
                    output.close();
                    socket.close();
                    throw new IOException("Normal close");
                }

                Status status = Status.CORRECT;
           //     float ret = 0;
                int ret = 0;
                try {
                    ret = Calculate.calculate(data.getOperation(),data.getNumbers());
                } catch (ArithmeticException err) {
                    if(err.getMessage().equalsIgnoreCase("DIV")) {
                        status = Status.NUMBER_DIV;
                    } else if(err.getMessage().equalsIgnoreCase("INF")) {
                        status = Status.NUMBER_INFINITE;
                    } else if(err.getMessage().equalsIgnoreCase("NAN")) {
                        status = Status.NUMBER_NAN;
                    } else {
                        status = Status.ERROR;
                    }
                }

                data = new Data(Operation.SUB,new int[]{ret,0,0},status,session);
                System.out.println(address+" | S | Session: "+data.getSession()+" -- "+data.getStatus()+" "+data.getNumbers()[0]);
                output.write(Package.pack(data));
            }
        } catch (IOException w) {
            System.out.println(address+" | E | Session: "+session+" -- Server exception: "+w.getMessage());
        } finally {
            Server.sessionList.remove(session);
        }
    }

}
