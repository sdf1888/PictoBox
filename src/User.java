
import clientTier.model.ClientRecieve;
import clientTier.model.ClientSend;

import java.io.IOException;
import java.net.Socket;

public class User {

    private Socket socket;
    private String name;
    private ClientSend clientSend;
    private ClientRecieve clientRecieve;
    private Thread csThread;
    private Thread crThread;

    public User(int port, String hostname, String name){
        try {
            this.socket = new Socket(hostname, port);
            this.clientSend = new ClientSend(socket, name);
            this.clientRecieve = new ClientRecieve(socket);
            this.csThread = new Thread(clientSend);
            this.crThread = new Thread(clientRecieve);
            this.csThread.start();
            this.crThread.start();
        }catch (IOException io){
            System.out.println(io.getLocalizedMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length != 3){
            System.out.println("Expected 3 inputs: port, hostname, username");
            System.out.println("ex: java User 1234 192.168.1.1 exampleName");
            System.exit(0);
        }else {
            try {
                User user = new User(Integer.parseInt(args[0]), args[1], args[2]);
            }catch (Exception e){
                System.out.println("Expected integer port");
                System.out.println("ex: 1234");
                System.exit(0);
            }
        }

    }
}
