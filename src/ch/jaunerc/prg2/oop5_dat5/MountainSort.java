/* Copyright 2015 Hochschule Luzern - Technik & Architektur */
package ch.jaunerc.prg2.oop5_dat5;

import java.util.ArrayList;
import java.util.List;

/**
 * Check natural and special order of mountains.
 * @author Peter Sollberger (peter.sollberger@hslu.ch)
 */
public final class MountainSort {
    
    /**
     * Demo.
     * @param args  not used.
     */
    public static void main(String[] args) {
        final List<Mountain> mountains = new ArrayList<>();
        
        mountains.add(new Mountain("Weisshorn", 2653)); // Arosa
        mountains.add(new Mountain("Weisshorn", 4505)); // Wallis
        mountains.add(new Mountain("Pilatus", 2128));
        mountains.add(new Mountain("Rigi", 1797));
        mountains.add(new Mountain("Stanserhorn", 1898));
        mountains.add(new Mountain("Titlis", 3238));
        mountains.add(new Mountain("Bürgenstock", 1128));
        System.out.println("\nEingabereihenfolge: \n " + mountains);

        mountains.sort(null);
        System.out.println("\nAlfabetisch nach Namen\n " + mountains);

        mountains.sort(new HeightComparator());
        System.out.println("\nnach aufsteigender Höhe: \n " + mountains);
    }
}
