/*
 * License header jaunerc
 */
package ch.jaunerc.oop2_dat2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaunerc
 */
public class StackTest {
    
    public StackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        System.out.println("test push");
        Stack<String> stack = new Stack<>();
        
        stack.push("asdf");
        stack.push("hubu");
        
        assertEquals(2, stack.getSize());
    }
    
    @Test
    public void testSize() {
        System.out.println("test size");
        Stack<String> stack = new Stack<>();
        
        stack.push("asdf");
        stack.push("hubu");
        stack.push("hubu");
        stack.push("hubu");
        stack.push("hubu");
        String res = stack.pop();
        stack.push("hubu");
        
        assertEquals(5, stack.getSize());
    }
    
    @Test
    public void testPop() {
        System.out.println("test pop");
        Stack<String> stack = new Stack<>();
        
        stack.push("asdf1");
        stack.push("hubu2");
        stack.push("hubu3");
        stack.push("hubu4");
        stack.push("hubu5");
        String res = stack.pop();
        stack.push("hubu5");
        
        assertEquals(res, "hubu5");
    }
    
    @Test
    public void testPopAll() {
        System.out.println("test pop all");
        Stack<String> stack = new Stack<>();
        String res = "";
        
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        
        for(int i = 0; i < 4; i++) {
            res = stack.pop();
        }
        
        assertEquals("1", res);
    }
}
