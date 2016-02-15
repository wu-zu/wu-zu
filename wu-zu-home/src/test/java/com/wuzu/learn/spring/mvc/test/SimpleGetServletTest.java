package com.wuzu.learn.spring.mvc.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * 서블릿에 대한 테스트 참고용. 추후 개선하거나 삭제할 테스트
 * 
 * @author Gahngha Ryu
 */
public class SimpleGetServletTest {

    @Test
    public void test() throws ServletException, IOException {
        
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/hello");
        request.addParameter("name", "Spring");
        
        MockHttpServletResponse response = new MockHttpServletResponse();
        
        HttpServlet servlet = new SimpleGetServlet();
        servlet.service(request, response);
        
//        assertThat(response.getContentAsString(), is("<html><body>Hello Spring</body></html>"));
        assertTrue(response.getContentAsString().contains("Hello Spring"));
    }
    
    @SuppressWarnings("serial")
    private class SimpleGetServlet extends HttpServlet {
        
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String name = request.getParameter("name");
            
            PrintWriter writer = response.getWriter();
            writer.print("<html><body>");
            writer.print("Hello " + name);
            writer.print("</body></html>");
        }
    }
}