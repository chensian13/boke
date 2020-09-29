package csa.stu.app.bk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import csa.stu.app.bk.dao.PictureMapper;
import csa.stu.app.bk.service.PictureService;
import csa.stu.app.common.constent.GenerateCode;
import csa.stu.app.common.entity.Picture;
import csa.stu.util.ap.mvc.helper.ServiceHelper;
import csa.stu.util.ap.pojo.ParamPojo;
import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.myutils.direct.FileUtil;
import csa.stu.util.myutils.exception.CsaplatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
        ParamPojo.wrapParams(wrap,entry->{
            if("creater".equals(entry.getKey())){
                queryWrapper.eq(entry.getKey(),entry.getValue());
            }
        });
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
        //封装图片数据
        picture.setPictureId(ServiceHelper.generateUUID32());
        picture.initDefault();
        picture.setPictureCode(ServiceHelper.generateCode(GenerateCode.PICTURE));
        try {
            picture.setSuffix(FileUtil.getSuffix(file.getOriginalFilename()));
        } catch (CsaplatException e) {
            throw new RuntimeException(e);
        }
        //数据库保存路径
        String path= generateDirPath();
        String imgPath = generateFilePath(path,picture.getSuffix());
        picture.setPath(imgPath);
        FileUtil.createDirs(filepath +path); //创建目录
        try{
            //上传图片文件
            file.transferTo(new File(filepath +imgPath));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        //保存数据库
        pictureMapper.insert(picture);
        return ResultPojo.newInstance(picture);
    }

    private String generateDirPath(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        StringBuilder sb=new StringBuilder();
        sb.append(File.separator);
        sb.append(calendar.get(Calendar.YEAR));
        sb.append(calendar.get(Calendar.MONTH));
        sb.append(calendar.get(Calendar.DAY_OF_MONTH));
        return sb.toString();
    }

    private String generateFilePath(String path,String suffix){
        StringBuilder sb=new StringBuilder(path);
        sb.append(File.separator);
        sb.append(ServiceHelper.generateTimestampID());
        sb.append(".");
        sb.append(suffix);
        return sb.toString();
    }

}
