package com.wuzu.learn.java.se.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Gahngha Ryu
 */
public class ObjectTest {
    
    @Test
    public void hashCodeTest() {
        
        System.out.println(hashCode());
        System.out.println(Integer.toHexString(hashCode()));
        
        Object obj1 = new Object();
        Object obj2 = new Object();
        
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        
        assertTrue(obj1 != obj2);
        assertThat(obj1, is(not(obj2)));
        assertThat(obj1.hashCode(), is(not(obj2.hashCode())));
        
        class ClassForHashCodeTest {
            @Override
            public int hashCode() {
                return 777;
            }
        }
        
        ClassForHashCodeTest object1 = new ClassForHashCodeTest();
        ClassForHashCodeTest object2 = new ClassForHashCodeTest();
        
        assertTrue(object1 != object2);
        assertThat(object1, is(not(object2)));
    }
    
    @Test
    public void toStringTest() {
        
        System.out.println(this);
        System.out.println(toString());
        
        assertThat(toString(), is(getClass().getName() + "@" + Integer.toHexString(hashCode())));
        
        class ClassForToStringTest {
            @Override
            public String toString() {
                return "Change, world!";
            }
        }
        
        ClassForToStringTest object = new ClassForToStringTest();
        
        assertThat(object.toString(), is("Change, world!"));
    }
    
    @Test
    public void equalsTest() {
        
        Object object1 = new Object();
        Object object2 = new Object();
        
        assertTrue(object1 != object2);
        assertThat(object1, is(not(object2)));
        
        Integer i1 = 1;
        Integer i2 = 1;
        
        assertTrue(i1 == i2);
        assertThat(i1, is(i2));
        
        Integer i3 = new Integer(1);
        Integer i4 = new Integer(1);
        
        assertTrue(i3 != i4);
        assertThat(i3, is(i4));
    }
    
    @Test
    public void getClassTest() {
        
        System.out.println(new Object().getClass());
        
        System.out.println(getClass());
        System.out.println(getClass().toString());
    }
    
//    object.notify();
    
    
//    object.notifyAll();
    
    
//    object.wait();
    
    
//    object.wait(timeout);
    
    
//    object.wait(timeout, nanos);
}