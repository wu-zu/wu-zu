package com.wuzu.home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gahngha Ryu
 */
public class ResponseHeaderSettingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
//        response.addHeader("X-Frame-Options", "ALLOW-FROM https://docs.google.com");
//        response.addHeader("X-Frame-Options", "ALLOW-FROM https://drive.google.com");
//        response.addHeader("X-Frame-Options", "ALLOW-FROM https://accounts.google.com");
        
        filterChain.doFilter(servletRequest, servletResponse);
    }
    
    @Override
    public void destroy() {
    }
}