package serverTier.model;

import serverTier.application.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class PictoServer implements Runnable{
    private ServerSocket serSocket;
    private ArrayList<ClientHandler> users;
    private String roomName;

    public PictoServer(int port, String roomName) { // Server Socket should take in an int for port
        try {
            this.users = new ArrayList<>();
            this.serSocket = new ServerSocket(port);
            this.roomName = roomName;
        } catch (UnknownHostException unkHost) {
            System.out.println("UnknownHostException in PictoServer - constructor");
            unkHost.getMessage();
        } catch (IOException io) {
            System.out.println("IOException in PictoServer - constructor");
            io.getMessage();
        }
    }

    public void sendMSGOUT(String msg){
        for (ClientHandler handler: users){
            handler.sendMSG(msg);
        }
    }

    /**
     * Closes the server socket
     */
    public void closeServerSocket() {
        try {
            this.serSocket.close();
        } catch (IOException io) {
            System.out.println("IOException in PictoServer - closeServerSocket");
            io.getMessage();
        }
    }

    /**
     * Constantly accepts new clients
     */
    @Override
    public void run(){
        while(true) {
            try {
                users.add(new ClientHandler(this, serSocket.accept(), roomName, users));
            }catch (IOException io){
                System.out.println("IOException in PictoServer - run");
                io.getMessage();
            }
        }
    }

    public static void main(String[] args) {
        if(args.length != 2){ //ONLY SUPPORTS ONE WORD NAME FOR NOW
            System.out.println("Need port number as argument & room name");
        }
        PictoServer server = new PictoServer(Integer.parseInt(args[0]), args[1]);
    }

}
