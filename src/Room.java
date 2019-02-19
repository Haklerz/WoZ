package src;

import java.util.HashMap;

/**
 * Represents a room.
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits;
    private ItemCollection items;

    /**
     * Creates a room.
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
        this.exits.put(direction, neighbor);
    }

    public String getDescription() {
        return this.description;
    }

    public Item getItem(String item) {
        return this.items.take(item);
    }

    public Room getExit(String direction)  {
        return exits.get(direction);
    }
}