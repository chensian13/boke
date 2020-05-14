package csa.stu.app.front.config;

import csa.stu.app.front.component.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * springmvc配置类
 * @author csa
 *
 */
@Configuration
public class SpringMVCConfig extends WebMvcConfigurerAdapter{
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(true);
    }

    @Override
	public void addInterceptors(InterceptorRegistry registry) {
        //不对静态资源起作用，针对接口拦截，html拦截
		registry.addInterceptor(loginInterceptor)
			.excludePathPatterns("user/login","user/register","/work/login.html","/work/register.html","/work/signup")
			.addPathPatterns("/boke/**","user/**","/work/*.html");
	}


}
