package csa.stu.app.front.controller;

import csa.stu.app.common.entity.Picture;
import csa.stu.app.common.entity.User;
import csa.stu.app.front.component.RestUserInfo;
import csa.stu.app.front.feign.UserWorkService;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author csa
 */
@RequestMapping("/picture")
@Controller
public class PictureController {
    @Autowired
    private UserWorkService userWorkService;
    @Autowired
    private RestUserInfo userinfoUtil;

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



    /**
     * 上传图片
     * @param funNum
     * @param file
     * @param response
     * @throws IOException
     */
    @RequestMapping("/upload")
    @ResponseBody
    public ResultPojo<String> uploadOne(@RequestPart("upload") MultipartFile file
            ,@RequestParam(value = "bokeId",required = false) String bokeId
            ,HttpServletRequest request
            , HttpServletResponse response)
            throws IOException {
        User user = userinfoUtil.getUser(request);
        if(EmptyUtil.isEmpty(user)){
            return ResultPojo.newInstance(ResultPojo.NO,"登录信息过期");
        }
        ResultPojo<Picture> rs= userWorkService.uploadOne(file,user.getUserId(),bokeId);
        if(rs==null || rs.getModel()==null) return ResultPojo.newInstance(ResultPojo.NO,null);;
        Picture picture=rs.getModel();
        return ResultPojo.newInstance(picture.getHttpPath());
    }


}
