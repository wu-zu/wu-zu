package com.wuzu.learn.java.se.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Test;

/**
 * @author Gahngha Ryu
 * @see https://gist.github.com/mscharhag/9195718#file-java8datetimeexamples-java-L380
 */
public class Jsr310DateTest {

    @Test
    public void date() {

        LocalDate.now(); // e.g. 2016-02-29
        
        LocalDate.of(2016, 1, 2);
        
        assertThat(LocalDate.ofYearDay(2016, 123), is(LocalDate.of(2016, 5, 2)));
    }
    
    @Test
    public void time() {
        
        LocalTime.now(); // e.g. 14:27:02.526
        
        LocalTime.of(1, 23); // 01:23
        
        LocalTime.of(1, 23, 45); // 01:23:45

        assertThat(LocalTime.ofSecondOfDay(12345), is(LocalTime.of(3, 25, 45)));
    }
    
    @Test
    public void dateTime() {
        
        LocalDateTime.now(); // e.g. 2016-02-29T14:36:19.997

        LocalDateTime.of(2016, 1, 23, 1, 23, 45); // 2016-01-23T01:23:45
    }
}