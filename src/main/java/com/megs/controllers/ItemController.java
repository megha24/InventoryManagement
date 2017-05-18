package com.megs.controllers;
import com.megs.Models.Item;
import com.megs.services.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    IItemService service;
    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Item> getItem() {
        List<Item> items = service.GetItems();
        return items;
    }

}
