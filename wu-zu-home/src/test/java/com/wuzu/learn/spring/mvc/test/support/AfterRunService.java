package com.wuzu.learn.spring.mvc.test.support;

import java.io.UnsupportedEncodingException;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author Gahngha Ryu
 */
public interface AfterRunService {

    String getContentAsString() throws UnsupportedEncodingException;
    
    <T> T getBean(Class<T> beanType);
    
    ModelAndView getModelAndView();
    
    AfterRunService assertViewName(String viewName);
    
    AfterRunService assertModel(String name, Object value);
}