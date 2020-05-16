import serverTier.application.ClientReciever;
import serverTier.application.Rooms;

import java.io.*;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class ServerRun{

    private ServerSocket serverSocket;
    private ClientReciever clientReciever;
    private Thread crThread;

    public ServerRun(int port){
        try {
            this.serverSocket = new ServerSocket(port);
            this.clientReciever = new ClientReciever(serverSocket);
            this.crThread = new Thread(clientReciever);
            this.crThread.start();
        } catch (UnknownHostException unkHost) {
            System.out.println(unkHost.getLocalizedMessage());
        } catch (IOException io) {
            System.out.println(io.getLocalizedMessage());
        }
    }

    public static void main(String[] args) {
        try{
            int port = Integer.parseInt(args[0]);
            ServerRun server = new ServerRun(port);
        }catch(Exception e){
            System.out.println("Expected one input containing port");
            System.out.println("ex: java ServerRun 1234");
            System.exit(0);
        }

    }
}
