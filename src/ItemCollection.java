package src;

import java.util.HashMap;

/**
 * Represents a collection of items.
 */
public class ItemCollection {
    HashMap<String, Item> items;

    /**
     * Adds an item to the item collection.
     * @param item Item to add.
     */
    public void add(Item item) {
        items.put(item.getName(), item);
    }

    /**
     * Returns the item with the name given if it is in the collection.
     * If not it returns<code>null</code>.
     * @param name Name of item to get.
     * @return Item with the name given.
     */
    /*
    private Item get(String name) {
        return this.items.get(name);
    }
    */

    /**
     * Takes the item with the given name out of the collection
     * and returns it. If there is no item by that name<code>null</code>is
     * returned.
     */
    public Item take(String name) {
        Item item = items.get(name);
        items.remove(name);
        return item;
    }

    /**
     * Returns wether the collection contains the item.
     * If the item is in the collection it returns<code>true</code>,
     * if not it returns<code>false</code>.
     * @param item Item to check.
     * @return Wether the collection contains the item.
     */
    public Boolean hasItem(Item item) {
        return this.items.containsValue(item);
    }
}