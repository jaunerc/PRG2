package ch.jaunerc.prg2.oop10;

/**
 *
 * @author jaunerc
 */
public interface Synch {
    
    public void acquire() throws InterruptedException;
    
    public void release();
}
