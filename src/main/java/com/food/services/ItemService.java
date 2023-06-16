package com.food.services;

import com.food.entity.Item;

import java.util.List;

public interface ItemService {
    public Item getItem(Integer item_id);

    public Item saveItem(Item item);

    public void delete(Integer item_id);

    public List<Item> findAllItem();

    public long count();
}
