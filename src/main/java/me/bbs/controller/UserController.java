package me.bbs.controller;

import lombok.extern.slf4j.Slf4j;
import me.bbs.pojo.*;
import me.bbs.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @PostMapping("/users/register")
    public Result register(@RequestBody User user) {
        try {
            userService.register(user);
            return Result.success(user);
        } catch (RuntimeException e) {
            return Result.error("用户名或邮箱已被注册");
        }
    }

    /**
     * 条件查询用户数据
     *
     * @return
     */

    @GetMapping("/users")
    public Result query(UserQueryRequest userQueryRequest) {

        UserPageBean pageBean = userService.query(userQueryRequest);
        return Result.success(pageBean);
    }

    @PutMapping("/users")
    public Result update(@RequestBody User user) {

        userService.update(user);
        return Result.success();
    }

    @DeleteMapping("/users/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.delete(id);
        return Result.success();

    }

    @GetMapping("/users/{id}")
    public Result getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return Result.success(user);
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            return Result.success();
        } else {
            return Result.error("用户名或密码错误");
        }
    }

    @PostMapping("/adminLogin")
    public Result adminLogin(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            if (user.getRole() != 2) {
                return Result.error("非管理员用户无法登录");
            }
            return Result.success();

        } else {
            return Result.error("用户名或密码错误");
        }
    }
}