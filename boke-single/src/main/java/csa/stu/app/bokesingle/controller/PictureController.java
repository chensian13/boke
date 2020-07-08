package csa.stu.app.bokesingle.controller;

import csa.stu.app.common.cache.LoginCacher;
import csa.stu.app.common.entity.Picture;
import csa.stu.app.common.entity.User;
import csa.stu.app.single.controller.MyControllerPlus;
import csa.stu.app.single.service.PictureService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.InputStream;

/**
 * @author  csa
 */
@Controller
@RequestMapping("/picture")
public class PictureController extends MyControllerPlus<Picture> {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private LoginCacher loginCacher;

    @Override
    public IService<Picture> getService() {
        return pictureService;
    }

    @ResponseBody
    @RequestMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultPojo<String> uploadOne(@RequestPart("upload") MultipartFile file
            ,@RequestParam(value = "bokeId",required = false) String bokeId
            , HttpServletRequest request){
        User user=loginCacher.get(request);
        if(user==null){
            return noLogin();
        }
        if(!isPicture(file)){
            return ResultPojo.newInstance(ResultPojo.NO,"图片格式不合法");
        }
        Picture picture=new Picture();
        picture.setCreater(user.getUserId());
        picture.setTableId(bokeId);
        ResultPojo<Picture> rs= pictureService.uploadOne(file,picture);
        if(rs==null || rs.getModel()==null) return ResultPojo.newInstance(ResultPojo.NO,null);
        return ResultPojo.newInstance(rs.getModel().getHttpPath());
    }


    /**
     * 校验是否为图片
     * @return
     */
    private boolean isPicture(MultipartFile file){
        try {
            InputStream in=file.getInputStream();
            BufferedImage bufferedImage= ImageIO.read(in);
            if(bufferedImage.getHeight()==0
                    || bufferedImage.getWidth()==0){
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    @Override
    public User getLoginUser(HttpServletRequest request) {
        return loginCacher.get(request);
    }
}
