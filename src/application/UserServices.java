package application;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class UserServices {

    public static final String HOSTNAME = "";
    public static final int SERVER_PORT = 11476;

    private Socket client;
    private Scanner scanner;
    private PrintWriter printWriter;

    public UserServices(){
        try {
            this.client = new Socket(HOSTNAME, SERVER_PORT);
            this.scanner = new Scanner(client.getInputStream());
            this.printWriter = new PrintWriter(client.getOutputStream());
        }catch(IOException io){
            System.out.println("IOException in UserServices Constructor");
            System.out.println(io.getLocalizedMessage());
        }
    }
}
