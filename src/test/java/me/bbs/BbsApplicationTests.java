package me.bbs;

import me.bbs.mapper.UserMapper;
import me.bbs.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BbsApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = new User(null,"2113","123","23323",(byte)1,13,"12313","sssw",(byte)1,0,null);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

}
