package com.megs.services;

import com.megs.dao.ItemDao;
import com.megs.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    ItemDao itemDao;

    @Override
    public List<Item> GetItems() {
        List<Item> items = itemDao.findAll();
        return items;
    }

    @Override
    public void saveItem(Item item) {
        itemDao.insertItem(item);
    }
}
