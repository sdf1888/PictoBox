package serverTier.application;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientHandler implements Runnable{
    private PictoServer server;
    private Socket client;
    private PrintWriter clientPW;
    private Scanner clientScanner;
    private String username;
    private ArrayList<ClientHandler> otherUsers; //Saved to display in GUI

    /**
     * ClientHandler constructor, accepts a client and sends a welcome message.
     * @param server reference back to the server
     */
    public ClientHandler(PictoServer server, Socket client, String room, ArrayList<ClientHandler> users) {
        try {
            this.server = server;
            this.otherUsers = users;
            this.client = client;
            this.clientPW = new PrintWriter(client.getOutputStream());
            this.clientScanner = new Scanner(client.getInputStream());

            String welcomeMSG = PictoProtocols.WELCOME + " Connected:" + room + ", [";
            for (ClientHandler ch: users){
                welcomeMSG = welcomeMSG.concat("   " + ch.getUsername());
            }
            this.clientPW.println(welcomeMSG);
            this.clientPW.flush();

            String[] line = clientScanner.nextLine().split(" ");
            this.username = line[1];


        }catch (IOException io){
            System.out.println("IOException in ClientHandler - constructor");
            io.getMessage();
        }
    }

    public String getUsername(){
        return username;
    }

    public void sendMSG(String msg){
        clientPW.println(msg);
        clientPW.flush();

        //Will replace w/ a call to refresh gui w/ updated labels
    }

    @Override
    public void run() {
        while (clientScanner.nextLine() != null) {
            String[] line = clientScanner.nextLine().split(" ");
            switch (line[0]) {
                case PictoProtocols.JOINED:

                    break;

                case PictoProtocols.DISCONNECT:

                    break;

                case PictoProtocols.MSG:
                    //server.sendMSGOUT(String.join(" ", ));
                    break;

                case PictoProtocols.ERR:

                    break;
            }
        }
    }
}
