package com.wuzu.learn.java.se.test;

import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**
 * @author Gahngha Ryu
 */
public class SystemTest {

    @Test
    public void properties() {
        
        Set<Entry<Object, Object>> properties = System.getProperties().entrySet();
        
        for (Entry<Object, Object> property : properties) {
            
            System.out.println(property.getKey() + " = " + property.getValue());
        }
    }
    
    @Test
    public void environments() {
        
        Set<Entry<String, String>> environments = System.getenv().entrySet();
        
        for (Entry<String, String> environment : environments) {
            
            System.out.println(environment.getKey() + " = " + environment.getValue());
        }
    }
    
    @Test
    public void chronometry() throws InterruptedException {
        
        long beginMilli = System.currentTimeMillis();
        long beginNano = System.nanoTime();
        
        Thread.sleep(1000);
        
        System.out.println( System.currentTimeMillis() - beginMilli );
        System.out.println( System.nanoTime() - beginNano );
    }
}