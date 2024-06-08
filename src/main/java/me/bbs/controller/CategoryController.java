package me.bbs.controller;

import me.bbs.pojo.Category;
import me.bbs.pojo.Result;
import me.bbs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/categories")
    public Result createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return Result.success();

    }

    @GetMapping("/categories/{id}")
    public Result getCategoryById(@PathVariable Integer id){
        Category category = categoryService.getCategoryById(id);
        return Result.success(category);
    }

    @GetMapping("/categories")
    public Result list(){

        return Result.success(categoryService.list());
    }


}
