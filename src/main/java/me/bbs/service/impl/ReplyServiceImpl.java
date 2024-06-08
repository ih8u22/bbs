package me.bbs.service.impl;

import me.bbs.mapper.ReplyMapper;
import me.bbs.pojo.Reply;
import me.bbs.pojo.ReplyBean;
import me.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public void createReply(Reply reply) {

        //初始值
        reply.setCreatedAt(LocalDateTime.now());
        reply.setLikeCount(0);

        replyMapper.createReply(reply);
    }


    @Override
    public void delete(Integer replyId) {
        replyMapper.delete(replyId);
    }

    @Override
    public ReplyBean getReplyAndCount(Integer postId) {

        Integer total = replyMapper.count(postId);
        List<Reply> replyList = replyMapper.getReply(postId);

        ReplyBean replyBean = new ReplyBean(total,replyList);
        return replyBean;
    }
}
