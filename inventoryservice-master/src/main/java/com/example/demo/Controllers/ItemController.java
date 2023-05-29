package com.example.demo.Controllers;

import com.example.demo.Models.Item;
import com.example.demo.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/Item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("items")
    public List<Item> getAllItems(){
        return itemService.getItems();
    }

    @RequestMapping("items/{id}")
    public Item getItem(@PathVariable long id){
        return itemService.getItem(id);
    }

    @PostMapping("addItem")
    public String addItemtoRepo(@RequestBody Item i){
        return itemService.addItemtoRepo(i);
    }

}
