package me.bbs.mapper;


import me.bbs.pojo.User;
import me.bbs.pojo.UserQueryRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户管理
 */
@Mapper
public interface UserMapper {

    /**
     * 注册用户,返回主键id
     */
    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("INSERT INTO user (username, password, email, gender, hobby, occupation, points, age)" +
            " VALUES (#{username}, #{password}, #{email}, #{gender}, #{hobby}, #{occupation}, #{points}, #{age})")
    int insert(User user);

    /**
     * 根据用户名查询数据
     * @param username
     * @return
     */
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);

    /**
     *根据邮箱查询用户数据
     * @param email
     * @return
     */
    @Select("SELECT * FROM user WHERE email = #{email}")
    User findByEmail(String email);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(Integer id);

    /**
     * 查询用户总数
     * @return
     */
    @Select("SELECT COUNT(*) FROM user")
    Integer userCount();

    /**
     * 查询全部用户信息
     * @return
     */
    @Select("SELECT * FROM user")
    List<User> getAllUsers();

    /**
     * 修改用户的数据信息
     * @param user
     * @return
     */
    int updateUserInfoByID(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    void delete(Integer id);


    List<User> queryUsers(UserQueryRequest userQueryRequest);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User getUserByUsername(String username);
}
