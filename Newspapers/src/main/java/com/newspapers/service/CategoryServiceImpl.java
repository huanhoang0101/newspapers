package com.newspapers.service;

import com.newspapers.model.Category;
import com.newspapers.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }
    @Override
    public List<Category> addCategory(List<Category> list) {
        return categoryRepo.saveAll(list);
    }
}
