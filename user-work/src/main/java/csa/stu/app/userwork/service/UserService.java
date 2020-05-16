package csa.stu.app.userwork.service;

import csa.stu.app.common.entity.User;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.myutils.pojo.ResultPojo;

public interface UserService extends IService<User> {
    ResultPojo<User> register(User user);

    ResultPojo<User> modPass(User user);

    ResultPojo<User> selectByCode(String code);

}
