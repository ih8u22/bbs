package me.bbs.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.bbs.mapper.UserMapper;
import me.bbs.pojo.User;
import me.bbs.pojo.UserPageBean;
import me.bbs.pojo.UserQueryRequest;
import me.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        // 检查用户名和邮箱是否已经存在
        if (getUserByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        if (getUserByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }

        // 设置默认值
        user.setRole((byte) 1); // 默认为普通用户
        user.setPoints(0);
        user.setGrade((byte) 1);

        userMapper.insert(user);
    }


    @Override
    public User getUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    @Override
    public Integer count() {
        return userMapper.userCount();
    }

    @Override
    public List<User> userList() {
        return userMapper.getAllUsers();
    }

    @Override
    public void update(User user) {
        userMapper.updateUserInfoByID(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public UserPageBean query(UserQueryRequest userQueryRequest) {
        List<User> userList = userMapper.queryUsers(userQueryRequest);
        Integer total = userList.size();
        return new UserPageBean(total,userList);
    }

    @Override
    public User getUserById(Integer id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

}
