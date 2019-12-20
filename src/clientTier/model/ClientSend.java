package clientTier.model;

import commonTier.PictoProtocols;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSend implements Runnable{

    private String name;
    private Socket socket;
    private PrintWriter printWriter;
    private Scanner scanner;

    public ClientSend(Socket socket, String name){
        try{
            this.name = name;
            this.socket = socket;
            this.printWriter = new PrintWriter(socket.getOutputStream());
            this.scanner = new Scanner(System.in);
        }catch (IOException io){
            System.out.println(io.getLocalizedMessage());
        }
    }

    @Override
    public void run(){
        String msg;
        while (socket.isConnected()) {
            msg = scanner.nextLine();
            if(msg.startsWith(PictoProtocols.HELP)){
                System.out.println(PictoProtocols.CREATE + ", " + PictoProtocols.JOIN + ", " + PictoProtocols.ROOMS + ", " + PictoProtocols.DISCONNECT);
            }else {
                printWriter.println(msg);
                printWriter.flush();
            }
        }
    }
}
