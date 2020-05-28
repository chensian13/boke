package csa.stu.app.sso.controller;
import csa.stu.app.common.cache.LoginCache;
import csa.stu.app.common.entity.User;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 缓存
 */
@Controller
@RequestMapping("/cache")
public class LoginCacher {
    @Autowired
    private LoginCache loginCache;

    @RequestMapping("/get")
    @ResponseBody
    public User get(@RequestBody String token){
        return loginCache.get(token);
    }

    @RequestMapping("/put")
    @ResponseBody
    public ResultPojo<User> put(@RequestBody User user){
        if(EmptyUtil.isEmptys(user.getToken())){
            return ResultPojo.newInstance(ResultPojo.NO,"token不存在");
        }
        loginCache.put(user.getToken(),user);
        return ResultPojo.newInstance(ResultPojo.OK,null);
    }

}
