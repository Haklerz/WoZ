package src;

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
    private boolean collectible;

    public Item(String name, String description, boolean collectible) {
        this.name = name;
        this.description = description;
        this.collectible = collectible;
    }

    /**
     * Returns the name of the item as a<code>String</code>.
     * @return Name of the item.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the description of the item as a<code>String</code>.
     * @return Description of the item.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns wether the item is collectible as a <code>boolean</code>.
     * @return wether the item is collectible
     */
    public boolean isCollectible() {
        return this.collectible;
    }
}