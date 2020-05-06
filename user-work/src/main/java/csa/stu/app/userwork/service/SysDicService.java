package csa.stu.app.userwork.service;

import csa.stu.app.common.entity.SysDic;
import csa.stu.app.common.entity.TreeNode;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.myutils.pojo.ResultPojo;

public interface SysDicService extends IService<SysDic> {

	public  ResultPojo<TreeNode> getTree(String parentId,String userId);

	public ResultPojo<SysDic> getBokeTypes(String userId);


}
