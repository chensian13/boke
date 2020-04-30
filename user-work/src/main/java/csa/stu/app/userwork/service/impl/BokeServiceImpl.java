package csa.stu.app.userwork.service.impl;

import com.github.pagehelper.PageInfo;
import csa.stu.app.common.constent.GenerateCode;
import csa.stu.app.common.entity.Boke;
import csa.stu.app.userwork.dao.BokeMapper;
import csa.stu.app.userwork.service.BokeService;
import csa.stu.util.ap.mvc.helper.ServiceHelper;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.DateUtil;
import csa.stu.util.myutils.utils.EmptyUtil;
import csa.stu.util.myutils.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service("bokeServiceImpl")
public class BokeServiceImpl implements BokeService {
    @Autowired
    private BokeMapper bokeMapper;

    /**
     *
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
        boke.setBokeId(StrUtil.generateUUID32());
        boke.setBokeCode(StrUtil.generateCode(GenerateCode.BOKE));
        boke.initDefault();
        boke.setVersion("0");
        boke.setState("0");
        bokeMapper.insert(boke);
        rs=ResultPojo.newInstance(bokeMapper.selectById(boke.getBokeId()));
        return rs;
    }

    @Override
    @Transactional
    public ResultPojo<Boke> updOne(Boke boke) {
        ResultPojo<Boke> rs=new ResultPojo<Boke>();
        boke.setModtime(DateUtil.nowTime());
        {
            bokeMapper.updateById(boke);
            rs=ResultPojo.newInstance(bokeMapper.selectById(boke.getBokeId()));
        }
        return rs;
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
        ParamPojo.wrapParams(paramWrap,entry->{
            if(entry.getKey().equals("bokeTitle")){
                map.put("bokeTitle",entry.getValue());
            }else if(entry.getKey().equals("isdel")){
                map.put("isdel",entry.getValue());
            }
        });
        //判断是否分页
        ServiceHelper.canPage(paramWrap);
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
