package csa.stu.app.zuul.component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoRequestUtil;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * 权限校验过滤器
 */
//@Component
public class ZuulAuthFilter extends ZuulFilter {
    @Autowired
    private UserinfoRequestUtil userinfoUtil;
    private Logger logger= LoggerFactory.getLogger(ZuulAuthFilter.class);
    @Value("${csa.front}")
    private String app;
    @Value("${csa.zuul}")
    private String zuul;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //该过滤器顺序到5以后才能得到serviceid
        return FilterConstants.PRE_DECORATION_FILTER_ORDER+1;
    }

    @Override
    public boolean shouldFilter() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String uri=request.getRequestURI();
        //针对以下请求拦截
        if(uri.contains("/boke/")
                || uri.contains("/user/")
                || uri.contains("/work/")){
            logger.info("已拦截："+request.getRequestURI());
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx=RequestContext.getCurrentContext(); //上下文对象
        HttpServletResponse response=ctx.getResponse();
        HttpServletRequest request = ctx.getRequest();
        try{
            User user=userinfoUtil.getUserCookie(request);
            if(user!=null){
                logger.info("请求放行："+user);
                return null;
            }
            //没有登录
            //response.sendRedirect(app+zuul+"/work/signin");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(200);
            ctx.setResponseBody(JSONUtil.formatJSON(ResultPojo.newInstance(ResultPojo.NO, "请登录")));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
