package com.wuzu.learn.java.se.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import org.junit.Test;

/**
 * @author Gahngha Ryu
 */
public class AnnotationTest {

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    private @interface Min {
        
        int value();
    }
    
    private class Adult {
        
        @Min(19)
        private int age;
        
        public void setAge(int age) {
            this.age = age;
        }
    }
    
    private class Bar {
        
        public void sellLiquorTo(Adult adult) {

            checkAge(adult);
            
            System.out.println("꿀꺽 꿀꺽");
        }

        // SOC에 어긋남.
        private void checkAge(Adult adult) {
            
            Field[] declaredFields = adult.getClass().getDeclaredFields();
            
            for (Field field : declaredFields) {
                
                Min min = field.getAnnotation(Min.class);

                if (min == null) continue;
                
                if (adult.age < min.value()) {
                    
                    throw new IllegalStateException("미성년자 꺼져!");
                }
            }
        }
    }
    
    @Test(expected = IllegalStateException.class)
    public void illegal() {
        
        Adult adult = new Adult();
        adult.setAge(18);
        
        Bar bar = new Bar();
        bar.sellLiquorTo(adult);
    }
    
    @Test
    public void legal() {
        
        Adult adult = new Adult();
        adult.setAge(19);
        
        Bar bar = new Bar();
        bar.sellLiquorTo(adult);
    }
}