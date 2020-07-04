package csa.stu.app.single.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import csa.stu.app.common.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> selectTable(Map<String, Object> map);

    Comment selectWithUserById(String id);
}