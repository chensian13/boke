package csa.stu.app.common.aop;

import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class AdviceController {

    @ExceptionHandler
    public ResultPojo exceptionHandler(Exception e){
        String msg=e.getMessage();
        if(EmptyUtil.isEmpty(msg)){
            msg="服务器异常";
        }
        return ResultPojo.newInstance(ResultPojo.ERROR,msg);
    }

}
