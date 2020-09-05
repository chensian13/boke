package csa.stu.app.single.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import csa.stu.app.common.constent.GenerateCode;
import csa.stu.app.common.entity.Picture;
import csa.stu.app.single.dao.PictureMapper;
import csa.stu.app.single.service.PictureService;
import csa.stu.util.ap.mvc.helper.ServiceHelper;
import csa.stu.util.ap.pojo.ParamPojo;
import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.myutils.direct.EmptyUtil;
import csa.stu.util.myutils.direct.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.List;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureMapper pictureMapper;
    @Value("${csa.filepath:C://base//boke//}")
    private String filepath;


    @Override
    public ResultPojo<Picture> addOne(Picture picture) {
        return null;
    }

    @Override
    public ResultPojo<Picture> updOne(Picture picture) {
        return null;
    }

    @Transactional
    @Override
    public ResultPojo<Picture> delOne(Picture picture) {
        Picture pic=pictureMapper.selectById(picture.getPictureId());
        String path=filepath+File.separator+pic.getPath();
        FileUtil.deleteFile(path); //删除文件系统
        pictureMapper.deleteById(pic.getPictureId());
        return ResultPojo.newInstance(ResultPojo.OK,null);
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
        //分页
        ServiceHelper.page(wrap,(p,s)->{
            PageHelper.startPage(p,s);
        });
        QueryWrapper<Picture> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("createtime");
        queryWrapper.eq("creater",wrap.getMap().get("creater"));
        List<Picture> pictureList=pictureMapper.selectList(queryWrapper);
        PageInfo<Picture> pageInfo=new PageInfo<>(pictureList);
        for(Picture picture:pictureList){
            picture.setHttpPath(picture.getHttpPath());
        }
        return ResultPojo.newInstance(pictureList,pageInfo.getTotal());
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
        if(EmptyUtil.isEmpty(picture.getCreater())){
            return ResultPojo.newInstance(ResultPojo.NO,"没有用户信息");
        }
        //封装图片数据
        picture.setPictureId(ServiceHelper.generateUUID32());
        picture.initDefault();
        picture.setPictureCode(ServiceHelper.generateCode(GenerateCode.PICTURE));
        picture.setSuffix(FileUtil.getSuffix(file.getOriginalFilename()));
        //数据库保存路径
        String path= picture.getCreater()
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
