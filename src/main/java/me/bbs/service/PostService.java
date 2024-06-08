package me.bbs.service;

import me.bbs.pojo.Post;
import me.bbs.pojo.PostPageBean;
import me.bbs.pojo.PostQueryRequest;

import java.util.List;

public interface PostService {
    void creatPost(Post post);

    Post getPostById(Integer id);

    Integer postCount();

    List<Post> getAllPosts();

    void update(Post post);

    void delete(Integer id);


    PostPageBean query(PostQueryRequest postQueryRequest);
}
