package csa.stu.app.common.controller;

import csa.stu.util.ap.mvc.plus.CheckLoginController;
import csa.stu.util.ap.mvc.plus.MyController;
import csa.stu.util.ap.pojo.ParamPojo;
import csa.stu.util.ap.pojo.ResultPojo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyControllerPlus<T> extends MyController<T> implements CheckLoginController {

    @Override
    @RequestMapping({"/data/{oper}"})
    @ResponseBody
    public ResultPojo<T> operData(@RequestBody T entity, @PathVariable String oper, HttpServletRequest request, HttpServletResponse response) {
        return wrapUser(request,"operData",user->{
        	return super.operData(entity, oper, request, response);
        });
    }

    @Override
    @RequestMapping({"/queryById/{id}"})
    @ResponseBody
    public ResultPojo<T> queryById(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        return wrapUser(request,"queryById",user->{
            return super.queryById(id, request, response);
        });
    }

    @Override
    @RequestMapping({"/queryData"})
    @ResponseBody
    public ResultPojo<T> queryData(@RequestBody ParamPojo paramPojo, HttpServletRequest request, HttpServletResponse response) {
        return wrapUser(request,"queryData",user->{
            return super.queryData(paramPojo, request, response);
        });
    }

    @Override
    @RequestMapping({"/querySimpleData"})
    @ResponseBody
    public ResultPojo<T> querySimpleData(@RequestBody ParamPojo paramPojo, HttpServletRequest request, HttpServletResponse response) {
       return wrapUser(request,"querySimpleData",user->{
            return super.querySimpleData(paramPojo, request, response);
       });
    }

}
