package com.zhang.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.zhang.reggie.common.BaseContext;
import com.zhang.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否完成登录
 * @author ZhangLi
 * @version 1.0
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    //路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER =  new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1. 获取本次请求的URL
        String requestURI = request.getRequestURI();
        log.info("拦截到请求:{}",requestURI);
        //定义不需要处理的请求路径
        String[] Urls = {
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/user/sendMsg",//移动端发送二维码
                "/user/login"   //移动端登录
        };
        //2. 判断本次结果是否需要处理
        boolean check = check(Urls, requestURI);
        //3. 如果不需要处理,则直接放行
        if(check){
            log.info("本次请求{}不需要处理", requestURI);
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        //4-1. 判断登录状态，如果已登录，则直接放行
        if(request.getSession().getAttribute("employee") != null){
            log.info("用户已登录，用户的id为:{}",request.getSession().getAttribute("employee"));
            Long empId = (Long)request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);
            long id = Thread.currentThread().getId();
            //log.info("线程id为:{}",id);
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        //4-2. 判断移动端登录状态，如果已登录，则直接放行
        if(request.getSession().getAttribute("user") != null){
            log.info("用户已登录，用户的id为:{}",request.getSession().getAttribute("user"));
            Long empId = (Long)request.getSession().getAttribute("user");
            BaseContext.setCurrentId(empId);
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        log.info("用户未登录");
        //5. 如果未登录则返回未登录结果
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }

    public boolean check(String[] urls, String requestURI){
        for (String uri : urls) {
            boolean match = PATH_MATCHER.match(uri, requestURI);
            if(match){
                return true;
            }
        }
        return false;
    }
}
