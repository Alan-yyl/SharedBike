package edu.sspu.bike.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户在不同页面跳转的时候，进行权限控制（根据权限的不同，向用户返回不同的页面）
 * 前端拦截器：权限控制
 *
 * @auther 杨亚龙
 * @date 2019/11/4 12:02
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        req.setCharacterEncoding("utf-8");
        System.out.println("AuthenticationInterceptor.preHandle");
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("AuthenticationInterceptor.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("AuthenticationInterceptor.afterCompletion");
    }
}
