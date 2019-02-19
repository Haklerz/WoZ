package src;

/**
 * Represents an item with a name and a discription.
 * With this class you can:
 * <ul>
 * <li>Set the name of the item.
 * <li>Set the description on the item.
 * <li>Get the name of the item.
 * <li>Get the description on the item.
 * </ul>
 * The name and the description are of the type<code>String</code>.
 * 
 * @author Håkon "Haklerz" Lervik
 * @version 1.0
 */
public class Item {
    private String name;
    private String description;

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
     * Sets the description on the item. Takes a<code>String</code>.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the description on the item as a<code>String</code>.
     * @return Description on the item.
     */
    public String getDescription() {
        return this.description;
    }
}