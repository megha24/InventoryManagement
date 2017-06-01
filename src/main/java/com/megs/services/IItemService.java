package com.megs.services;
import com.megs.models.Item;

import java.sql.SQLDataException;
import java.util.List;

public interface IItemService {

    public List<Item> GetItems();

    void saveItem(Item item) throws SQLDataException;
}
