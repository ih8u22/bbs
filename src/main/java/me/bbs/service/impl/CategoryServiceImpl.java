package me.bbs.service.impl;

import me.bbs.mapper.CategoryMapper;
import me.bbs.pojo.Category;
import me.bbs.pojo.CategoryBean;
import me.bbs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public void createCategory(Category category) {

        category.setCreatedAt(LocalDateTime.now());
        categoryMapper.createCategory(category);
    }

    @Override
    public CategoryBean list() {

        List<Category> categoryList = categoryMapper.list();

        return new CategoryBean(categoryList.size(),categoryList);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryMapper.getCategoryById(id);
    }
}
