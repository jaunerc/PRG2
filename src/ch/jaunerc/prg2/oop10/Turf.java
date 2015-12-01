package ch.jaunerc.prg2.oop10;

/**
 *
 * @author jaunerc
 */
public class Turf {

    public static void main(String[] args) {
        Synch starterBox = new Latch();
        for (int i = 1; i < 6; i++) {
            new Thread(new RaceHorse(i, starterBox)).start();
        }
        starterBox.release();
    }
}
