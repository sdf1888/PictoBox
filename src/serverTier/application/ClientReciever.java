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

        ClientHandler temp;

        while(true){
            try {
                 temp = new ClientHandler(server.accept());
                 temp.run();
            }catch (IOException io){
                System.out.println(io.getLocalizedMessage());
            }
        }
    }
}
