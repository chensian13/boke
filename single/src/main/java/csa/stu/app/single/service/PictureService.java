package csa.stu.app.single.service;

import csa.stu.app.common.entity.Picture;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.pojo.ResultPojo;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService extends IService<Picture> {

    public ResultPojo<Picture> uploadOne(MultipartFile file, Picture picture);
}
