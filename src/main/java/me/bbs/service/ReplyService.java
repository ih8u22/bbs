package me.bbs.service;

import me.bbs.pojo.Reply;
import me.bbs.pojo.ReplyBean;



public interface ReplyService {
    void createReply(Reply reply);

    void delete(Integer replyId);

    ReplyBean getReplyAndCount(Integer postId);
}
