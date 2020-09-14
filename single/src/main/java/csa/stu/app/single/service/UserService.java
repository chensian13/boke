package csa.stu.app.single.service;

import csa.stu.app.common.entity.User;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.pojo.ResultPojo;

public interface UserService extends IService<User> {

    /**
     * 用户登录
     * @param user
     * @return
     */
    ResultPojo<User> login(User user);

}
