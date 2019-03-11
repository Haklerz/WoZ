package src;

import java.util.Iterator;
import java.util.Stack;

/**
 * Represents a player.
 * @author Håkon "Haklerz" Lervik
 * @version 5.3.2019
 */
public class Player {
    private String name;
    private ItemCollection inventory;
    private Room currentRoom;
    private Stack<Room> roomLog;

    /**
     * Initializes a player. This constructor takes a name and a starting room.
     * @param name name of the player
     * @param startRoom the starting room
     */
    public Player(String name, Room startRoom) {
        this.name = name;
        this.currentRoom = startRoom;
        this.inventory = new ItemCollection();
        this.roomLog = new Stack<>();
    }

    /**
     * Returns the name of the player as a<code>String</code>.
     * @return name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Moves the player to a new room.
     * @param room room to move to
     */
    public void goRoom(Room room) {
        if (room != null) {
            //this.roomLog.push(this.currentRoom);
            this.currentRoom = room;
        }
        else {
            throw new NullPointerException("No room in that direction.");
        }
    }

    /**
     * Pushes a room on to the room log stack.
     * @param room room to log
     */
    public void pushRoomLog(Room room) {
        if (room != null) {
            this.roomLog.push(room);
        }
        else {
            throw new NullPointerException("Cannot push null room.");
        }
    }

    /**
     * Returns the previous room the player was in.
     * @return the previous room the player was in
     */
    public Room popRoomLog() {
        if (!this.roomLog.empty()) {
            return this.roomLog.pop();
        }
        else {
            throw new NullPointerException("No previous room.");
        }
    }

    /**
     * Returns the room the player is currently in.
     * @return the room the player is currently in
     */
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * Returns wether the player has a specific item.
     * @param name name of the item
     * @return wether the player has a specific item
     */
    public Boolean hasItem(String name) {
        return this.inventory.hasItem(name);
    }

    /**
     * Adds an item to the player's inventory.
     * @param item item to add
     */
    public void addItem(Item item) {
        this.inventory.addItem(item);
    }

    /**
     * Returns an iterator over the items in the player's inventory.
     * @return an iterator over the items in the player's inventory
     */
    public Iterator<String> getItemIterator() {
        return this.inventory.getItemIterator();
    }
}