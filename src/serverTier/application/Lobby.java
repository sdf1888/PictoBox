package serverTier.application;

import clientTier.model.ClientSend;
import java.util.ArrayList;

public class Lobby {

    private static ArrayList<ClientSend> users;
    //TODO remove this class, basically just a class to hold an Arraylist
    /**
     * Creates a new lobby list, used when a new room is created.
     */
    public Lobby(){
        this.users = new ArrayList<>();
    }

    /**
     * used when a user enters the room
     * @param user the user to add to a room
     */
    public void addUser(ClientSend user){
        this.users.add(user);
    }

    /**
     * used to remove a user from a room when they leave / disconnect from a room
     * @param user the user to remove from the room's members
     */
    public void removeUser(ClientSend user){
        this.users.remove(user);
    }
}
