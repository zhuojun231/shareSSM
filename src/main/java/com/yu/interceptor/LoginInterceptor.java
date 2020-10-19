package com.yu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  登录拦截
 * @ClassName LoginInterceptor
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/16 17:37
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 登录验证
     *      如果session有登录信息，放行
     *      如果session没有登录信息，拦截
     * 判断是否是登录请求，如果登录请求，直接放行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求路径
        String requestURI = request.getRequestURI();
        //判断是否是登录请求
        if(requestURI.contains("login/toLogin")){
//            如果是登录请求，直接放行
            return true;
        }
        //从session中获取登录信息
        Object username = request.getSession().getAttribute("username");
        if(username != null){

            //session中有登录信息，放行
            return true;
        }else{
            //session没有登录信息，跳转到登录页面
            response.sendRedirect("/login.jsp");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
