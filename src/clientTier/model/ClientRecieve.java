package clientTier.model;

import commonTier.PictoProtocols;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientRecieve implements Runnable{

    private Socket socket;
    private Scanner scanner;

    public ClientRecieve(Socket socket){
        try {
            this.socket = socket;
            this.scanner = new Scanner(socket.getInputStream());
        }catch (IOException io){
            System.out.println(io.getLocalizedMessage());
        }

    }

    @Override
    public void run(){
        String msg;
        while(socket.isConnected()){
            msg = scanner.nextLine();
            switch (msg.split(" ")[0]){
                case PictoProtocols.ERR:
                    System.out.println("ERROR: " + msg.replace(PictoProtocols.ERR, ""));
                    break;
                default:
                    System.out.println(msg);
                    break;
            }
        }
    }
}
