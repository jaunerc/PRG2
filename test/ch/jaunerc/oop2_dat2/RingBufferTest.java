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
public class RingBufferTest {
    
    public RingBufferTest() {
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
     * Test of enqueue method, of class RingBuffer.
     */
    @Test
    public void testEnqueue() {
        System.out.println("Test enqueue");
        RingBuffer<String> buff = new RingBuffer<>(10);
        
        buff.enqueue("test1");
        
        String s = buff.dequeue();
        assertEquals(s, "test1");
    }
    
    @Test
    public void testEmpty() {
        System.out.println("Test empty");
        RingBuffer<String> buff = new RingBuffer<>(10);
        
        buff.enqueue("test1");
        
        assertEquals(false, buff.isEmpty());
    }
    
    @Test
    public void testFull() {
        System.out.println("Test full");
        RingBuffer<String> buff = new RingBuffer<>(10);
        
        for(int i = 0; i < 10; i++) {
            buff.enqueue("asdf");
        }
        
        assertEquals(true, buff.isFull());
    }
}
