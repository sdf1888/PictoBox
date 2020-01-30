package serverTier.application;

import serverTier.model.Room;

import java.util.HashMap;
import java.util.Map;

public class Rooms {

    private Map<String, Room> rooms;

    public Rooms(){
        this.rooms = new HashMap<>();
    }

    public void addRoom(Room room){
        this.rooms.put(room.getName(), room);
    }

    public void removeRoom(Room room){
        this.rooms.remove(room.getName());
    }

    public Room getRoom(String roomName){
        return this.rooms.get(roomName);
    }
}
