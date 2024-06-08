package me.bbs.service.impl;

import me.bbs.mapper.PostMapper;
import me.bbs.pojo.Post;
import me.bbs.pojo.PostPageBean;
import me.bbs.pojo.PostQueryRequest;
import me.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public void creatPost(Post post) {

        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());

        // 设置默认值
        post.setViewsCount(0); // 默认为普通用户
        post.setStatus("normal");

        postMapper.createPost(post);
    }

    @Override
    public Post getPostById(Integer id) {
        Post post = postMapper.getPostById(id);
        return post;
    }

    @Override
    public Integer postCount() {
        return postMapper.postCount();
    }

    @Override
    public List<Post> getAllPosts() {
        return postMapper.getAllPosts();
    }

    @Override
    public void update(Post post) {

        post.setUpdatedAt(LocalDateTime.now());

        postMapper.update(post);
    }

    @Override
    public void delete(Integer id) {
        postMapper.delete(id);
    }

    /**
     * 条件查询
     * @param postQueryRequest
     * @return
     */
    @Override
    public PostPageBean query(PostQueryRequest postQueryRequest) {

        List<Post> postList = postMapper.queryPosts(postQueryRequest);
        Integer total = postList.size();
        PostPageBean postPageBean = new PostPageBean(total,postList);

        return postPageBean;
    }
}
