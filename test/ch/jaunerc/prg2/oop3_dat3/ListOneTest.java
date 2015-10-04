/*
 * License header jaunerc
 */
package ch.jaunerc.prg2.oop3_dat3;

import ch.jaunerc.pr2.oop3_dat3.ListOne;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaunerc
 */
public class ListOneTest {
    
    public ListOneTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of add method, of class ListOne.
     */
    @Test
    public void testAdd() {
        ListOne list = new ListOne();
        
        list.add(1);
        list.add(2);
        list.add(3);
        
        assertEquals(3, list.size());
    }
    
    public void testRemove() {
        ListOne list = new ListOne();
        
        list.add(1);
        list.add(1);
        list.add(3);
        boolean res = list.removeValues(5);
        
        assertEquals(false, res);
    }
}
