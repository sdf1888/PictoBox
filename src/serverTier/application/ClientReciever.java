package serverTier.application;

import java.io.IOException;
import java.net.ServerSocket;

public class ClientReciever implements Runnable{

    public ServerSocket server;

    /**
     * ClientReciever constructor
     * @param server reference back to the server
     */
    public ClientReciever(ServerSocket server) {
        this.server = server;
    }

    /**
     * Creates ClientHandlers for each client that connects
     */
    @Override
    public void run() {

        ClientHandler chTemp;
        Thread tempThread;
        System.out.println("Server Connection: Open");
        while(true){
            try {
                chTemp = new ClientHandler(server.accept());
                System.out.println("Client Connected!");
                 tempThread = new Thread(chTemp);
                 tempThread.start();
            }catch (IOException io){
                System.out.println(io.getLocalizedMessage());
            }
        }
    }
}
