package com.test1.service;

import com.test1.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    void delete(int id);

    void update(Category category);

    void add(Category category);

    Category findById(int id);

}
