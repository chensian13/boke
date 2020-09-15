package csa.stu.app.userwork.controller;

import csa.stu.app.common.entity.Type;
import csa.stu.app.userwork.service.TypeService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import csa.stu.util.ap.pojo.ResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping("/getBokeTypes")
	@ResponseBody
	public ResultPojo<Type> queryData(@RequestBody String userId) {
		return typeService.selectData(userId);
	}


	@Override
	public IService<Type> getService() {
		return typeService;
	}
}
