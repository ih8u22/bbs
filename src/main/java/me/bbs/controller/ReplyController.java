package me.bbs.controller;

import me.bbs.pojo.Reply;
import me.bbs.pojo.ReplyBean;
import me.bbs.pojo.Result;
import me.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PostMapping("/replies")
    public Result createReply(@RequestBody Reply reply){

        replyService.createReply(reply);
        return Result.success();

    }

    @GetMapping("/replies/{postId}")
    public Result getReplyAndCount(@PathVariable Integer postId){

        ReplyBean replyBean = replyService.getReplyAndCount(postId);

        return Result.success(replyBean);
    }

    @DeleteMapping("/replies/{replyId}")
    public Result delete(@PathVariable Integer replyId){
        replyService.delete(replyId);
        return Result.success();
    }

}
