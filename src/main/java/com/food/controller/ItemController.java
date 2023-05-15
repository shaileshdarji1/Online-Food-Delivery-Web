package com.food.controller;

import com.food.entity.Item;
import com.food.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/items")
    public List<Item> findAllItem(){
        return itemService.findAllItem();
    }

    @GetMapping("/{item_id}")
    public Item getItem(@PathVariable("item_id") Integer item_id) {
        return itemService.getItem(item_id);
    }

    @PostMapping("/delete/{item_id}")
    public void deleteCategory(@PathVariable("item_id") Integer item_id) {
        itemService.delete(item_id);
    }

}
