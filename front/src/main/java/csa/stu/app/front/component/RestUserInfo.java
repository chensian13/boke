package csa.stu.app.front.component;

import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
public class RestUserInfo {
    @Autowired
    private UserinfoRequestUtil userinfoUtil;

    public User getUser(HttpServletRequest request){
        return userinfoUtil.getUser(request, ()->{
            throw new RuntimeException("redis服务器找不到");
        });
    }


}
