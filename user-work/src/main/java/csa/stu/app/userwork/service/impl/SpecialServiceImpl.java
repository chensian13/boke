package csa.stu.app.userwork.service.impl;

import com.github.pagehelper.PageInfo;
import csa.stu.app.common.constent.GenerateCode;
import csa.stu.app.common.entity.Special;
import csa.stu.app.userwork.dao.SpecialMapper;
import csa.stu.app.userwork.service.SpecialService;
import csa.stu.util.ap.mvc.helper.ServiceHelper;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("specialServiceImpl")
public class SpecialServiceImpl implements SpecialService {
    @Autowired
    private SpecialMapper specialMapper;

    @Override
    @Transactional
    public ResultPojo<Special> addOne(Special special) {
        ResultPojo<Special> rs=new ResultPojo<Special>();
        special.setSpecialId(StrUtil.generateUUID32());
        special.initDefault();
        special.setIspublic("1");
        special.setSpecialCode(StrUtil.generateCode(GenerateCode.SPECIAL));
        //插入操作
        specialMapper.insert(special);
        ResultPojo.newInstance(specialMapper.selectById(special.getSpecialId()));
        return rs;
    }

    @Override
    @Transactional
    public ResultPojo<Special> updOne(Special special) {
        ResultPojo<Special> rs=new ResultPojo<Special>();
        //执行修改
        specialMapper.updateById(special);
        ResultPojo.newInstance(specialMapper.selectById(special.getSpecialId()));
        return rs;
    }

    @Override
    public ResultPojo<Special> delOne(Special special) {
        ResultPojo<Special> rs=new ResultPojo<Special>();
        Special specialing=new Special();
        //删除只是依据id改变记录的状态
        specialing.setSpecialId(special.getSpecialId());
        specialing.setIsdel("1");
        specialMapper.updateById(specialing);
        rs.setCode(ResultPojo.OK);
        return rs;
    }

    @Override
    public ResultPojo<Special> stopOne(Special special) {
        return null;
    }

    @Override
    public ResultPojo<Special> submitOne(Special special) {
        return null;
    }

    @Override
    public ResultPojo<Special> selectById(String id) {
        ResultPojo<Special> rs=new ResultPojo<Special>();
        ResultPojo.newInstance(specialMapper.selectById(id));
        return rs;
    }

    /**
     * 复杂查询
     * 关联显示字段：
     * @param paramWrap
     * @return
     */
    @Override
    public ResultPojo<Special> selectData(ParamPojo paramWrap) {
        ResultPojo<Special> rs=new ResultPojo<Special>();
       //是否分页
        ServiceHelper.canPage(paramWrap);
        //查询数据
        Map<String,Object> map=new HashMap<String,Object>(2);
        ParamPojo.wrapParams(paramWrap,entry->{
            if(entry.getKey().equals("specialName")){
                map.put("specialName",paramWrap.getMap().get("specialName"));
            }
        });
        List<Special> list=specialMapper.selectTable(map);
        PageInfo<Special> pageInfo = new PageInfo<Special>(list);
        rs.setList(list);
        rs.setCount(pageInfo.getTotal());
        rs.setCode(ResultPojo.OK);
        return rs;
    }

    @Override
    public ResultPojo<Special> selectSimpleData(ParamPojo paramWrap) {
        ResultPojo<Special> rs=new ResultPojo<Special>();
        //是否分页
        ServiceHelper.canPage(paramWrap);
        Map<String,Object> map=new HashMap<String,Object>(2);
        ParamPojo.wrapParams(paramWrap,entry->{
            if(entry.getKey().equals("specialName")){
                map.put("specialName",paramWrap.getMap().get("specialName"));
            }
        });
        //查询数据
        List<Special> list=specialMapper.selectSimpleTable(map);
        PageInfo<Special> pageInfo = new PageInfo<Special>(list);
        rs.setList(list);
        rs.setCount(pageInfo.getTotal());
        rs.setCode(ResultPojo.OK);
        return rs;
    }

    @Override
    public boolean checkUniqueField(Special data, ResultPojo<Special> rs, String oper) {
        return false;
    }


}
