package csa.stu.app.front.controller;

import csa.stu.app.common.entity.Boke;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.token.UserInfoUtilBoth;
import csa.stu.app.front.feign.UserWorkService;
import csa.stu.util.ap.mvc.plus.CheckLoginController;
import csa.stu.util.ap.pojo.ParamPojo;
import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.ap.pojo.constant.OperConstant;
import csa.stu.util.ap.web_helper.token.TokenUtilDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author csa
 */
@RequestMapping("/boke")
@Controller
public class BokeController implements CheckLoginController {
    @Autowired
    private UserWorkService userWorkService;
    @Autowired
    private TokenUtilDefault tokenUtilDefault;
    @Autowired
    private UserInfoUtilBoth userInfoUtilBoth;


    @ResponseBody
    @RequestMapping("/data/{oper}")
    public ResultPojo<Boke> addOne(@RequestBody Boke entity, @PathVariable String oper, HttpServletRequest request){
        return mustWrapUser(request,data->{
            User user=(User) data;
            entity.setCreater(user.getUserId());
            if(OperConstant.OPER_ADD.equals(oper)){
                return userWorkService.addOneBoke(entity);
            }else if(OperConstant.OPER_UPD.equals(oper)){
                return userWorkService.updOneBoke(entity);
            }else if(OperConstant.OPER_STOP.equals(oper)){
                return userWorkService.stopOneBoke(entity);
            }else if(OperConstant.OPER_DEL.equals(oper)){
                return userWorkService.delOneBoke(entity);
            }
            return ResultPojo.newInstance(ResultPojo.NO,"没有该操作");
        });
    }

    @RequestMapping({"/queryData"})
    @ResponseBody
    public ResultPojo<Boke> queryData(@RequestBody ParamPojo paramPojo, HttpServletRequest request) {
        return mustWrapUser(request,data->{
            User user=(User) data;
            if(paramPojo.getMap()==null){
                Map<String,Object> map=new HashMap<>();
                paramPojo.setMap(map);
            }
            paramPojo.getMap().put("creater",user.getUserId());
            return userWorkService.queryBokeData(paramPojo);
        });

    }


    @RequestMapping({"/queryById/{id}"})
    @ResponseBody
    public ResultPojo<Boke> queryById(@PathVariable String id) {
        return userWorkService.queryBokeById(id);
    }

    @RequestMapping({"/queryData/{userId}"})
    @ResponseBody
    public ResultPojo<Boke> queryDataByUser(@RequestBody ParamPojo paramPojo, @PathVariable("userId") String userId) {
        if(paramPojo.getMap()==null){
            Map<String,Object> map=new HashMap<>();
            paramPojo.setMap(map);
        }
        paramPojo.getMap().put("creater",userId);
        return userWorkService.queryBokeData(paramPojo);
    }


    @Override
    public Object getLoginUser(HttpServletRequest request) {
        return userInfoUtilBoth.getUser(tokenUtilDefault.getTokenCookie(request));
    }

    @Override
    public String[] getWhiteMethod() {
        return null;
    }
}
