package src;

import java.util.HashMap;

public class Crafter {
    HashMap<Integer, Item> recipes;

    public void addRecipe(Item firstItem, Item secondItem, Item producItem) {
        Integer key = firstItem.hashCode() + secondItem.hashCode();
        this.recipes.put(key, producItem);
    }
}