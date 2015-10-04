/*
 * License header jaunerc
 */
package ch.jaunerc.oop2_dat2;

import ch.jaunerc.prg2.oop2_dat2.DoubleLinkedList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaunerc
 */
public class DoubleLinkedListTest {
    
    public DoubleLinkedListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addFirst method, of class DoubleLinkedList.
     */
    @Test
    public void testAddFirst() {
        DoubleLinkedList<String> doubleLinkList = new DoubleLinkedList<>();
        
        doubleLinkList.addFirst("2");
        doubleLinkList.addFirst("1");
        doubleLinkList.printOutBackward();
        
        assertEquals(2, doubleLinkList.getLength());
    }
    
    @Test
    public void testAddLast() {
        DoubleLinkedList<String> doubleLinkList = new DoubleLinkedList<>();
        
        doubleLinkList.addLast("1");
        doubleLinkList.addLast("2");
        
        assertEquals(2, doubleLinkList.getLength());
    }
    
    @Test
    public void testInsert() {
        DoubleLinkedList<String> doubleLinkList = new DoubleLinkedList<>();
        
        doubleLinkList.insert(0, "1");
        doubleLinkList.insert(0, "2");
        doubleLinkList.insert(0, "3");
        doubleLinkList.insert(0, "4");
        doubleLinkList.printOutForward();
        
        assertEquals(4, doubleLinkList.getLength());
    }
}
