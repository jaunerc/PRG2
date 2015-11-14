package ch.jaunerc.prg2.oop8;

/**
 *
 * @author jaunerc
 */
public class Calculate implements Runnable {
    
    private long sum = 0;
    private boolean fini;
 
    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            sum += i;
        }
        fini = true;
    }
    
    public long sum() {
        return sum;
    }
    
    public boolean finished() {
        return fini;
    }
    
}
