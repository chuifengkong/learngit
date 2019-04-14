package com.springdemo.meetingreserve.config;

import com.springdemo.meetingreserve.config.interceptor.LoginInterceptor;
import com.springdemo.meetingreserve.config.interceptor.LoginValidateInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        LoginValidateInterceptor loginValidate = new LoginValidateInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        InterceptorRegistration validateLogin = registry.addInterceptor(loginValidate);
        //拦截路径
        loginRegistry.addPathPatterns("/test/loginVerify");
        validateLogin.addPathPatterns("/user/getBoardroomList");
        //排除路径
//        loginRegistry.excludePathPatterns("/login");

    }
}
