package com.megs.controllers;
import com.megs.Models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/items")
public class ItemController {
    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    Item getItem() {
        Item item = new Item("i1", "q1", 12.2);
        return item;
    }

}
