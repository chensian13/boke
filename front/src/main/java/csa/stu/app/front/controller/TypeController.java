package csa.stu.app.front.controller;

import csa.stu.app.common.entity.Type;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoRequestUtil;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.app.front.feign.UserWorkService;
import csa.stu.util.myutils.constant.OperConstant;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 
 * @author csa
 *
 */
@Controller
@RequestMapping("/type")
public class TypeController {
	@Autowired
	private UserWorkService userWorkService;
	@Autowired
	private UserinfoRequestUtil userinfoUtil;


	@ResponseBody
	@RequestMapping("/getBokeTypes")
	public ResultPojo<Type> getBokeTypes(HttpServletRequest request,@RequestBody(required = false) User user){
		User user2=userinfoUtil.getUserCookie(request);
		ParamPojo paramPojo=new ParamPojo();
		paramPojo.setMap(new HashMap<>());
		if(user2!=null){
			paramPojo.getMap().put("userCode",user2.getUserCode());
		}else if(EmptyUtil.isEmptys(user,user.getUserCode())){
			paramPojo.getMap().put("userCode",user.getUserCode());
		}
		return userWorkService.getBokeTypes(paramPojo);
	}


	@RequestMapping({"/data/{oper}"})
	@ResponseBody
	public ResultPojo<Type> operData(@RequestBody Type entity, @PathVariable String oper, HttpServletRequest request){
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
	public ResultPojo<Type> queryById(@PathVariable String id) {
		return userWorkService.queryTypeById(id);
	}

}
