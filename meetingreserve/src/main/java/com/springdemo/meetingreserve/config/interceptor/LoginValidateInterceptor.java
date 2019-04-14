package com.springdemo.meetingreserve.config.interceptor;

import com.springdemo.meetingreserve.jpa.entity.UserDO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginValidateInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否登陆，是则将用户信息set到本地线程栈
        UserDO userDO = (UserDO) request.getSession().getAttribute("userDO");
        if(userDO!=null){
//            System.out.println(userDO.getId());
            ThreadUtil.set(userDO);
            return true;
        }
//        response.sendRedirect("/th/login");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
