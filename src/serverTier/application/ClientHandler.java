package serverTier.application;

import commonTier.PictoProtocols;
import serverTier.model.Room;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread{

    private Socket client;
    //Add attr for server reference
    private PrintWriter printWriter;
    private Scanner scanner;
    private boolean isConnected;
    private Room room;

    public ClientHandler(Socket client, Rooms rooms){
        this.client = client;
        try {
            this.printWriter = new PrintWriter(client.getOutputStream());
            this.scanner = new Scanner(client.getInputStream());
            this.isConnected = true;
            this.room = null;
            printWriter.println(" Connected to the hub server!");
            printWriter.flush();
        }catch (IOException io){
            System.out.println(io.getLocalizedMessage());
        }
    }

    @Override
    public void run(){
        String msg;
        while(isConnected){
            msg = scanner.nextLine();
            switch(msg.split(" ")[0]){
                case PictoProtocols.JOIN:
                    //TODO
                    //When user joins a room, if they're in a room already they must disconnect from their current room
                    //Check for if room exists, if not inform client
                    //When user joins room, stop thread to save cycles
                    break;
                case PictoProtocols.CREATE:
                    //TODO
                    break;
                case PictoProtocols.ROOMS:
                    //TODO
                    break;
                case PictoProtocols.DISCONNECT:
                    if (room != null) {
                        //TODO dc user from current room
                    }else {
                        printWriter.println("You are currently not in a room. " +
                                "\nUse the quit command to disconnect from the server");
                        printWriter.flush();
                    }
                    break;

                case PictoProtocols.QUIT:
                    //TODO Check if user is connected to a room, if so dc from room
                    try {
                        this.scanner.close();
                        this.printWriter.close();
                        this.client.close();
                    } catch (IOException io) {
                        System.out.println(io.getLocalizedMessage());
                    }
                    this.isConnected = false;

                    break;

                default:
                    printWriter.println(PictoProtocols.ERR + " unknown command, use '/help' to see the available commands");
                    printWriter.flush();
                    break;
            }
        }
    }
}
