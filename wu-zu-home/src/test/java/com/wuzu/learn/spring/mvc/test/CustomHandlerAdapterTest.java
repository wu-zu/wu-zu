package com.wuzu.learn.spring.mvc.test;

import java.io.IOException;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;

import com.wuzu.learn.spring.mvc.test.support.AbstractDispatcherServletTest;

/**
 * 커스텀 핸들러 어댑터 테스트
 * 
 * @author Gahngha Ryu
 */
public class CustomHandlerAdapterTest extends AbstractDispatcherServletTest {
    
    @Ignore // TODO Gahngha Ryu 왜 실패하는 걸까?
    @Test
    public void simpleHandlerAdapter() throws ServletException, IOException {
        
        setClasses(ControllerClassNameHandlerMapping.class, SimpleHandlerAdapter.class, ChangeController.class);
        
        initRequest("/change").addParameter("moto", "Change, world!").runService();
        
        assertViewName("/WEB-INF/view/index.jsp");
        
        assertModel("message", "Change, world!");
    }
    
    
    /**
     * 커스텀 컨트롤러 인터페이스(예제)
     */
    private static interface SimpleController {

        void control(Map<String, String> params, Map<String, Object> model);
    }
    
    /**
     * 커스텀 컨트롤러 인터페이스를 구현한 클래스(예제)
     */
    private static class ChangeController implements SimpleController {

        @SimpleHandlerAdapter.ViewName("/WEB-INF/view/index.jsp")
        @SimpleHandlerAdapter.RequiredParams({"moto"})
        @Override
        public void control(Map<String, String> params, Map<String, Object> model) {
            
            model.put("message", params.get("moto"));
        }
    }
    
    /**
     * 커스텀 컨트롤러를 사용하는 커스텀 핸들러 어댑터
     * 
     * @author Gahngha Ryu
     */
    private static class SimpleHandlerAdapter implements HandlerAdapter {
        
        @Retention(RetentionPolicy.RUNTIME)
        @Inherited
        private @interface ViewName {
            
            String value();
        }
        
        @Retention(RetentionPolicy.RUNTIME)
        @Inherited
        private @interface RequiredParams {

            String[] value();
        }
        
        @Override
        public boolean supports(Object handler) {
            
            return handler instanceof SimpleController;
        }

        @Override
        public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            
            Method method = ReflectionUtils.findMethod(handler.getClass(), "control", Map.class, Map.class);
            
            ViewName viewName = AnnotationUtils.getAnnotation(method, ViewName.class);
            RequiredParams requiredParams = AnnotationUtils.getAnnotation(method, RequiredParams.class);
            
            Map<String, String> params = new HashMap<>();
            
            for (String param : requiredParams.value()) {
                
                String value = request.getParameter(param);
                
                if (value == null) throw new IllegalStateException();
                
                params.put(param, value);
            }
            
            Map<String, Object> model = new HashMap<>();
            
            ((SimpleController) handler).control(params, model);
            
            return new ModelAndView(viewName.value(), model);
        }

        @Override
        public long getLastModified(HttpServletRequest request, Object handler) {
            
            return -1;
        }
    }
}