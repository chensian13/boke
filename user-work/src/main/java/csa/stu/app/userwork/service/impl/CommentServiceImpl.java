package csa.stu.app.userwork.service.impl;

import com.github.pagehelper.PageInfo;
import csa.stu.app.common.entity.Comment;
import csa.stu.app.userwork.constant.CommentTargetType;
import csa.stu.app.userwork.dao.CommentMapper;
import csa.stu.app.userwork.service.CommentService;
import csa.stu.util.ap.mvc.helper.ServiceHelper;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;


    @Transactional
    @Override
    public ResultPojo<Comment> addOne(Comment comment) {
        comment.setCommentId(StrUtil.generateUUID32());
        comment.initDefault();
        commentMapper.insert(comment);
        return ResultPojo.newInstance(commentMapper.selectWithUserById(comment.getCommentId()));
    }

    @Override
    public ResultPojo<Comment> updOne(Comment comment) {
        return null;
    }

    @Transactional
    @Override
    public ResultPojo<Comment> delOne(Comment comment) {
        commentMapper.deleteById(comment.getCommentId());
        if(CommentTargetType.COMMENT.equals(comment.getTargetType()))
            commentMapper.deleteById(comment.getTarget());
        return ResultPojo.newInstance(ResultPojo.OK,null);
    }

    @Override
    public ResultPojo<Comment> stopOne(Comment comment) {
        return null;
    }

    @Override
    public ResultPojo<Comment> submitOne(Comment comment) {
        return null;
    }

    @Override
    public ResultPojo<Comment> selectById(String id) {
        ResultPojo<Comment> rs=new ResultPojo<Comment>();
        rs=ResultPojo.newInstance(commentMapper.selectWithUserById(id));
        return rs;
    }

    /**
     * 关联查询：
     * 1）博客类型
     * @param paramWrap
     * @return
     */
    @Override
    public ResultPojo<Comment> selectData(ParamPojo paramWrap) {
        ResultPojo<Comment> rs=new ResultPojo<Comment>();
        //条件封装
        Map<String,Object> map=new HashMap<String,Object>(1);
        ParamPojo.wrapParams(paramWrap,entry->{
            if(entry.getKey().equals("bokeTitle")){
                map.put("bokeTitle",entry.getValue());
            }else if(entry.getKey().equals("isdel")){
                map.put("isdel",entry.getValue());
            }
        });
        //判断是否分页
        ServiceHelper.canPage(paramWrap);
        rs.setList(commentMapper.selectTable(map));
        PageInfo<Comment> pageInfo=new PageInfo<Comment>(rs.getList());
        rs.setCount(pageInfo.getTotal());
        rs.setCode(ResultPojo.OK);
        return rs;
    }

    @Override
    public ResultPojo<Comment> selectSimpleData(ParamPojo wrap) {
        return null;
    }

    @Override
    public boolean checkUniqueField(Comment data, ResultPojo<Comment> rs, String oper) {
        return false;
    }


}
