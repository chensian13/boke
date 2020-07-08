package csa.stu.app.userwork.controller;

import csa.stu.app.common.entity.Picture;
import csa.stu.app.single.service.PictureService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
            , @RequestParam(name="userId") String userId
            ,@RequestParam(value = "bokeId",required = false) String bokeId
            , HttpServletRequest request){
        if(!isPicture(file)){
            return ResultPojo.newInstance(ResultPojo.NO,"图片格式不合法");
        }
        Picture picture=new Picture();
        picture.setCreater(userId);
        picture.setTableId(bokeId);
        return pictureService.uploadOne(file,picture);
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

}
