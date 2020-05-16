package serverTier.model;

import serverTier.application.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Room implements Runnable{

    private ArrayList<ClientHandler> clients;
    private String roomName;
    private int port;
    private ServerSocket roomSocket;

    public Room(String roomName){
        this.roomName = roomName;
        this.clients = new ArrayList<>();
        try {
            this.roomSocket = new ServerSocket(0);
            this.port = roomSocket.getLocalPort();
        }catch(IOException io){
            System.out.println(io.getLocalizedMessage());
        }
    }

    public void join(ClientHandler client){
        this.clients.add(client);
    }

    public void disconnect(ClientHandler client){
        this.clients.remove(client);
        //TODO check for remaining users, if none left close room and connections
    }

    public String getName() { return this.roomName; }

    public ArrayList getClients() { return this.clients; }

    public int getPort() { return this.port; }

    @Override
    public void run() {

        //Accept new clients while also forwarding messages to people

    }

}
