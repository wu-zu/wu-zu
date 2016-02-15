package com.wuzu.learn.spring.mvc.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.web.servlet.ModelAndView;

import com.wuzu.learn.spring.mvc.test.support.ConfigurableDispatcherServlet;

/**
 * @author Gahngha Ryu
 */
public class SpringMvcTest {
    
    private ConfigurableDispatcherServlet servlet;
    
    @Before
    public void setUp() throws Exception {
        
        servlet = new ConfigurableDispatcherServlet();
        
        servlet.setRelativeLocations(getClass(), "spring-servlet.xml");
        
        servlet.init(new MockServletConfig("spring"));
    }

    @Test
    public void indexController() throws ServletException, IOException {
        
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/");
        MockHttpServletResponse response = new MockHttpServletResponse();
        
        servlet.service(request, response);
        
        ModelAndView mav = servlet.getModelAndView();
        
        assertThat(mav.getViewName(), is("index"));
        assertThat((String) mav.getModel().get("moto"), is("Change, world!"));
    }
}