package src;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Represents a room.
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits;
    
    /**
     * Creates a room.
     * 
     * @param description Description of the room.
     */
    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<>();
    }

    /**
     * Adds an exit to another room.
     * @param direction Direction to the room.
     * @param neighbor Neighboring room.
     */
    public void addExit(String direction, Room neighbor)  {
        this.exits.put(direction.toLowerCase(), neighbor);
    }
    
    public Room getExit(String direction) {
        return this.exits.get(direction.toLowerCase());
    }

    public void removeExit(String direction) {
        this.exits.remove(direction.toLowerCase());
    }

    public String getDescription() {
        return this.description;
    }

    public Iterator<String> getExitDirections() {
        return this.exits.keySet().iterator();
    }
}