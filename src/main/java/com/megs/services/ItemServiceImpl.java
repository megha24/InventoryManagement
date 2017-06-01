package com.megs.services;

import com.megs.dao.ItemDao;
import com.megs.models.Item;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {
    private static final Logger logger  = Logger.getLogger(ItemServiceImpl.class);

    @Autowired
    ItemDao itemDao;

    @Override
    public List<Item> GetItems() {
        List<Item> items = itemDao.findAll();
        return items;
    }

    @Override
    public void saveItem(Item item) throws SQLDataException {
        try{

            itemDao.insertItem(item);
            logger.info("item Inserted Successfully");
        }catch (Exception e){
            logger.error("some issue with the item");
            throw new SQLDataException("Item can not be inserted");
        }
    }
}
