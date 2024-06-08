package me.bbs.mapper;

import me.bbs.pojo.Reply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ReplyMapper {

    @Insert("INSERT INTO reply (postId, userId, content, createdAt, likeCount)" +
            " VALUES (#{postId}, #{userId}, #{content}, #{createdAt}, #{likeCount})")
    void createReply(Reply reply);

    @Select("SELECT COUNT(*) FROM reply WHERE postId = #{postId}")
    Integer count(Integer postId);

    @Select("SELECT * FROM reply WHERE postId = #{postId}")
    List<Reply> getReply(Integer postId);

    @Delete(("DELETE FROM reply WHERE id = #{replyId}"))
    void delete(Integer replyId);
}
