package com.wuzu.learn.spring.mvc.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * POJO based test available
 * 
 * @author Gahngha Ryu
 */
public class ChangeControllerTest {

    @Test
    public void test() {
        
        Map<String, String> params = new HashMap<>();
        params.put("moto", "Change, world!");
        
        Map<String, Object> model = new HashMap<>();
        
        new ChangeController().control(params, model);
        
        assertThat(model.get("message"), is("Change, world!"));
    }
    
    
    /**
     * Controller 인터페이스를 구현한 기반 컨트롤러(예제)
     */
    private static abstract class AbstractSimpleController implements Controller {
        
        private String[] requiredParams;
        private String viewName;
        
        
        @Override
        public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
            
            if (viewName == null) throw new IllegalStateException();
            
            Map<String, String> params = new HashMap<>();
            
            for (String param : requiredParams) {
                
                String value = request.getParameter(param);
                
                if (value == null) throw new IllegalStateException();
                
                params.put(param, value);
            }
            
            Map<String, Object> model = new HashMap<>();
            
            this.control(params, model);
            
            return new ModelAndView(this.viewName, model);
        }
        
        /** 템플릿 메서드 */
        public abstract void control(Map<String, String> params, Map<String, Object> model);

        
        public void setRequiredParams(String[] requiredParams) {
            this.requiredParams = requiredParams;
        }

        public void setViewName(String viewName) {
            this.viewName = viewName;
        }
    }
    
    /**
     * Controller 인터페이스를 구현한 기반 컨트롤러를 상속한 컨트롤러
     */
    private class ChangeController extends AbstractSimpleController {

        public ChangeController() {
            
            this.setRequiredParams(new String[] { "moto" });
            this.setViewName("/WEB-INF/view/index.jsp");
        }
        
        @Override
        public void control(Map<String, String> params, Map<String, Object> model) {
            
            model.put("message", params.get("moto"));
        }
    }
}