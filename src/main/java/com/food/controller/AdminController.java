package com.food.controller;

import com.food.dto.ItemDto;
import com.food.entity.Category;
import com.food.entity.Item;
import com.food.helper.Constant;
import com.food.services.CartService;
import com.food.services.CategoryService;
import com.food.services.ItemService;
import com.food.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ItemService itemService;

    @RequestMapping({"/dashboard", "/"})
    public String dashboard(ModelMap model) {
        model.addAttribute("item",itemService.count());
        model.addAttribute("category",categoryService.count());
        model.addAttribute("cart",cartService.count());
        model.addAttribute("order",orderService.count());
        return "admin";
    }

    @RequestMapping("/category")
    public String category() {
        return "category";
    }

    @RequestMapping("/item")
    public String item() {
        return "item";
    }

    @RequestMapping("/admincart")
    public String adminCart(){
        return "admincart";
    }

    @RequestMapping("/adminorder")
    public String adminOrder(){
        return "adminorder";
    }
    @PostMapping("/add_category")
    public String addCategory(@ModelAttribute Category category, @RequestParam("image") MultipartFile file) {
        try {
            Date date = Date.valueOf(LocalDate.now());
            category.setCreatedDate(date);

            //processing and upload file
            if (file.isEmpty()) {
                System.out.println("File is Empty");
            } else {
                category.setImageUrl(file.getOriginalFilename());
                Path path = Paths.get(Constant.CATEGORY_PATH + File.separator + file.getOriginalFilename());
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            }
            if (category != null) {
                categoryService.saveCategory(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/category";
    }

    @PostMapping("/add_item")
    public String saveItem(@ModelAttribute ItemDto itemDto, @RequestParam("imageUrl") MultipartFile file) throws IOException {
        Item item = modelMapper.map(itemDto, Item.class);
        item.setItemId(null);

        try {
            //processing and upload file
            if (file.isEmpty()) {
                System.out.println("File is Empty");
            } else {
                item.setImageUrl(file.getOriginalFilename());
                Path path = Paths.get(Constant.ITEM_PATH + File.separator + file.getOriginalFilename());
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        item.setCategory(categoryService.findCategoryById(itemDto.getCategoryId()));
        Date date = Date.valueOf(LocalDate.now());
        item.setCreatedDate(date);
        itemService.saveItem(item);

        return "redirect:/admin/item";
    }

    @PostMapping("/update_item")
    public String UpdateItem(@ModelAttribute ItemDto itemDto, @RequestParam("imageUrl") MultipartFile file,@RequestParam("itemId") Integer itemId) throws IOException {
        Item item = modelMapper.map(itemDto, Item.class);
        item.setItemId(itemId);

        try {
            //processing and upload file
            if (file.isEmpty()) {
                System.out.println("File is Empty");
            } else {
                item.setImageUrl(file.getOriginalFilename());
                Path path = Paths.get(Constant.ITEM_PATH + File.separator + file.getOriginalFilename());
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        item.setCategory(categoryService.findCategoryById(itemDto.getCategoryId()));
        Date date = Date.valueOf(LocalDate.now());
        item.setCreatedDate(date);
        itemService.saveItem(item);

        return "redirect:/admin/item";
    }
}
