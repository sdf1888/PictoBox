package serverTier.application;

import serverTier.model.Room;

import java.util.HashMap;
import java.util.Map;

public class Rooms {

    private Map<String, Room> rooms;

    public Rooms(){
        this.rooms = new HashMap<>();
    }

    /**
     * Creates a new room and adds it to the map
     * generates a port for a room
     * @param name
     */
    public void addRoom(String name){
        this.rooms.put(name, new Room(name));
    }

    public void removeRoom(String name){
        this.rooms.remove(name);
    }

    public int getRoomPort(String roomName){
        return this.rooms.get(roomName).getPort();
    }
}
