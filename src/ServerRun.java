import serverTier.application.ClientHandler;
import serverTier.application.Rooms;

import java.io.*;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServerRun{

    public class ServerAcceptThread extends Thread{
        private Scanner inputReader;
        private ServerRun server;
        private boolean running;

        public ServerAcceptThread(ServerRun server){
            this.inputReader = new Scanner(System.in);
            this.running = true;
            this.server = server;
        }

        public void notifyShutdown(){ //TODO expand to handle events differently
            this.interrupt();
        }

        @Override
        public void run(){
            while (running){
                try {
                    new ClientHandler(serverSocket.accept(), rooms).start();
                    System.out.println("Client connected!");
                }catch (IOException io){
                    System.out.println(io.getLocalizedMessage());
                }
            }
        }

    }

    private ServerSocket serverSocket;
    private ServerAcceptThread clientAccept;

    private Rooms rooms;
    private boolean running;


    public ServerRun(int port){
        try {
            this.running = true;
            this.serverSocket = new ServerSocket(port);
            this.rooms = new Rooms();
            clientAccept = new ServerAcceptThread(this);
            clientAccept.start();
        } catch (UnknownHostException unkHost) {
            System.out.println(unkHost.getLocalizedMessage());
        } catch (IOException io) {
            System.out.println(io.getLocalizedMessage());
        }
    }

    public void checkInput(){
        System.out.println("Server Running!");
        Scanner inputReader = new Scanner(System.in);
        running = true;
        String line;

        while (running){ //TODO add more server commands later
            line = inputReader.nextLine();
            if (line.contains("stop")){
                running = false;
                //ServerAcceptThread.notifyShutdown(); // May not be necessary to kill thread if app is closing anyways TBD
            }
        }
        inputReader.close();
    }

    public static void main(String[] args) {
        try{
            int port = Integer.parseInt(args[0]);
            ServerRun server = new ServerRun(port);
            server.checkInput();
            System.out.println("Shutting Down");
        }catch(Exception e){
            System.out.println("Expected one input containing port");
            System.out.println("ex: java ServerRun 1234");
            System.exit(0);
        }

    }
}
