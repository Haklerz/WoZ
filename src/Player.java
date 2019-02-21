package src;

import java.util.Iterator;

/**
 * Represents a player.
 * @author Håkon "Haklerz" Lervik
 * @version 20.2.2019
 */
public class Player {
    private String name;
    private ItemCollection inventory;
    private Room currentRoom;

    /**
     * Initializes a player. This constructor takes a name and a starting room.
     * @param name Name of the player.
     * @param startRoom The starting room.
     */
    public Player(String name, Room startRoom) {
        this.name = name;
        this.currentRoom = startRoom;
    }

    /**
     * Returns the name of the player as a<code>String</code>.
     * @return Name of the player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Moves the player to a new room.
     * @param room Room to move to.
     */
    public void goRoom(Room room) {
        if (room != null) {
            this.currentRoom = room;
        }
    }

    /**
     * Returns the room the player is currently in.
     * @return The room the player is currently in.
     */
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * Returns wether the player has a specific item.
     * @param name Name of the item.
     * @return Wether the player has a specific item.
     */
    public Boolean hasItem(String name) {
        return this.inventory.hasItem(name);
    }

    public void addItem(Item item) {
        this.inventory.addItem(item);
    }

    public Iterator<String> getItemNames() {
        return this.inventory.getItemNames();
    }
}