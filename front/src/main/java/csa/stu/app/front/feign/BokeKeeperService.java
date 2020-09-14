package csa.stu.app.front.feign;

import csa.stu.app.common.entity.User;
import csa.stu.util.ap.pojo.ResultPojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "boke-keeper",fallback = BokeKeeperService.BokeKeeperServiceFallback.class)
public interface BokeKeeperService {

    @PostMapping("/user/register")
    public ResultPojo register(@RequestBody User user);

    @PostMapping("/user/modPass")
    public ResultPojo modPass(@RequestBody User user);

    @RequestMapping("/user/data/{oper}")
    public ResultPojo<User> operUserData(@RequestBody User entity, @PathVariable String oper);

    @RequestMapping("/user/queryById/{id}")
    public ResultPojo<User> queryUserById(@PathVariable String id);

    /**
     * 网站用户登录
     * @return
     */
    @RequestMapping("/sso/login")
    public ResultPojo<User> login(@RequestBody User user);


    @Component
    public static class BokeKeeperServiceFallback implements BokeKeeperService{

        @Override
        public ResultPojo register(User user) {
            return null;
        }

        @Override
        public ResultPojo modPass(User user) {
            return null;
        }

        @Override
        public ResultPojo<User> operUserData(User entity, String oper) {
            return null;
        }

        @Override
        public ResultPojo<User> queryUserById(String id) {
            return null;
        }

        @Override
        public ResultPojo<User> login(User user) {
            return ResultPojo.newInstance(ResultPojo.NO,"请求失败");
        }
    }

}
