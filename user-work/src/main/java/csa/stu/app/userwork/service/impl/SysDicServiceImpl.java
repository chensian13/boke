package csa.stu.app.userwork.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import csa.stu.app.common.entity.SysDic;
import csa.stu.app.common.entity.TreeNode;
import csa.stu.app.userwork.dao.SysDicMapper;
import csa.stu.app.userwork.service.SysDicService;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import csa.stu.util.myutils.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("sysDicService")
public class SysDicServiceImpl implements SysDicService {
	@Autowired
	private SysDicMapper sysDicMapper;

	@Transactional
	@Override
	public ResultPojo<SysDic> addOne(SysDic sysDic) {
		sysDic.setDicId(StrUtil.generateUUID32());
		sysDic.initDefault();

		QueryWrapper<SysDic> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("dic_code",sysDic.getDicCode());
		if(sysDicMapper.selectCount(queryWrapper)>0){
			return ResultPojo.newInstance(ResultPojo.NO,"数据字典值重复");
		}

		sysDicMapper.insert(sysDic);
		ResultPojo<SysDic> rp=ResultPojo.newInstance();
		rp.setModel(sysDicMapper.selectWithParentById(sysDic.getDicId()));
		rp.setCode(ResultPojo.OK);
		return rp;
	}

	@Override
	public ResultPojo<SysDic> selectData(ParamPojo param) {
		return null;
	}

	@Override
	public ResultPojo<SysDic> selectSimpleData(ParamPojo wrap) {
		return null;
	}

	@Override
	public boolean checkUniqueField(SysDic data, ResultPojo<SysDic> rs, String oper) {
		return false;
	}

	@Override
	public ResultPojo<TreeNode> getTree(String parentId) {
		ResultPojo<TreeNode> rp=ResultPojo.newInstance();
		List<SysDic> dics=sysDicMapper.selectByParent(parentId);
		if(!EmptyUtil.isEmpty(dics)){
			List<TreeNode> treeNodes=new ArrayList<>();
			TreeNode treeNode=null;
			for(SysDic dic:dics){
				treeNode=new TreeNode();
				treeNode.setId(dic.getDicId());
				treeNode.setParentId(dic.getParentId());
				treeNode.setName(dic.getDicName());
				treeNode.setInfo(dic.getInfo());
				treeNode.setCode(dic.getDicCode());
				treeNode.setParent(dic.getParent());
				treeNodes.add(treeNode);
			}
			rp.setList(treeNodes);
		}
		rp.setCode(ResultPojo.OK);
		return rp;
	}

	@Override
	public ResultPojo<SysDic> getBokeTypes() {
		QueryWrapper<SysDic> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("dic_code","boke_type");
		SysDic dic=sysDicMapper.selectOne(queryWrapper);
		if(dic==null){
			return ResultPojo.newInstance(ResultPojo.NO,null);
		}
		QueryWrapper<SysDic> queryWrapper2=new QueryWrapper<>();
		queryWrapper2.eq("parent_id",dic.getDicId());
		return ResultPojo.newInstance(sysDicMapper.selectList(queryWrapper2),0);
	}

	@Override
	public ResultPojo<SysDic> selectById(String id) {
		ResultPojo<SysDic> rp=ResultPojo.newInstance();
		rp.setModel(sysDicMapper.selectById(id));
		rp.setCode(ResultPojo.OK);
		return rp;
	}

	@Transactional
	@Override
	public ResultPojo<SysDic> updOne(SysDic sysDic) {
		ResultPojo<SysDic> rp=ResultPojo.newInstance();
		int i=sysDicMapper.updateById(sysDic);
		rp.setCode(ResultPojo.OK);
		rp.setModel(sysDicMapper.selectWithParentById(sysDic.getDicId()));
		return rp;
	}

	@Transactional
	@Override
	public ResultPojo<SysDic> delOne(SysDic sysDic) {
		ResultPojo<SysDic> rp=ResultPojo.newInstance();
		QueryWrapper<SysDic> wrapper=null;
		//是否有子节点
		wrapper=new QueryWrapper<SysDic>();
		wrapper.eq("parent_id", sysDic.getDicId());
		if(sysDicMapper.selectCount(wrapper)>0){
			rp.setCode(ResultPojo.NO);
			rp.setMessage("该字典具备子节点");
			return rp;
		}
		sysDicMapper.deleteById(sysDic.getDicId());
		rp.setCode(ResultPojo.OK);
		return rp;
	}

	@Override
	public ResultPojo<SysDic> stopOne(SysDic sysDic) {
		return null;
	}

	@Override
	public ResultPojo<SysDic> submitOne(SysDic sysDic) {
		return null;
	}

}
