package csa.stu.app.front.controller;

import csa.stu.app.common.entity.SysDic;
import csa.stu.app.common.entity.TreeNode;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.app.front.feign.SysDicService;
import csa.stu.util.myutils.constant.OperConstant;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author csa
 *
 */
@Controller
@RequestMapping("/dic")
public class SysDicController{
	@Autowired
	private SysDicService sysDicService;
	@Autowired
	private UserinfoUtil userinfoUtil;
	
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


	@RequestMapping({"/data/{oper}"})
	@ResponseBody
	public ResultPojo<SysDic> operData(@RequestBody SysDic entity, @PathVariable String oper, HttpServletRequest request){
		if(OperConstant.OPER_ADD.equals(oper)){
			return sysDicService.addOne(entity);
		}else if(OperConstant.OPER_DEL.equals(oper)){
			return sysDicService.delOne(entity);
		}else if(OperConstant.OPER_UPD.equals(oper)){
			return sysDicService.updOne(entity);
		}
		return ResultPojo.newInstance(ResultPojo.NO,"没有该操作");
	}

	@RequestMapping({"/queryById/{id}"})
	@ResponseBody
	public ResultPojo<SysDic> queryById(@PathVariable String id) {
		return sysDicService.queryById(id);
	}

}
