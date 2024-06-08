package me.bbs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询所有用户的封装
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPageBean {
    private Integer total;
    private List<Post> rows;
}

