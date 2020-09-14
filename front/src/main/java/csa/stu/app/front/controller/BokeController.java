//package csa.stu.app.front.controller;
//
//import csa.stu.app.common.entity.Boke;
//import csa.stu.app.common.entity.User;
//import csa.stu.app.common.util.UserinfoRequestUtil;
//import csa.stu.app.front.feign.UserWorkService;
//import csa.stu.util.ap.mvc.plus.CheckLoginController;
//import csa.stu.util.ap.pojo.ParamPojo;
//import csa.stu.util.ap.pojo.ResultPojo;
//import csa.stu.util.ap.pojo.constant.OperConstant;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author csa
// */
//@RequestMapping("/boke")
//@Controller
//public class BokeController implements CheckLoginController {
//    @Autowired
//    private UserWorkService userWorkService;
//    @Autowired
//    private UserinfoRequestUtil userinfoRequestUtil;
//
//
//    @ResponseBody
//    @RequestMapping("/data/{oper}")
//    public ResultPojo<Boke> addOne(@RequestBody Boke entity, @PathVariable String oper, HttpServletRequest request){
//        return mustWrapUser(request,data->{
//            User user=(User) data;
//            entity.setCreater(user.getUserId());
//            if(OperConstant.OPER_ADD.equals(oper)){
//                return userWorkService.addOne(entity);
//            }else if(OperConstant.OPER_UPD.equals(oper)){
//                return userWorkService.updOne(entity);
//            }else if(OperConstant.OPER_STOP.equals(oper)){
//                return userWorkService.stopOne(entity);
//            }else if(OperConstant.OPER_DEL.equals(oper)){
//                return userWorkService.delOne(entity);
//            }
//            return ResultPojo.newInstance(ResultPojo.NO,"没有该操作");
//        });
//    }
//
//    @RequestMapping({"/queryData"})
//    @ResponseBody
//    public ResultPojo<Boke> queryData(@RequestBody ParamPojo paramPojo, HttpServletRequest request) {
//        return mustWrapUser(request,data->{
//            User user=(User) data;
//            if(paramPojo.getMap()==null){
//                Map<String,Object> map=new HashMap<>();
//                paramPojo.setMap(map);
//            }
//            paramPojo.getMap().put("creater",user.getUserId());
//            return userWorkService.queryData(paramPojo);
//        });
//
//    }
//
//
//    @RequestMapping({"/queryById/{id}"})
//    @ResponseBody
//    public ResultPojo<Boke> queryById(@PathVariable String id) {
//        return userWorkService.queryById(id);
//    }
//
//
//    @Override
//    public Object getLoginUser(HttpServletRequest request) {
//        return userinfoRequestUtil.getUser(request);
//    }
//}
