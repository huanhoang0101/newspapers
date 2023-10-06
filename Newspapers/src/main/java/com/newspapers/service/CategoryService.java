package com.newspapers.service;

import com.newspapers.model.Category;
import com.newspapers.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategory();
    List<Category> addCategory(List<Category> list);
}
