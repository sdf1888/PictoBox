import model.Room;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Server implements Runnable {

    public static final String HOSTNAME = "";
    public static final int SERVER_PORT = 11476;

    private ServerSocket server;
    private Scanner scanner;
    private PrintWriter printWriter;
    private ArrayList<InputStream> inputStreams;
    private ArrayList<OutputStream> outputStreams;
    private HashMap<Integer, Room> rooms;
    private Thread clientListenerThread;

    public Server(){
        try {
            this.clientListenerThread = new Thread(this);
            this.server = new ServerSocket(SERVER_PORT);

            clientListenerThread.start();
        }catch(IOException io){
            System.out.println(io.getLocalizedMessage());
        }
    }

    @Override
    private void run() {
        try {
            Socket client = server.accept();
        }catch(IOException io){
            System.out.println("IOException in ClientListernerThread");
            System.out.println(io.getLocalizedMessage());
        }
    }

    public static void main(String[] args) {


    }
}
