package csa.stu.app.userwork.service;

import csa.stu.app.common.entity.Type;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.pojo.ResultPojo;

public interface TypeService extends IService<Type> {

    ResultPojo<Type> selectData(String creater);

}
