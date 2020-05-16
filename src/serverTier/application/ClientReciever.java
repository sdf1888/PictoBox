package serverTier.application;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Responsible for acceping users into the system
 */
public class ClientReciever implements Runnable{

    public ServerSocket server;
    private Rooms rooms;

    /**
     * ClientReciever constructor
     * @param server reference back to the server
     */
    public ClientReciever(ServerSocket server) {
        this.server = server;
        this.rooms = new Rooms();
    }

    /**
     * Creates ClientHandlers for each client that connects
     */
    @Override
    public void run() {

        ClientHandler chTemp;
        Thread tempThread;
        System.out.println("Server Connection: Open");
        while(true){ //Change to stop when shutting down
            try {
                chTemp = new ClientHandler(server.accept(), rooms);
                System.out.println("Client Connected!");
                 tempThread = new Thread(chTemp);
                 tempThread.start();
            }catch (IOException io){
                System.out.println(io.getLocalizedMessage());
            }
        }
    }
}
