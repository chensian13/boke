package csa.stu.app.userwork.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import csa.stu.app.common.constent.GenerateCode;
import csa.stu.app.common.entity.Boke;
import csa.stu.app.common.util.InfoUtil;
import csa.stu.app.userwork.dao.BokeMapper;
import csa.stu.app.userwork.service.BokeService;
import csa.stu.util.ap.mvc.helper.ServiceHelper;
import csa.stu.util.ap.pojo.ParamPojo;
import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.myutils.direct.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


@Service("bokeService")
public class BokeServiceImpl implements BokeService {
    @Autowired
    private BokeMapper bokeMapper;

    /**
     *  id前端生产
     * @param boke
     * @return
     */
    @Override
    @Transactional
    public ResultPojo<Boke> addOne(Boke boke) {
        ResultPojo<Boke> rs=new ResultPojo<Boke>();
        if(EmptyUtil.isEmpty(boke.getCreater())){
            rs.setCode(ResultPojo.NO);
            rs.setMessage("获取登录信息失败，请重新登录");
            return rs;
        }
        boke.setBokeCode(ServiceHelper.generateCode(GenerateCode.BOKE));
        boke.initDefault();
        boke.setBokeId(ServiceHelper.generateUUID32());
        boke.setVersion("0");
        boke.setState("0");
        //提取图片
        boke.setCover(InfoUtil.getFirstImgSrc(boke.getInfo()));
        bokeMapper.insert(boke);
        rs=ResultPojo.newInstance(bokeMapper.selectById(boke.getBokeId()));
        return rs;
    }

    @Override
    @Transactional
    public ResultPojo<Boke> updOne(Boke boke) {
        boke.setModtime(System.currentTimeMillis());
        //提取图片
        boke.setCover(InfoUtil.getFirstImgSrc(boke.getInfo()));
        bokeMapper.updateById(boke);
        return ResultPojo.newInstance(bokeMapper.selectById(boke.getBokeId()));
    }

    @Transactional
    @Override
    public ResultPojo<Boke> delOne(Boke boke) {
        ResultPojo<Boke> rs=new ResultPojo<Boke>();
        bokeMapper.deleteById(boke.getBokeId());
        rs.setCode(ResultPojo.OK);
        return rs;
    }

    @Override
    public ResultPojo<Boke> stopOne(Boke boke) {
        ResultPojo<Boke> rs=new ResultPojo<Boke>();
        Boke boking=new Boke();
        boking.setBokeId(boke.getBokeId());
        boking.setIsdel("1");
        bokeMapper.updateById(boking);
        rs.setCode(ResultPojo.OK);
        return rs;
    }

    @Override
    public ResultPojo<Boke> submitOne(Boke boke) {
        return null;
    }

    @Override
    public ResultPojo<Boke> selectById(String id) {
        ResultPojo<Boke> rs=new ResultPojo<Boke>();
        rs=ResultPojo.newInstance(bokeMapper.selectById(id));
        return rs;
    }

    /**
     * 关联查询：
     * 1）博客类型
     * @param paramWrap
     * @return
     */
    @Override
    public ResultPojo<Boke> selectData(ParamPojo paramWrap) {
        ResultPojo<Boke> rs=new ResultPojo<Boke>();
        //条件封装
        Map<String,Object> map=new HashMap<String,Object>(1);
        ParamPojo.wrapParams(paramWrap, entry->{
            if(entry.getKey().equals("bokeTitle")){
                map.put("bokeTitle",entry.getValue());
            }else if(entry.getKey().equals("isdel")){
                map.put("isdel",entry.getValue());
            }else if(entry.getKey().equals("bokeType")){
                map.put("bokeType",entry.getValue());
            }else if(entry.getKey().equals("ispublic")){
                map.put("ispublic",entry.getValue());
            }else if(entry.getKey().equals("creater")){
                map.put("creater",entry.getValue());
            }
        });
        //校验作者id
        if(EmptyUtil.isEmptys(map.get("creater"))){
            return ResultPojo.newInstance(ResultPojo.NO,"作者id不存在");
        }
        //分页
        ServiceHelper.page(paramWrap,(p,s)->{
            PageHelper.startPage(p,s);
        });
        rs.setList(bokeMapper.selectTable(map));
        PageInfo<Boke> pageInfo=new PageInfo<Boke>(rs.getList());
        rs.setCount(pageInfo.getTotal());
        rs.setCode(ResultPojo.OK);
        return rs;
    }

    @Override
    public ResultPojo<Boke> selectSimpleData(ParamPojo paramWrap) {
        return null;
    }


    //************************************校验*********************************
    @Override
    public boolean checkUniqueField(Boke data, ResultPojo<Boke> rs, String oper) {
        return true;
    }



}
