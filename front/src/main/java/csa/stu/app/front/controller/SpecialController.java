package csa.stu.app.front.controller;

import csa.stu.app.common.entity.Special;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/special")
public class SpecialController implements CheckLoginController {
    @Autowired
    private UserWorkService userWorkService;
    @Autowired
    private TokenUtilDefault tokenUtilDefault;
    @Autowired
    private UserInfoUtilBoth userInfoUtilBoth;


    @ResponseBody
    @RequestMapping("/data/{oper}")
    public ResultPojo<Special> addOne(@RequestBody Special entity, @PathVariable String oper, HttpServletRequest request){
        return mustWrapUser(request,data->{
            User user=(User) data;
            entity.setCreater(user.getUserId());
            if(OperConstant.OPER_ADD.equals(oper)){
                return userWorkService.addOneSpecial(entity);
            }else if(OperConstant.OPER_UPD.equals(oper)){
                return userWorkService.updOneSpecial(entity);
            }else if(OperConstant.OPER_STOP.equals(oper)){
                return userWorkService.stopOneSpecial(entity);
            }else if(OperConstant.OPER_DEL.equals(oper)){
                return userWorkService.delOneSpecial(entity);
            }
            return ResultPojo.newInstance(ResultPojo.NO,"没有该操作");
        });
    }

    @RequestMapping({"/queryData"})
    @ResponseBody
    public ResultPojo<Special> queryData(@RequestBody ParamPojo paramPojo, HttpServletRequest request) {
        return mustWrapUser(request,data->{
            User user=(User) data;
            if(paramPojo.getMap()==null){
                Map<String,Object> map=new HashMap<>();
                paramPojo.setMap(map);
            }
            paramPojo.getMap().put("creater",user.getUserId());
            return userWorkService.querySpecialData(paramPojo);
        });

    }


    @RequestMapping({"/queryById/{id}"})
    @ResponseBody
    public ResultPojo<Special> queryById(@PathVariable String id) {
        return userWorkService.querySpecialById(id);
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
