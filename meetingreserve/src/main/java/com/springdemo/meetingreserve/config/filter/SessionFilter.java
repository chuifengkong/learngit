package com.springdemo.meetingreserve.config.filter;

import com.springdemo.meetingreserve.jpa.entity.UserDO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        UserDO userDO = (UserDO) request.getSession().getAttribute("userDO");
        if (userDO != null) {
            //先销毁在添加否则触发不了监听器中的attributeAdded
            request.getSession().removeAttribute("userDO");
            //重新设值session
            request.getSession().setAttribute("userDO", userDO);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
