package ch.jaunerc.prg2.oop4_dat4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaunerc
 */
public class BalloonTest {

    /**
     * Test false equals().
     */
    @Test
    public void testFalseEquals() {
        Balloon b1 = new Balloon("asdf");
        Balloon b2 = new Balloon("fdsa");
        boolean res = false;
        
        if(!b1.equals(b2)) {
            res = true;
        }
        assertEquals(res, true);
    }
    
    /**
     * Test true equals().
     */
    @Test
    public void testTrueEquals() {
        Balloon b1 = new Balloon("asdf");
        Balloon b2 = new Balloon("asdf");
        boolean res = false;
        
        if(b1.equals(b2)) {
            res = true;
        }
        assertEquals(res, true);
    }
    
    /**
     * Test null equals().
     */
    @Test
    public void testNullEquals() {
        Balloon b1 = new Balloon("asdf");
        Balloon b2 = null;
        boolean res = false;
        
        if(!b1.equals(b2)) {
            res = true;
        }
        assertEquals(res, true);
    }
    
    /**
     * Test false object type equals().
     */
    @Test
    public void testTypeEquals() {
        Balloon b1 = new Balloon("asdf");
        Object b2 = new Object();
        boolean res = false;
        
        if(!b1.equals(b2)) {
            res = true;
        }
        assertEquals(res, true);
    }
}
