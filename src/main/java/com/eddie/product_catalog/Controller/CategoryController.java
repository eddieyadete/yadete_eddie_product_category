package com.eddie.product_catalog.Controller;

import com.eddie.product_catalog.Models.Category;
import com.eddie.product_catalog.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/api/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
