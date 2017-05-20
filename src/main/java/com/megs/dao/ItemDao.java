package com.megs.dao;

import com.megs.models.Item;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: meghaagr
 * Date: 5/19/17
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */

public interface ItemDao {
    void insertItem(Item item);
    List<Item> findAll();
}
