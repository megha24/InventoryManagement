package com.megs.controllers;

import com.megs.models.Item;
import com.megs.services.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> saveItem(@RequestBody Item item) {
        service.saveItem(item);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
