/**
 * Represents an item with a name and a discription.
 * With this class you can:
 * <ul>
 * <li>Set the name of the item.
 * <li>Set the info on the item.
 * <li>Get the name of the item.
 * <li>Get the info on the item.
 * </ul>
 * The name and the info are of the type<code>String</code>.
 * 
 * @author Håkon "Haklerz" Lervik
 * @version 1.0
 */
public class Item {
    private String name;
    private String info;

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
     * Sets the info on the item. Takes a<code>String</code>.
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Returns the info on the item as a<code>String</code>.
     * @return Info on the item.
     */
    public String getInfo() {
        return this.info;
    }
}