package serverTier.model;

import serverTier.application.ClientHandler;

import java.util.ArrayList;

public class Room {

    private ArrayList<ClientHandler> clients;
    private String roomName;

    public Room(String roomName){
        this.roomName = roomName;
        this.clients = new ArrayList<>();
    }

    public void join(ClientHandler client){
        this.clients.add(client);
    }

    public void disconnect(ClientHandler client){
        this.clients.remove(client);
    }



}
