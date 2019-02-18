package src;

import java.util.HashMap;

public class Room {
    private String info;
    private HashMap<String, Room> exits;
    private ItemCollection items;

    public Room(String info) {
        this.info = info;
        this.exits = new HashMap<>();
    }

    public void addExit(String direction, Room neighbor)  {
        this.exits.put(direction, neighbor);
    }

    public String getInfo() {
        return this.info;
    }

    public Item getItem(String item) {
        return this.items.get(item);
    }

    public Room getExit(String direction)  {
        return exits.get(direction);
    }
}