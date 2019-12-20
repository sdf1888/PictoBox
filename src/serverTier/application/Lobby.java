package serverTier.application;

import clientTier.model.Client;
import java.util.ArrayList;

public class Lobby {

    private static ArrayList<Client> users;

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
    public void addUser(Client user){
        this.users.add(user);
    }

    /**
     * used to remove a user from a room when they leave / disconnect from a room
     * @param user the user to remove from the room's members
     */
    public void removeUser(Client user){
        this.users.remove(user);
    }
}
