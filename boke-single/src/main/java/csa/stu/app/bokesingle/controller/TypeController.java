package csa.stu.app.bokesingle.controller;

import csa.stu.app.bokesingle.component.LoginCacher;
import csa.stu.app.common.entity.Type;
import csa.stu.app.common.entity.User;
import csa.stu.app.single.controller.MyControllerPlus;
import csa.stu.app.single.service.TypeService;
import csa.stu.app.single.service.UserService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author csa
 *
 */
@Controller
@RequestMapping("/type")
public class TypeController extends MyControllerPlus<Type> {
	@Autowired
	private TypeService typeService;
	@Autowired
	private UserService userService;
	@Autowired
	private LoginCacher loginCacher;

	@RequestMapping({"/getBokeTypes"})
	@ResponseBody
	public ResultPojo<Type> queryData(HttpServletRequest request) {
		return typeService.selectData(loginCacher.get(request).getUserId());
	}


	@Override
	public IService<Type> getService() {
		return typeService;
	}

	@Override
	public User getLoginUser(HttpServletRequest request) {
		return loginCacher.get(request);
	}
}
