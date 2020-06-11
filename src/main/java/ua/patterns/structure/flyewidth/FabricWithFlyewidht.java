package ua.patterns.structure.flyewidth;

import java.util.ArrayList;
import java.util.List;

public class FabricWithFlyewidht {
    private List<Item> itemSet = new ArrayList();

    Item getItem(Item i){
        for (Item item : itemSet) {
            if (item.getParam().equals(i.getParam()) &&
                    item.getClass().equals(i.getClass())) {
                return item;
            }
        }
        itemSet.add(i);
        return i;
    }
}
