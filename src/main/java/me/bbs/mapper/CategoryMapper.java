package me.bbs.mapper;

import me.bbs.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Insert("INSERT INTO category (name) VALUES (#{name })")
    void createCategory(Category category);

    @Select("SELECT * FROM category")
    List<Category> list();

    @Select("SELECT * FROM category WHERE id = #{id}")
    Category getCategoryById(Integer id);
}
