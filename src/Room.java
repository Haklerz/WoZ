package src;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Represents a room. A room has a discription and a number of exits to other rooms.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Create a room.
 * <li>Add exits to the room.
 * <li>Remove exits from the room.
 * <li>Get the room at an exit.
 * <li>Get a description of the room.
 * <li>Get the exits of the room.
 * </ul>
 * @author Håkon "Haklerz" Lervik
 * @version 20.2.2019
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits;
    private ItemCollection items;
    
    /**
     * Creates a room.
     * This constructor takes a description of
     * the room as a<code>String</code>.
     * @param description Description of the room.
     */
    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<String, Room>();
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

    /**
     * Adds an item to the room.
     * @param item Item to be added.
     */
    public void addItem(Item item) {
        this.items.addItem(item);
    }

    public Iterator<String> getItemNames() {
        return this.items.getItemNames();
    }
}