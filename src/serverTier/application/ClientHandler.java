package serverTier.application;

import commonTier.PictoProtocols;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

    private Socket client;
    //Add attr for server reference
    private PrintWriter printWriter;
    private Scanner scanner;
    private boolean isConnected;

    public ClientHandler(Socket client){
        this.client = client;
        try {
            this.printWriter = new PrintWriter(client.getOutputStream());
            this.scanner = new Scanner(client.getInputStream());
            this.isConnected = true;
            printWriter.println(PictoProtocols.WELCOME + "Connected to the hub server!");
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
                    break;
                case PictoProtocols.CREATE:
                    //TODO
                    break;
                case PictoProtocols.ROOMS:
                    //TODO
                    break;
                case PictoProtocols.DISCONNECT:
                    try {
                        this.scanner.close();
                        this.printWriter.close();
                        this.client.close();
                    }catch (IOException io){
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
