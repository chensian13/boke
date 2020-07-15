package csa.stu.app.single.controller;

import csa.stu.app.common.entity.User;
import csa.stu.util.ap.mvc.plus.MyController;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;

public abstract class MyControllerPlus<T> extends MyController<T> {


    @Override
    @RequestMapping({"/data/{oper}"})
    @ResponseBody
    public ResultPojo<T> operData(@RequestBody T entity, @PathVariable String oper, HttpServletRequest request, HttpServletResponse response) {
        return wrapUser(request,user->{
            try {
                if(user!=null){
                    Method m=entity.getClass().getMethod("setCreater",String.class);
                    m.invoke(entity,user.getUserId());
                }
                return super.operData(entity, oper, request, response);
            } catch (Exception e) {
                throw new RuntimeException("没有creater字段");
            }
        });
    }

    @Override
    @RequestMapping({"/queryById/{id}"})
    @ResponseBody
    public ResultPojo<T> queryById(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        return wrapUser(request,user->{
            return super.queryById(id, request, response);
        });
    }

    @Override
    @RequestMapping({"/queryData"})
    @ResponseBody
    public ResultPojo<T> queryData(@RequestBody ParamPojo paramPojo, HttpServletRequest request, HttpServletResponse response) {
        return wrapUser(request,user->{
            if(user!=null)
                paramPojo.put("creater",user.getUserId());
            return super.queryData(paramPojo, request, response);
        });
    }

    @Override
    @RequestMapping({"/querySimpleData"})
    @ResponseBody
    public ResultPojo<T> querySimpleData(@RequestBody ParamPojo paramPojo, HttpServletRequest request, HttpServletResponse response) {
       return wrapUser(request,user->{
           if(user!=null)
               paramPojo.put("creater",user.getUserId());
            return super.querySimpleData(paramPojo, request, response);
       });
    }


    public abstract User getLoginUser(HttpServletRequest request);


    protected interface Product{
        public ResultPojo exe(User user);
    }

    /**
     * 封装登录信息+检查是否登录
     * @param request
     * @param product
     * @return
     */
    protected ResultPojo wrapUser(HttpServletRequest request,Product product){
        String cl=request.getHeader("checkLogin");
        if(EmptyUtil.isEmpty(cl)){
            //不必登录就可以访问
            return product.exe(null);
        }
        return mustWrapUser(request,product);
    }

    /**
     * 必须有登录信息
     * @param request
     * @param product
     * @return
     */
    protected ResultPojo mustWrapUser(HttpServletRequest request,Product product){
        User user=getLoginUser(request);
        if(user==null){
            return noLogin();
        }
        return product.exe(user);
    }



    public ResultPojo noLogin(){
        return ResultPojo.newInstance(ResultPojo.NO,"请先登录");
    }

}
