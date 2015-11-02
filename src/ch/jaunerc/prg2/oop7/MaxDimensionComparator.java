/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jaunerc.prg2.oop7;

import java.util.Comparator;

/**
 *
 * @author Cyrill Jauner
 */
public class MaxDimensionComparator implements Comparator<Cube>{

    @Override
    public int compare(Cube o1, Cube o2) {
        if(o1 == o2) {
            return 0;
        }
        return Integer.compare(o1.getMaxDimension(), o2.getMaxDimension());
    }
}
