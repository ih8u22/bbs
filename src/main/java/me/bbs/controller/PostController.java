package me.bbs.controller;

import lombok.extern.slf4j.Slf4j;
import me.bbs.pojo.Post;
import me.bbs.pojo.PostPageBean;
import me.bbs.pojo.PostQueryRequest;
import me.bbs.pojo.Result;
import me.bbs.service.PostService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public Result createPost(@RequestBody Post post){
        postService.creatPost(post);
        return Result.success();
    }

    @GetMapping("/posts/{id}")
    public Result getPostById(@PathVariable Integer id){
        Post post = postService.getPostById(id);
        return Result.success(post);
    }


    @PutMapping("/posts")
    public Result update(@RequestBody Post post){

        postService.update(post);
        return Result.success();
    }

    @DeleteMapping("/posts/{id}")
    public Result delete(@PathVariable Integer id){
        postService.delete(id);
        return Result.success();
    }

    @GetMapping("/posts")
    public Result query(PostQueryRequest postQueryRequest){
        PostPageBean postPageBean = postService.query(postQueryRequest);
        return Result.success(postPageBean);
    }



}
