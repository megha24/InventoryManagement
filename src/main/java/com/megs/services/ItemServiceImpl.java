package com.megs.services;

import com.megs.Models.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {
    @Override
    public List<Item> GetItems() {
        Item item = new Item("i1", "q1", 12.2);
        List<Item> items = new ArrayList<Item>();
        items.add(item);
//        return repository.getItems();
        return items;
    }
}
