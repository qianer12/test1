package com.test1.dao;

import com.test1.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryDao {

    List<Category> findAll();

    void delete(int id);

    void update(Category category);

    void add(Category category);

    Category findById(int id);

}
