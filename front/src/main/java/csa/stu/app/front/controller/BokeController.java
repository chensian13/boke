package csa.stu.app.front.controller;

import csa.stu.app.common.entity.Boke;
import csa.stu.app.common.entity.Picture;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoRequestUtil;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.app.front.component.RestUserInfo;
import csa.stu.app.front.feign.UserWorkService;
import csa.stu.util.myutils.constant.OperConstant;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author csa
 */
@RequestMapping("/boke")
@Controller
public class BokeController{
    @Autowired
    private UserWorkService userWorkService;
    @Autowired
    private RestUserInfo restUserInfo;


    @ResponseBody
    @RequestMapping("/data/{oper}")
    public ResultPojo<Boke> addOne(@RequestBody Boke entity, @PathVariable String oper, HttpServletRequest request){
        User user=restUserInfo.getUser(request);
        if(user==null)
            return ResultPojo.newInstance(ResultPojo.NO,"获取用户信息失败，请重新登录");
        entity.setCreater(user.getUserId());
        if(OperConstant.OPER_ADD.equals(oper)){
            return userWorkService.addOne(entity);
        }else if(OperConstant.OPER_UPD.equals(oper)){
            return userWorkService.updOne(entity);
        }else if(OperConstant.OPER_STOP.equals(oper)){
            return userWorkService.stopOne(entity);
        }else if(OperConstant.OPER_DEL.equals(oper)){
            return userWorkService.delOne(entity);
        }
        return ResultPojo.newInstance(ResultPojo.NO,"没有该操作");
    }

    @RequestMapping({"/queryData"})
    @ResponseBody
    public ResultPojo<Boke> queryData(@RequestBody ParamPojo paramPojo,HttpServletRequest request) {
        User user=restUserInfo.getUser(request);
        if(user!=null){
            if(paramPojo.getMap()==null){
                Map<String,Object> map=new HashMap<>();
                paramPojo.setMap(map);
            }
            paramPojo.getMap().put("creater",user.getUserId());
        }
        return userWorkService.queryData(paramPojo);
    }




    @RequestMapping({"/queryById/{id}"})
    @ResponseBody
    public ResultPojo<Boke> queryById(@PathVariable String id) {
        return userWorkService.queryById(id);
    }



}
