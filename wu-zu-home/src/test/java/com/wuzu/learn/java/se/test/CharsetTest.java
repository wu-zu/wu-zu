package com.wuzu.learn.java.se.test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Test;

/**
 * @author Gahngha Ryu
 */
public class CharsetTest {

    @Test
    public void charsets() throws UnsupportedEncodingException {
        
        System.out.println(Charset.defaultCharset());
        System.out.println();
        
        String string = "한글";
        byte[] bytes = string.getBytes();
        
        System.out.println(new String(bytes));
        System.out.println(Arrays.toString(bytes));
        System.out.println();
        
        String utf8String = new String(bytes, "UTF-8");
        String eucKrString = new String(bytes, "EUC-KR");
        String ms949String = new String(bytes, "MS949");
        
        System.out.println(utf8String);
        System.out.println(Arrays.toString(utf8String.getBytes()));
        System.out.println();
        
        System.out.println(eucKrString);
        System.out.println(Arrays.toString(eucKrString.getBytes()));
        System.out.println();
        
        System.out.println(ms949String);
        System.out.println(Arrays.toString(ms949String.getBytes()));
    }
    
    @Test
    public void twoBytesAndThreeBytes() throws UnsupportedEncodingException {
        
        String string = "한글";
        
        byte[] eucKrBytes = string.getBytes("EUC-KR");
        System.out.println(Arrays.toString(eucKrBytes));
        System.out.println(new String(eucKrBytes, "EUC-KR"));
        System.out.println();
        
        byte[] ms949Bytes = string.getBytes("MS949");
        System.out.println(Arrays.toString(ms949Bytes));
        System.out.println(new String(ms949Bytes, "MS949"));
        System.out.println();
        
        byte[] utf8Bytes = string.getBytes("UTF-8");
        System.out.println(Arrays.toString(utf8Bytes));
        System.out.println(new String(utf8Bytes));
        System.out.println();
        
        byte[] utf16Bytes = string.getBytes("UTF-16");
        System.out.println(Arrays.toString(utf16Bytes));
        System.out.println(new String(utf16Bytes, "UTF-16"));
    }
}