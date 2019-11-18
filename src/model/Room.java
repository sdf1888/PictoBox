package model;

import java.net.ServerSocket;
import java.io.*;
import java.util.ArrayList;

public class Room {

    private String name;
    private int id;
    private ServerSocket server;
    private ArrayList<?> users; //TODO store users in chat

    public Room(String name, int id, int port) {
        this.name = name;
        this.id = id;
        try{
            this.server = new ServerSocket(port);
        }catch(IOException io){
            System.out.println(io.getLocalizedMessage());
        }
    }
}
