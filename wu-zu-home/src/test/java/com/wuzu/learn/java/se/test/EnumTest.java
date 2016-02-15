package com.wuzu.learn.java.se.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author Gahngha Ryu
 */
public class EnumTest {

    private enum OvertimeNone {}
    
    private enum OvertimeSimple {
        THREE_HOUR, FIVE_HOUR, WEEKEND_FOUR_HOUR, WEEKEND_EIGHT_HOUR
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void howToUse() {
        
        // new OvertimeNone(); // Cannot instantiate the enum

        // System.out.println(OvertimeNone); // Overtime cannot be resolved to a variable

        assertThat(OvertimeNone.values().length, is(0));
        assertThat(OvertimeSimple.values().length, is(4));

        OvertimeSimple.valueOf("NONE");
    }
    
    @Test
    public void howToUse2() {
        
        assertThat(OvertimeSimple.FIVE_HOUR, is(OvertimeSimple.valueOf("FIVE_HOUR")));
        
        assertThat(OvertimeSimple.FIVE_HOUR.toString(), is("FIVE_HOUR"));
        
        OvertimeManager manager = new OvertimeManager();
        int overtimePay = manager.getOvertimePay(OvertimeSimple.THREE_HOUR);
        assertThat(overtimePay, is(18000));
    }
    
    private class OvertimeManager {
        
        private int getOvertimePay(OvertimeSimple overTime) {
            
            int pay = 0;
            
            switch (overTime) {
            // case OvertimeSimple.THREE_HOUR: // The qualified case label EnumTest.OvertimeSimple.THREE_HOUR must be replaced with the unqualified enum constant THREE_HOUR
            case THREE_HOUR:
                pay = 18000;
                break;
                
            case FIVE_HOUR:
                pay = 30000;
                break;
                
            case WEEKEND_FOUR_HOUR:
                pay = 40000;
                break;
                
            case WEEKEND_EIGHT_HOUR:
                pay = 60000;
                break;
            }
            
            return pay;
        }
    }
    
    private enum OvertimeDetail {
        // THREE_HOUR(18000), FIVE_HOUR(30000), WEEKEND_FOUR_HOUR(40000), WEEKEND_EIGHT_HOUR(60000) // The constructor EnumTest.OvertimeDetail(int) is undefined

        // THREE_HOUR(18000), FIVE_HOUR(30000), WEEKEND_FOUR_HOUR(40000), WEEKEND_EIGHT_HOUR(60000) // ; expected after this token
        
        THREE_HOUR(18000), FIVE_HOUR(30000), WEEKEND_FOUR_HOUR(40000), WEEKEND_EIGHT_HOUR(60000); // The constructor EnumTest.OvertimeDetail(int) is undefined
        
        private int pay;
        
        // public OvertimeDetail {} // Illegal modifier for the enum constructor; only private is permitted.
        
        OvertimeDetail(int pay) {
            this.pay = pay;
        }
        
        // THREE_HOUR(18000), FIVE_HOUR(30000), WEEKEND_FOUR_HOUR(40000), WEEKEND_EIGHT_HOUR(60000); // AnnotationName expected
        
        public int getPay() {
            return pay;
        }
    }
    
    @Test
    public void howToUse3() {

        // OvertimeDetail.getPay(); // Cannot make a static reference to the non-static method getPay() from the type EnumTest.OvertimeDetail
        
        assertThat(OvertimeDetail.FIVE_HOUR.getPay(), is(30000));
    }
    
    // private enum OvertimeTemp extends OvertimeNone {} // Syntax error on token "extends"
    
    @Test(expected = IllegalArgumentException.class)
    public void howToUse4() {
        
        assertThat(OvertimeSimple.FIVE_HOUR.name(), is(OvertimeSimple.FIVE_HOUR.toString()));
        
        assertThat(OvertimeSimple.THREE_HOUR.ordinal(), is(0));
        assertThat(OvertimeSimple.FIVE_HOUR.ordinal(), is(1));
        assertThat(OvertimeSimple.WEEKEND_FOUR_HOUR.ordinal(), is(2));
        assertThat(OvertimeSimple.WEEKEND_EIGHT_HOUR.ordinal(), is(3));

        assertThat(OvertimeSimple.FIVE_HOUR.compareTo(OvertimeSimple.THREE_HOUR), is(1));
        assertThat(OvertimeSimple.FIVE_HOUR.compareTo(OvertimeSimple.FIVE_HOUR), is(0));
        assertThat(OvertimeSimple.FIVE_HOUR.compareTo(OvertimeSimple.WEEKEND_FOUR_HOUR), is(-1));
        assertThat(OvertimeSimple.FIVE_HOUR.compareTo(OvertimeSimple.WEEKEND_EIGHT_HOUR), is(-2));
        
        Enum.valueOf(OvertimeSimple.class, "NONE");
    }
    
    @Test
    public void howToUse5() {

        assertThat(Enum.valueOf(OvertimeSimple.class, "FIVE_HOUR"), is(OvertimeSimple.FIVE_HOUR));
    }
}