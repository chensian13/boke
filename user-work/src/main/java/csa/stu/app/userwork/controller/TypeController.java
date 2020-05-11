package csa.stu.app.userwork.controller;

import csa.stu.app.common.entity.Type;
import csa.stu.app.userwork.service.TypeService;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.mvc.plus.MyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


	@Override
	public IService<Type> getService() {
		return typeService;
	}
}
