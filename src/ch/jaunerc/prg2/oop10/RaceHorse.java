package ch.jaunerc.prg2.oop10;

/**
 *
 * @author jaunerc
 */
public class RaceHorse implements Runnable {

    private Synch startSignal;
    private int nr;

    public RaceHorse(int nr, Synch startSignal) {
        this.nr = nr;
        this.startSignal = startSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.acquire();
            Thread.sleep((long) (3000.0 * Math.random()));
        } catch (InterruptedException e) {
            /* handling...*/
        }
        System.out.println("Rennpferd " + nr + " ist im Ziel.");
    }
}
