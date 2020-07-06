package csa.stu.app.single.controller;

import csa.stu.app.common.entity.User;
import csa.stu.app.single.util.LoginCacher;
import csa.stu.util.ap.mvc.plus.MyController;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;

public abstract class MyControllerPlus<T> extends MyController<T> {

    public abstract LoginCacher loginCacher();

    @Override
    public ResultPojo<T> operData(T entity, String oper, HttpServletRequest request, HttpServletResponse response) {
        return checkUser(entity,request,data->{
            return super.operData((T)data, oper, request, response);
        });
    }

    @Override
    public ResultPojo<T> queryById(String id, HttpServletRequest request, HttpServletResponse response) {
        return super.queryById(id, request, response);
    }

    @Override
    public ResultPojo<T> queryData(ParamPojo paramPojo, HttpServletRequest request, HttpServletResponse response) {
        return checkUser(paramPojo,request,data->{
            return super.queryData((ParamPojo)data, request, response);
        });
    }

    @Override
    public ResultPojo<T> querySimpleData(ParamPojo paramPojo, HttpServletRequest request, HttpServletResponse response) {
       return checkUser(paramPojo,request,data->{
            return super.querySimpleData((ParamPojo)data, request, response);
       });
    }


    protected interface product{
        public ResultPojo pro(Object data);
    }

    protected ResultPojo checkUser(Object data, HttpServletRequest request, product product){
        User user=loginCacher().get(request);
        if(EmptyUtil.isEmpty(user)) {
            return ResultPojo.newInstance(ResultPojo.NO,"用户信息为空，请登录");
        }
        if(data instanceof ParamPojo){
            ParamPojo paramPojo=(ParamPojo)data;
            if(EmptyUtil.isEmpty(paramPojo.getMap())){
                paramPojo.setMap(new HashMap<>());
            }
            paramPojo.getMap().put("creater",user.getUserId());
            return product.pro(paramPojo);
        }else{
            try {
                Method m=data.getClass().getMethod("setCreater",String.class);
                m.invoke(data,user.getUserId());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                return product.pro(data);
            }
        }
    }


}
