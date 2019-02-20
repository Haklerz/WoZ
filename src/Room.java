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
     * This constructor takes a description of
     * the room as a<code>String</code>.
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
    
    /**
     * Returns the room in a specified direction if there is one.
     * If there is no neightbouring room in that direction<code>null</code>is returned.
     * @param direction Direction of room to get.
     * @return The neighbouring room in the direction.
     */
    public Room getExit(String direction) {
        return this.exits.get(direction.toLowerCase());
    }

    /**
     * Removes a connection to a neighbouring room in a direction if there is one.
     * @param direction Direction of neighbouring room to remove.
     */
    public void removeExit(String direction) {
        this.exits.remove(direction.toLowerCase());
    }

    /**
     * Returns the description of the room.
     * @return the discription of the room.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returnes the iterator over the set of available exits from the room.
     * @return the iterator over the set of available exits from the room.
     */
    public Iterator<String> getExitDirections() {
        return this.exits.keySet().iterator();
    }
}