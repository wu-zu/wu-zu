package com.wuzu.home.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wuzu.home.domain.Common;

/**
 * @author Gahngha Ryu
 */
public class CommonInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        Common common = new Common();
        
        request.setAttribute("common", common);
        
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
        String requestUri = request.getRequestURI();
        
        String target = requestUri.substring(requestUri.lastIndexOf("/") + 1);

        int dotIndex = target.lastIndexOf(".");
        
        String viewFileName = null;
        
        if (dotIndex == -1) {
            viewFileName = target;
        }
        else {
            viewFileName = target.substring(0, dotIndex);
        }
        
        Common common = (Common) request.getAttribute("common");
        
        common.setViewFileName(viewFileName);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        
        // 예외 발생 시 로그를 남기거나 관리자에게 통보할 때 이곳을 사용하면 좋다.
    }
}