package src;

/**
 * Represents a player.
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

    public void goRoom(Room room) {
        if (room != null) {
            this.currentRoom = room;
        }
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void add(Item item) {
        this.inventory.add(item);
    }

    public Boolean hasItem(Item item) {
        return this.inventory.hasItem(item);
    }
}