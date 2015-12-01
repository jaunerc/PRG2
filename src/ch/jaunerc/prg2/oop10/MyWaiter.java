package ch.jaunerc.prg2.oop10;

/**
 *
 * @author jaunerc
 */
public class MyWaiter implements Runnable {

    private final Object lock;

    public MyWaiter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("warten...");
        synchronized (lock) {   // synchronize lock object
            try {
                lock.wait();
            } catch (InterruptedException ex) {
                /* handling...*/
            }
        }
        System.out.println("...aufgewacht");
    }
}
