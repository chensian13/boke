package csa.stu.app.single.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import csa.stu.app.common.constent.GenerateCode;
import csa.stu.app.common.entity.Special;
import csa.stu.app.single.dao.SpecialMapper;
import csa.stu.app.single.service.SpecialService;
import csa.stu.util.ap.mvc.helper.ServiceHelper;
import csa.stu.util.ap.pojo.ParamPojo;
import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.myutils.direct.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service("specialService")
public class SpecialServiceImpl implements SpecialService {
    @Autowired
    private SpecialMapper specialMapper;


    /**
     *  id前端生产
     * @param special
     * @return
     */
    @Override
    @Transactional
    public ResultPojo<Special> addOne(Special special) {
        ResultPojo<Special> rs=new ResultPojo<Special>();
        special.setSpecialCode(ServiceHelper.generateCode(GenerateCode.SPECIAL));
        special.initDefault();
        special.setSpecialId(ServiceHelper.generateUUID32());
        specialMapper.insert(special);
        rs=ResultPojo.newInstance(specialMapper.selectById(special.getSpecialId()));
        return rs;
    }

    @Override
    @Transactional
    public ResultPojo<Special> updOne(Special special) {
        special.setModtime(System.currentTimeMillis());
        specialMapper.updateById(special);
        return ResultPojo.newInstance(specialMapper.selectById(special.getSpecialId()));
    }

    @Transactional
    @Override
    public ResultPojo<Special> delOne(Special special) {
        ResultPojo<Special> rs=new ResultPojo<Special>();
        specialMapper.deleteById(special.getSpecialId());
        rs.setCode(ResultPojo.OK);
        return rs;
    }

    @Override
    public ResultPojo<Special> stopOne(Special special) {
        ResultPojo<Special> rs=new ResultPojo<Special>();
        Special speaciling=new Special();
        speaciling.setSpecialId(special.getSpecialId());
        speaciling.setIsdel("1");
        specialMapper.updateById(speaciling);
        rs.setCode(ResultPojo.OK);
        return rs;
    }

    @Override
    public ResultPojo<Special> submitOne(Special special) {
        return null;
    }

    @Override
    public ResultPojo<Special> selectById(String id) {
        ResultPojo<Special> rs=new ResultPojo<Special>();
        rs=ResultPojo.newInstance(specialMapper.selectById(id));
        return rs;
    }

    /**
     * 关联查询：
     * 1）博客类型
     * @param paramWrap
     * @return
     */
    @Override
    public ResultPojo<Special> selectData(ParamPojo paramWrap) {
        ResultPojo<Special> rs=new ResultPojo<Special>();
        //条件封装
        Map<String,Object> map=new HashMap<String,Object>(1);
        ParamPojo.wrapParams(paramWrap, entry->{
            if(entry.getKey().equals("specialName")){
                map.put("specialName",entry.getValue());
            }else if(entry.getKey().equals("isdel")){
                map.put("isdel",entry.getValue());
            }else if(entry.getKey().equals("creater")){
                map.put("creater",entry.getValue());
            }
        });
        //校验作者id
        if(EmptyUtil.isEmptys(map.get("creater"))){
            return ResultPojo.newInstance(ResultPojo.NO,"作者id不存在");
        }
        //判断是否分页
        //分页
        ServiceHelper.page(paramWrap,(p,s)->{
            PageHelper.startPage(p,s);
        });
        rs.setList(specialMapper.selectTable(map));
        PageInfo<Special> pageInfo=new PageInfo<Special>(rs.getList());
        rs.setCount(pageInfo.getTotal());
        rs.setCode(ResultPojo.OK);
        return rs;
    }

    @Override
    public ResultPojo<Special> selectSimpleData(ParamPojo paramWrap) {
        return null;
    }


    //************************************校验*********************************
    @Override
    public boolean checkUniqueField(Special data, ResultPojo<Special> rs, String oper) {
        return true;
    }



}
