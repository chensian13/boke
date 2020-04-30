package csa.stu.app.sysmanager.controller;

import csa.stu.app.common.entity.SysDic;
import csa.stu.app.common.entity.TreeNode;
import csa.stu.app.sysmanager.service.SysDicService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @author csa
 *
 */
@Controller
@RequestMapping("/dic")
public class SysDicController extends MyController<SysDic> {
	@Autowired
	private SysDicService sysDicService;
	
	@ResponseBody
	@RequestMapping("/getTree")
	public ResultPojo<TreeNode> getTree(@RequestParam(name="parentId",required = false) String parentId){
		return sysDicService.getTree(parentId);
	}

	@ResponseBody
	@RequestMapping("/getBokeTypes")
	public ResultPojo<SysDic> getBokeTypes(){
		return sysDicService.getBokeTypes();
	}




	@Override
	public IService<SysDic> getService() {
		return sysDicService;
	}
}
