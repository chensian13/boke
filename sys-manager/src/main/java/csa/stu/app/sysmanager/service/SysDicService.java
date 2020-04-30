package csa.stu.app.sysmanager.service;

import csa.stu.app.common.entity.SysDic;
import csa.stu.app.common.entity.TreeNode;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.myutils.pojo.ResultPojo;

public interface SysDicService extends IService<SysDic> {

	public ResultPojo<TreeNode> getTree(String parentId);

	public ResultPojo<SysDic> getBokeTypes();


}
