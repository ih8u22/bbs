package me.bbs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 封装回复数和回复的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyBean {
    private Integer total;
    private List<Reply> rows;


}
