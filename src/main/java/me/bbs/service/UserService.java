package me.bbs.service;

import me.bbs.pojo.User;
import me.bbs.pojo.UserPageBean;
import me.bbs.pojo.UserQueryRequest;

import java.util.List;

public interface UserService {

    void register(User user);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    List<User> userList();

    Integer count();

    void update(User user);

    void delete(Integer id);

    UserPageBean query(UserQueryRequest userQueryRequest);

    User getUserById(Integer id);

    User login(String username, String password);
}
