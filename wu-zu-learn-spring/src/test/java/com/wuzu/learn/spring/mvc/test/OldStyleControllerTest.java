package com.wuzu.learn.spring.mvc.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.wuzu.learn.spring.mvc.test.support.AbstractDispatcherServletTest;

/**
 * org.springframework.web.servlet.mvc.Controller 타입 컨트롤러 테스트
 * 
 * @author Gahngha Ryu
 */
public class OldStyleControllerTest extends AbstractDispatcherServletTest {
    
    private static class OldStyleController implements Controller {
        
        @Override
        public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
            
            Map<String, Object> model = new HashMap<>();
            model.put("serverTime", DateFormat.getDateTimeInstance().format(new Date()));
            model.put("moto", "Change, world!");
            
            return new ModelAndView("index", model);
        }
    }
    
    private OldStyleController oldStyleController;
    
    @Before
    public void setUp() {
        
        String currentPath = ClassUtils.classPackageAsResourcePath(getClass()) + "/";
        
        try (ConfigurableApplicationContext ac = new GenericXmlApplicationContext(currentPath + "spring-servlet.xml");) {
            
            oldStyleController = ac.getBean(OldStyleController.class);
        }
    }
    
    @Test
    public void testWithApplicationContext() throws Exception {
        
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/");
        MockHttpServletResponse response = new MockHttpServletResponse();

        ModelAndView mav = oldStyleController.handleRequest(request, response);
        
        assertThat(mav.getViewName(), is("index"));
        assertThat((String) mav.getModel().get("moto"), is("Change, world!"));
    }
    
    @Test
    public void testWithoutApplicationContext() throws Exception {
        
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/");
        MockHttpServletResponse response = new MockHttpServletResponse();
        
        Controller oldStyleController = new OldStyleController();
        
        ModelAndView mav = oldStyleController.handleRequest(request, response);
        
        assertThat(mav.getViewName(), is("index"));
        assertThat((String) mav.getModel().get("moto"), is("Change, world!"));
    }
    
    @Test
    public void testWithTestSupporter() throws ServletException, IOException {
        
        setRelativeLocations("spring-servlet.xml").runService("/")
        .assertViewName("index").assertModel("moto", "Change, world!");
    }
}