package com.wuzu.learn.spring.mvc.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;

import com.wuzu.learn.spring.mvc.test.support.AbstractDispatcherServletTest;

/**
 * 서블릿을 컨트롤러로 사용하는 예제
 * 
 * @author Gahngha Ryu
 */
public class ServletControllerTest extends AbstractDispatcherServletTest {

    @Test
    public void changeServletController() throws UnsupportedEncodingException, ServletException, IOException {
        
        setClasses(SimpleServletHandlerAdapter.class, ChangeServlet.class);
        
        initRequest("/change");
        
        assertThat(runService().getContentAsString(), is("Change, world!"));
    }
    
    @Component("/change") // for BeanNameUrlHandlerMapping. you can use @Name instead.
    @SuppressWarnings("serial")
    private static class ChangeServlet extends HttpServlet {
        
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            response.getWriter().print("Change, world!");
        }
    }
}