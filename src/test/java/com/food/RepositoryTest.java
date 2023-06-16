package com.food;

import com.food.entity.Item;
import com.food.repository.CategoryRepository;
import com.food.repository.ItemRepository;
import com.food.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void userData() {
        System.out.println(userRepository.findByUsername("Haresh"));
    }

    @Test
    public void itemData() {
        List<Item> items = itemRepository.findAll();
//        items.stream().filter(i -> i.getCreatedDate().toLocalDate().compareTo(LocalDate.of(2023, 05, 19)) >= 0).filter(i -> i.getCreatedDate().toLocalDate().compareTo(LocalDate.of(2023, 05, 20)) <= 0).forEach(n-> System.out.println(n));
//        System.out.println(items.stream().filter(i->i.getCategory().getName().equalsIgnoreCase("Dabeli")).max(new Comparator<Item>() {
//        @Override
//        public int compare(Item o1, Item o2) {
//            return o1.getPrice().compareTo(o2.getPrice());
//        }
//    }));
        Optional<Item> item=items.stream().filter(i->i.getCategory().getName().equalsIgnoreCase("Dabeli")).sorted(Comparator.comparing(Item::getPrice)).findFirst();
        System.out.println(item);
    }

}