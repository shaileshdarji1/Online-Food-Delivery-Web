package com.food.services.impl;

import com.food.entity.Item;
import com.food.repository.ItemRepository;
import com.food.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public Item getItem(Integer menutype_id) {
        return itemRepository.findItem(menutype_id);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void delete(Integer item_id) {
        itemRepository.delete(itemRepository.findItem(item_id));
    }

    @Override
    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

}