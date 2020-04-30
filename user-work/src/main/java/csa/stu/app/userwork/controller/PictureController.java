package csa.stu.app.userwork.controller;

import csa.stu.app.common.entity.Picture;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.app.userwork.service.PictureService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author  csa
 */
@Controller
@RequestMapping("/picture")
public class PictureController extends MyController<Picture> {
    @Autowired
    private PictureService pictureService;

    @Override
    public IService<Picture> getService() {
        return pictureService;
    }

    @ResponseBody
    @RequestMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultPojo<Picture> uploadOne(@RequestPart("upload") MultipartFile file
            , @RequestParam(name="userCode") String userCode
            , @RequestParam(name="userId") String userId
            , HttpServletRequest request){
        Picture picture=new Picture();
        picture.setUserCode(userCode);
        picture.setCreater(userId);
        return pictureService.uploadOne(file,picture);
    }

}
