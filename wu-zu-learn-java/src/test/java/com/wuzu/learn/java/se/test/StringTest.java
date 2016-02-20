package com.wuzu.learn.java.se.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author Gahngha Ryu
 */
public class StringTest {

    @Test
    public void split() {
        
        // 정규표현식을 사용하여 문자열을 나누는 경우 String.split()
        // 특정 String으로 나누는 경우 StringTokenizer
        // 특정 알파벳 또는 기호로 나누는 경우 아무거나

        
    }
    
    @Test
    public void replace() {
        
        String string = "aba";

        assertThat(string.replace("a", "b"), is("bbb"));
    }
    
    /**
     * @see https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#detail
     */
    @Test
    public void format() {
        
        String format = "%f%%";
        
        assertThat(String.format(format, 20.16), is("20.160000%"));
    }
    
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("null")
    public void toStringOfNull() {
        
        String string = null;
        
        string = string.toString();
    }
    
    @Test
    public void valueOfNull() {
        
        String string = null;
        
        assertThat(String.valueOf(string), is("null"));
    }
}