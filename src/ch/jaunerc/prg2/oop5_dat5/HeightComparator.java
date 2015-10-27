/* Copyright 2015 Hochschule Luzern - Technik & Architektur */
package ch.jaunerc.prg2.oop5_dat5;

import java.util.Comparator;

/**
 * Compares to mountains according there heights.
 * @author Peter Sollberger (peter.sollberger@hslu.ch)
 */
public class HeightComparator implements Comparator<Mountain> {

    @Override
    public int compare(Mountain b1, Mountain b2) {
        //return -1;
        // hier steht Ihre Implementation
        return Integer.compare(b1.getHeight(), b2.getHeight());
    }
}
