package src;

/**
 * Represents an interactable item.
 */
public class Interactable extends Item {
    private Item requiredItem = null;
    private Event event;

    public void use(Item item) {
        if (item.equals(requiredItem)) {
            switch(event) {
                case COMBINE: break;
                case OPEN:    break;
                case CONSUME: break;
            }
        }
    }
}