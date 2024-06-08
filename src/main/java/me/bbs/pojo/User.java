package me.bbs.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private Byte gender; //性别 , 1 男, 2 女
    private Integer age;
    private String hobby;
    private String occupation;
    private Byte role;
    private Integer points;
    private Byte grade;

}
