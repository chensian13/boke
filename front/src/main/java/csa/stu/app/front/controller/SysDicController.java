package csa.stu.app.front.controller;

import csa.stu.app.common.entity.SysDic;
import csa.stu.app.common.entity.TreeNode;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.app.front.feign.UserWorkService;
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
	private UserWorkService userWorkService;
	@Autowired
	private UserinfoUtil userinfoUtil;
	
	@ResponseBody
	@RequestMapping("/getTree")
	public ResultPojo<TreeNode> getTree(@RequestParam(name="parentId",required = false) String parentId,HttpServletRequest request){
		User user=userinfoUtil.getUserCookie(request);
		if(user==null) return ResultPojo.newInstance(ResultPojo.NO,"用户信息获取失败");
		return userWorkService.getTree(parentId,user.getUserId());
	}

	@ResponseBody
	@RequestMapping("/getBokeTypes")
	public ResultPojo<SysDic> getBokeTypes(HttpServletRequest request){
		User user=userinfoUtil.getUserCookie(request);
		if(user==null) return ResultPojo.newInstance(ResultPojo.NO,"用户信息获取失败");
		return userWorkService.getBokeTypes(user.getUserId());
	}


	@RequestMapping({"/data/{oper}"})
	@ResponseBody
	public ResultPojo<SysDic> operData(@RequestBody SysDic entity, @PathVariable String oper, HttpServletRequest request){
		User user=userinfoUtil.getUserCookie(request);
		if(user==null) return ResultPojo.newInstance(ResultPojo.NO,"用户信息获取失败");
		entity.setCreater(user.getUserId());
		if(OperConstant.OPER_ADD.equals(oper)){
			return userWorkService.addOne(entity);
		}else if(OperConstant.OPER_DEL.equals(oper)){
			return userWorkService.delOne(entity);
		}else if(OperConstant.OPER_UPD.equals(oper)){
			return userWorkService.updOne(entity);
		}
		return ResultPojo.newInstance(ResultPojo.NO,"没有该操作");
	}

	@RequestMapping({"/queryById/{id}"})
	@ResponseBody
	public ResultPojo<SysDic> queryById(@PathVariable String id) {
		return userWorkService.queryDicById(id);
	}

}
