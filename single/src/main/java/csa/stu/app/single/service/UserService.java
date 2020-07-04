package csa.stu.app.single.service;

import csa.stu.app.common.entity.User;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.myutils.pojo.ResultPojo;

public interface UserService extends IService<User> {
    ResultPojo<User> register(User user);

    ResultPojo<User> modPass(User user);

    ResultPojo<User> selectByCode(String code);

    /**
     * 用户登录
     * @param user
     * @return
     */
    ResultPojo<User> login(User user);

}
