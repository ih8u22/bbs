package me.bbs.mapper;

import me.bbs.pojo.Post;
import me.bbs.pojo.PostQueryRequest;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO post (title, content, authorId, categoryId, createdAt, updatedAt, viewsCount, status)" +
            "VALUES ( #{title}, #{content}, #{authorId}, #{categoryId}, #{createdAt}, #{updatedAt}, #{viewsCount}, #{status} )")
    void createPost(Post post);

    @Select("SELECT * FROM post WHERE id = #{id}")
    Post getPostById(Integer id);

    /**
     * 查询帖子总数
     * @return
     */
    @Select("SELECT COUNT(*) FROM post")
    Integer postCount();

    /**
     * 查询全部帖子
     * @return
     */
    @Select("SELECT * FROM post")
    List<Post> getAllPosts();

    /**
     * 更新帖子信息
     * @param post
     */
    void update(Post post);

    @Delete(" DELETE FROM post WHERE id = #{id}")
    void delete(Integer id);

    List<Post> queryPosts(PostQueryRequest request);
}
