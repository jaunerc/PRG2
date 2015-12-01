package ch.jaunerc.prg2.oop10;

/**
 *
 * @author jaunerc
 */
public class Latch implements Synch {

    private boolean latched = false;

    @Override
    public void acquire() throws InterruptedException {
        //...Latch anfordern
        while(!latched) {
            synchronized(this) {
                wait();
            }
        }
    }

    @Override
    public void release() {
        //...Latch freigeben
        latched = true;
        synchronized(this) {
            notifyAll();
        }
    }
}
