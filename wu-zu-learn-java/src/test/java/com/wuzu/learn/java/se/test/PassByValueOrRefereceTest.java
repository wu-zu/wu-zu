package com.wuzu.learn.java.se.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author Gahngha Ryu
 * @see <a href="http://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value">http://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value</a>
 */
public class PassByValueOrRefereceTest {
    
    private class SomeObject {
        int number = 1;
        String string = "일";
    }
    
    @Test
    public void test() {
        
        int number = 1;
        String string = "일";
        SomeObject someObject = new SomeObject();
        
        test(number, string, someObject);
        
        assertThat(number, is(1));
        assertThat(string, is("일"));
        
        assertThat(someObject, is(notNullValue()));
        
        assertThat(someObject.number, is(3));
        assertThat(someObject.string, is("삼"));
    }
    
    private void test(int number, String string, SomeObject someObject) {
        
        number = 2;
        string = "이";
        
        someObject.number = 3;
        someObject.string = "삼";
        
        someObject = null;
    }
}