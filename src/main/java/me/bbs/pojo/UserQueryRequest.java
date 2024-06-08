package me.bbs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryRequest {

    private String username;
    private String email;
    private Byte gender; //性别 , 1 男, 2 女
    private Integer ageStart;
    private Integer ageEnd;
    private String hobby;
    private String occupation;
    private Byte role;
    private Integer pointsStart;
    private Integer pointsEnd;
    private Byte gradeStart;
    private Byte gradeEnd;
}