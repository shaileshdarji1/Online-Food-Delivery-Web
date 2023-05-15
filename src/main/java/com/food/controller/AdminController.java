package com.food.controller;

import com.food.dto.ItemDto;
import com.food.entity.Category;
import com.food.entity.Item;
import com.food.services.CategoryService;
import com.food.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
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
    CategoryService categoryService;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ItemService itemService;

    @RequestMapping("/dashboard")
    public String dashboard() {
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
                File saveFile = new ClassPathResource("static/image/category").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
                Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
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
    public String saveItem(@ModelAttribute ItemDto itemDto,@RequestParam("imageUrl") MultipartFile file) throws IOException {
        Item item = modelMapper.map(itemDto, Item.class);

        //processing and upload file
        try {
            if (file.isEmpty()) {
                System.out.println("File is Empty");
            } else {
                item.setImageUrl(file.getOriginalFilename());
                String path="image";
                String filePath = path + File.separator + file.getOriginalFilename();
                File f = new File(path);
                if(!f.exists()){
                    f.mkdir();
                }
                Files.copy(file.getInputStream(),Paths.get(path));
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
