package csa.stu.app.userwork.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import csa.stu.app.common.annotation.RedisCache;
import csa.stu.app.common.annotation.Resubmit;
import csa.stu.app.common.constent.GenerateCode;
import csa.stu.app.common.entity.Type;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.RedisUtil;
import csa.stu.app.userwork.dao.TypeMapper;
import csa.stu.app.userwork.dao.UserMapper;
import csa.stu.app.userwork.service.TypeService;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import csa.stu.util.myutils.utils.JSONUtil;
import csa.stu.util.myutils.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service("TypeService")
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeMapper typeMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RedisUtil redisUtil;
	private final String tag="boke_type";

	@Transactional
	@Override
	@Resubmit
	public ResultPojo<Type> addOne(Type type) {
		type.setTypeId(StrUtil.generateUUID32());
		type.setTypeCode(StrUtil.generateCode(GenerateCode.TYPE));
		type.initDefault();
		typeMapper.insert(type);
		ResultPojo<Type> rp=ResultPojo.newInstance();
		rp.setModel(typeMapper.selectById(type.getTypeId()));
		rp.setCode(ResultPojo.OK);
		return rp;
	}

	@RedisCache(key = tag)
	@Override
	public ResultPojo<Type> selectData(String creater,ParamPojo param) {
		QueryWrapper<Type> queryWrapper=new QueryWrapper<>();
		queryWrapper.orderByAsc("seq");
		queryWrapper.eq("creater",creater);
		return ResultPojo.newInstance(typeMapper.selectList(queryWrapper),0);
	}

	@Override
	public ResultPojo<Type> selectSimpleData(ParamPojo wrap) {
		return null;
	}

	@Override
	public boolean checkUniqueField(Type data, ResultPojo<Type> rs, String oper) {
		return false;
	}



	@Override
	public ResultPojo<Type> selectById(String id) {
		ResultPojo<Type> rp=ResultPojo.newInstance();
		rp.setModel(typeMapper.selectById(id));
		rp.setCode(ResultPojo.OK);
		return rp;
	}

	@Override
	public ResultPojo<Type> selectData(ParamPojo wrap) {
		return null;
	}

	@Transactional
	@Override
	@Resubmit
	public ResultPojo<Type> updOne(Type type) {
		ResultPojo<Type> rp=ResultPojo.newInstance();
		int i=typeMapper.updateById(type);
		rp.setCode(ResultPojo.OK);
		rp.setModel(typeMapper.selectById(type.getTypeId()));
		redisUtil.del(tag+JSONUtil.formatJSON(type.getCreater()));
		return rp;
	}

	@Transactional
	@Override
	public ResultPojo<Type> delOne(Type type) {
		ResultPojo<Type> rp=ResultPojo.newInstance();
		typeMapper.deleteById(type.getTypeId());
		rp.setCode(ResultPojo.OK);
		redisUtil.del(tag+JSONUtil.formatJSON(type.getCreater()));
		return rp;
	}

	@Override
	public ResultPojo<Type> stopOne(Type Type) {
		return null;
	}

	@Override
	public ResultPojo<Type> submitOne(Type Type) {
		return null;
	}

}
