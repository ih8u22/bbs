package me.bbs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 查询所有用户的封装
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPageBean {
    private Integer total;
    private List<User> rows;
}
