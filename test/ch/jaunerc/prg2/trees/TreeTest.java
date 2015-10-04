/*
 * License header jaunerc
 */
package ch.jaunerc.prg2.trees;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaunerc
 */
public class TreeTest {
    
    public TreeTest() {
    }

    /**
     * Test of addNodeToRoot method, of class Tree.
     */
    @Test
    public void testHeight() {
        Tree tree = new Tree();
        tree.addNode("b");
        tree.addNode("c");
        tree.printOut();
        
        assertEquals(1, tree.height());
    }
}
