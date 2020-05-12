package csa.stu.app.front.feign;

import csa.stu.app.common.entity.User;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "sso")
public interface SsoService {

    @RequestMapping("/user/login")
    public ResultPojo<User> loginByUser(@RequestBody User user);

    @RequestMapping("/user/logout")
    public ResultPojo logout();




}
