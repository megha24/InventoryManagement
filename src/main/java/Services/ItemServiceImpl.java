package Services;

import Models.Item;

/**
 * Created with IntelliJ IDEA.
 * User: meghaagr
 * Date: 5/5/17
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemServiceImpl implements IItemService{
    Item item;

    public void AddItem(String itemName, double cost, String quality) {
        item = new Item(itemName, quality, cost);


    }
}
