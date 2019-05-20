package com.test1.service.impl;

import com.test1.dao.CategoryDao;
import com.test1.entity.Category;
import com.test1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void add(Category category) {
        categoryDao.add(category);
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }
}
