package src;

import java.util.HashMap;

/**
 * Represents a room.
 */
public class Room {
    private String name;
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
        this.items = new ItemCollection();
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

    public String getName() {
        return this.name;
    }

    public Item takeItem(String name) {
        return this.items.take(name);
    }
}