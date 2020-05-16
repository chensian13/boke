package csa.stu.app.userwork.controller;

import csa.stu.app.common.entity.Type;
import csa.stu.app.common.entity.User;
import csa.stu.app.userwork.service.TypeService;
import csa.stu.app.userwork.service.UserService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author csa
 *
 */
@Controller
@RequestMapping("/type")
public class TypeController extends MyController<Type> {
	@Autowired
	private TypeService typeService;
	@Autowired
	private UserService userService;

	@Override
	@RequestMapping({"/queryData"})
	@ResponseBody
	public ResultPojo<Type> queryData(@RequestBody ParamPojo paramPojo, HttpServletRequest request, HttpServletResponse response) {
		if(EmptyUtil.isEmptys(paramPojo.getMap(),paramPojo.getMap().get("userCode"))){
			return ResultPojo.newInstance(ResultPojo.NO,"没有作者信息");
		}
		String userCode=paramPojo.getMap().get("userCode").toString();
		User user=userService.selectByCode(userCode).getModel();
		if(EmptyUtil.isEmptys(user,user.getUserId())){
			return ResultPojo.newInstance(ResultPojo.NO,"获取不到作者信息");
		}
		return typeService.selectData(user.getUserId(),paramPojo);
	}


	@Override
	public IService<Type> getService() {
		return typeService;
	}
}
