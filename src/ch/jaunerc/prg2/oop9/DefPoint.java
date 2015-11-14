package ch.jaunerc.prg2.oop9;

import java.awt.Point;

/**
 *
 * @author jaunerc
 */
public class DefPoint implements Runnable {
    
    private Point p;
    
    public DefPoint(Point p) {
        this.p = p;
    }

    @Override
    public void run() {
        synchronized(p) { // Korrektur
            int x = (int) (Math.random() * 1000), y = x;
            while (true) {
                p.x = x;
                p.y = y;
                int xc = p.x;
                int yc = p.y;
                if (xc != yc) {
                    System.out.println("Aha: x=" + xc + ", y=" + yc);
                }
            }
        }
    }

    public static void main(String[] args) {
        Point p = new Point();
        new Thread(new DefPoint(p)).start();
        new Thread(new DefPoint(p)).start();
    }

}
