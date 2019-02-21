package src;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Represents a collection of items.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Create a collection of items.
 * <li>Add an item to the item collection.
 * <li>Take an item out of the collection.
 * <li>Check wether the collection contains an item.
 * </ul>
 * @author Håkon "Haklerz" Lervik
 * @version 20.2.2019
 */
public class ItemCollection {
    private HashMap<String, Item> items;

    /**
     * Creates a item collection.
     */
    public ItemCollection() {
        this.items = new HashMap<>();
    }

    /**
     * Adds an item to the item collection.
     * @param item Item to be added.
     */
    public void addItem(Item item) {
        this.items.put(item.getName(), item);
    }

    /**
     * Takes an item out of the item collection. This method takes the
     * name of the item to be retrieved. If the collection does not have
     * the item,<code>null</code>is returned.
     * @param itemName Name of item to be retrieved.
     * @return Item taken from the collection if found.
     */
    public Item takeItem(String itemName) {
        Item item = this.items.get(itemName);
        this.items.remove(itemName);
        return item;
    }

    /**
     * Returnes wether the item collection contains an item.
     * This method takes the name of the item to check.
     * If the collection contains the item it returns<code>true</code>,
     * if not, it returns<code>false</code>.
     * @param itemName Name of the item to check.
     * @return Wether the collection contains the item.
     */
    public boolean hasItem(String itemName) {
        return (this.items.get(itemName) != null);
    }

    /**
     * Returns an iterator over the names of the items in the collection.
     * @return An iterator over the names of the items in the collection.
     */
    public Iterator<String> getItemNames() {
        return this.items.keySet().iterator();
    }
}