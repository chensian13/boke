package csa.stu.app.sso.service;

import csa.stu.app.common.entity.User;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.myutils.pojo.ResultPojo;

public interface UserService extends IService<User> {
    /**
     * 用户登录
     * @param user
     * @return
     */
    ResultPojo<User> login(User user);

    ResultPojo<User> register(User user);
}
