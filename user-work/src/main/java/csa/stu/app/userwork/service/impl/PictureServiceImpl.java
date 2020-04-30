package csa.stu.app.userwork.service.impl;

import csa.stu.app.common.constent.GenerateCode;
import csa.stu.app.common.entity.Picture;
import csa.stu.app.userwork.dao.PictureMapper;
import csa.stu.app.userwork.service.PictureService;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import csa.stu.util.myutils.utils.FileUtil;
import csa.stu.util.myutils.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureMapper pictureMapper;
    @Value("${csa.filepath}")
    private String filepath;


    @Override
    public ResultPojo<Picture> addOne(Picture picture) {
        return null;
    }

    @Override
    public ResultPojo<Picture> updOne(Picture picture) {
        return null;
    }

    @Override
    public ResultPojo<Picture> delOne(Picture picture) {
        return null;
    }

    @Override
    public ResultPojo<Picture> stopOne(Picture picture) {
        return null;
    }

    @Override
    public ResultPojo<Picture> submitOne(Picture picture) {
        return null;
    }

    @Override
    public ResultPojo<Picture> selectById(String id) {
        return null;
    }

    @Override
    public ResultPojo<Picture> selectData(ParamPojo wrap) {
        return null;
    }

    @Override
    public ResultPojo<Picture> selectSimpleData(ParamPojo wrap) {
        return null;
    }

    @Override
    public boolean checkUniqueField(Picture data, ResultPojo<Picture> rs, String oper) {
        return false;
    }

    @Transactional
    @Override
    public ResultPojo<Picture> uploadOne(MultipartFile file, Picture picture) {
        if(EmptyUtil.isEmpty(picture.getUserCode())){
            return ResultPojo.newInstance(ResultPojo.NO,"没有用户信息");
        }
        //封装图片数据
        picture.setPictureId(StrUtil.generateUUID32());
        picture.initDefault();
        picture.setPictureCode(StrUtil.generateCode(GenerateCode.PICTURE));
        picture.setSuffix(FileUtil.getSuffix(file.getOriginalFilename()));
        picture.setPictureName(file.getOriginalFilename());
        //数据库保存路径
        String path= picture.getUserCode()
                +"/"
                +picture.getPictureId()
                +"."
                +picture.getSuffix();
        picture.setPath(path);
        FileUtil.createDirs(filepath +File.separator+path); //创建目录
        try{
            //上传图片文件
            file.transferTo(new File(filepath +File.separator+path));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        //保存数据库
        pictureMapper.insert(picture);
        return ResultPojo.newInstance(picture);
    }
}
