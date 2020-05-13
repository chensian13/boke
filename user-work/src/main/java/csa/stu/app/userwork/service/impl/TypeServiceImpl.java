package csa.stu.app.userwork.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import csa.stu.app.common.annotation.Resubmit;
import csa.stu.app.common.constent.GenerateCode;
import csa.stu.app.common.entity.Type;
import csa.stu.app.common.entity.User;
import csa.stu.app.userwork.dao.TypeMapper;
import csa.stu.app.userwork.dao.UserMapper;
import csa.stu.app.userwork.service.TypeService;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
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

	@Override
	public ResultPojo<Type> selectData(ParamPojo param) {
		Map<String,String> map=new HashMap<>();
		QueryWrapper<Type> queryWrapper=new QueryWrapper<>();
		queryWrapper.orderByAsc("seq");
		User user=new User();
		ParamPojo.wrapParams(param,entry->{
			if(entry.getKey().equals("creater")){
				user.setUserId(entry.getValue().toString());
			}else if(entry.getKey().equals("userCode")){
				QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
				userQueryWrapper.eq("user_code",entry.getValue());
				User user2=userMapper.selectOne(userQueryWrapper);
				if(user2!=null)
					user.setUserId(user2.getUserId());
			}
		});
		if(EmptyUtil.isEmptys(user.getUserId()))
			return ResultPojo.newInstance(ResultPojo.NO,"获取作者信息失败");
		queryWrapper.eq("creater",user.getUserId());
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

	@Transactional
	@Override
	@Resubmit
	public ResultPojo<Type> updOne(Type type) {
		ResultPojo<Type> rp=ResultPojo.newInstance();
		int i=typeMapper.updateById(type);
		rp.setCode(ResultPojo.OK);
		rp.setModel(typeMapper.selectById(type.getTypeId()));
		return rp;
	}

	@Transactional
	@Override
	public ResultPojo<Type> delOne(Type type) {
		ResultPojo<Type> rp=ResultPojo.newInstance();
		typeMapper.deleteById(type.getTypeId());
		rp.setCode(ResultPojo.OK);
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
