package csa.stu.app.front.controller;

import csa.stu.app.common.entity.Picture;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.app.front.feign.UserWorkService;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @author csa
 */
@RequestMapping("/picture")
@Controller
public class PictureController {
    @Autowired
    private UserWorkService userWorkService;
    @Autowired
    private UserinfoUtil userinfoUtil;

    @ResponseBody
    @RequestMapping("/data/del")
    public ResultPojo<Picture> delOne(@RequestBody Picture entity, HttpServletRequest request){
        return userWorkService.delPictureOne(entity);
    }

    @RequestMapping({"/queryData"})
    @ResponseBody
    public ResultPojo<Picture> queryData(@RequestBody ParamPojo paramPojo) {
        return userWorkService.queryPictureData(paramPojo);
    }






}
