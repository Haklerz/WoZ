package src;

import java.util.HashMap;

/**
 * Represents an item with a name and a discription.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Create items.
 * <li>Set the name of the item.
 * <li>Set the description of the item.
 * <li>Get the name of the item.
 * <li>Get the description of the item.
 * <li>Define new combinaitons of items.
 * </ul>
 * The name and the description are of the type<code>String</code>.
 * 
 * @author Håkon "Haklerz" Lervik
 * @version 20.2.2019
 */
public class Item {
    private String name;
    private String description;
    private HashMap<Item, Item> combinations;

    /**
     * Adds a definition for an item combination.
     * This method takes what item should be combined with
     * this item and what the combination's product should be.
     * This method is also commutative, whitch means the
     * combination is added to both this item and the other item
     * so that the combination works both ways.
     * <p>
     * <code>
     * this item + other item -> product item
     * </code>
     * @param item Item to be combined.
     * @param product Product from combination.
     */
    public void addCombination(Item item, Item product) {
        this.combinations.put(item, product);
        item.addCombination(this, product);
    }

    /**
     * Sets the name of the item. Takes a<code>String</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the item as a<code>String</code>.
     * @return Name of the item.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Sets the description of the item. Takes a<code>String</code>.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the description of the item as a<code>String</code>.
     * @return Description of the item.
     */
    public String getDescription() {
        return this.description;
    }
}