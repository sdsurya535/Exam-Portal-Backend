package com.exam.controller;

import com.exam.models.exam.Category;
import com.exam.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    // add Catgegory
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {

        Category category1 = categoryService.addCategory(category);

        return ResponseEntity.ok(category1);

    }

    @GetMapping("/{cId}")
    public Category getCategoryById(@PathVariable("cId") Long cId) {

        return this.categoryService.getCategory(cId);

    }

    @GetMapping("/")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }

    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category) {
        return this.categoryService.updateCategory(category);
    }

    @DeleteMapping("/{cId}")
    public void deleteCategroy(@PathVariable("cId") Long cId) {
        this.categoryService.deleteCategory(cId);
    }
}
