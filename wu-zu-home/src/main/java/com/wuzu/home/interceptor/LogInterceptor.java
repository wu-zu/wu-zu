package com.wuzu.home.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 컨트롤러 호출 전후에 인터셉터를 넣을 수 있음을 보여주는 예제. 추후 멋지게 바뀌기를...
 * 
 * @author Gahngha Ryu
 */
public class LogInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        System.out.println(getClass().getName() + ".preHandle() - " + handler.getClass().getName());
        
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
        System.out.println(getClass().getName() + ".postHandle() - " + handler.getClass().getName());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        
        System.out.println(getClass().getName() + ".afterCompletion() - " + handler.getClass().getName());
    }
}