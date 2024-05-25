package com.exam.services.impl;

import com.exam.models.exam.Category;
import com.exam.repo.CategoryRepo;
import com.exam.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public Category addCategory(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category getCategory(Long cId) {
        return this.categoryRepo.findById(cId).get();
    }

    @Override
    public Set<Category> getAllCategories() {
        return new LinkedHashSet<>(this.categoryRepo.findAll());
    }

    @Override
    public void deleteCategory(Long cId) {
        Category category = new Category();
        category.setCId(cId);
        this.categoryRepo.delete(category);
    }
}
