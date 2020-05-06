package csa.stu.app.userwork.controller;

import csa.stu.app.common.entity.SysDic;
import csa.stu.app.common.entity.TreeNode;
import csa.stu.app.userwork.service.SysDicService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public ResultPojo<TreeNode> getTree(@RequestParam(name="parentId",required = false) String parentId
			,@RequestParam(name="userId",required = false) String userId){
		return sysDicService.getTree(parentId,userId);
	}

	@ResponseBody
	@RequestMapping("/getBokeTypes")
	public ResultPojo<SysDic> getBokeTypes(@RequestBody String userId){
		return sysDicService.getBokeTypes(userId);
	}




	@Override
	public IService<SysDic> getService() {
		return sysDicService;
	}
}
