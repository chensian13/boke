package csa.stu.app.userwork.controller;

import csa.stu.app.common.entity.Comment;
import csa.stu.app.single.service.CommentService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 博客信息控制层
 *
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends MyController<Comment> {
    @Autowired
    private CommentService commentService;

    @Override
    public IService<Comment> getService() {
        return commentService;
    }
}
