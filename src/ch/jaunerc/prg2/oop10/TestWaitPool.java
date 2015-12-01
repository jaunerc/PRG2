package ch.jaunerc.prg2.oop10;

/**
 *
 * @author jaunerc
 */
public class TestWaitPool {

    public static void main(String[] args) {
        Object lock = new Object();
        MyWaiter waiter = new MyWaiter(lock);
        new Thread(waiter).start();
        
        try {
            Thread.sleep(1000);
            
        } catch (InterruptedException ex) {
            /* handling...*/
        }
        synchronized(lock) {
            lock.notify();
        }
    }
}
