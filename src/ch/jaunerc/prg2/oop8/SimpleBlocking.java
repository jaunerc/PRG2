package ch.jaunerc.prg2.oop8;

/**
 *
 * @author jaunerc
 */
public class SimpleBlocking {

    public static void main(String[] args) {
        Calculate calc = new Calculate();
        Thread t = new Thread(calc);
        t.start();
 // Version 1
        //while (!calc.finished());
        try {
 // Version 2
             //Thread.sleep(1);
            // Version 3
            t.join();
        } catch (InterruptedException ex) {
           ex.printStackTrace();
        }
        System.out.println("Summe = " + calc.sum());
    }
}
