package clientTier.model;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClientSocket {

    private PrintWriter clientPrintWriter;
    private Scanner scanner;

    public void clientConnect() {
        try
        {
            Socket clientSocket = new Socket(InetAddress.getLoopbackAddress(), 45211); //Add Hostname and port connection (Current placeholders)
            OutputStream clientOutputStream = clientSocket.getOutputStream();
            clientPrintWriter = new PrintWriter(clientOutputStream);
            InputStream in = clientSocket.getInputStream();
            scanner = new Scanner(in);
        }
        catch(IOException io)
        {
            System.out.println("IOException in PictoServer - closeServerSocket");
            io.getMessage();
        }
    }

    public void printWriterFlush(String input){
        clientPrintWriter.println(input);
        clientPrintWriter.flush();
    }

    public String getMessage(){
        return scanner.nextLine();
    }

    //TODO make threads to send messages
}
