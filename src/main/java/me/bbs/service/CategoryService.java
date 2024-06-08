package me.bbs.service;

import me.bbs.pojo.Category;
import me.bbs.pojo.CategoryBean;

import java.util.List;

public interface CategoryService {
    void createCategory(Category category);

    CategoryBean list();

    Category getCategoryById(Integer id);
}
