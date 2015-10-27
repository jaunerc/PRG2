/* Copyright 2015 Hochschule Luzern - Technik & Architektur */
package ch.jaunerc.prg2.oop5_dat5;

import java.util.Objects;

/**
 * 
 * @author Peter Sollberger (peter.sollberger@hslu.ch)
 */
public final class Mountain implements Comparable<Mountain> {

    private final String name;
    private final int height;

    public Mountain(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return name + " " + height;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + this.height;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mountain other = (Mountain) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Mountain other) {
        //return -1;
        // hier steht Ihre Implementation
        if(this == other) {     // test identity
            return 0;
        }
        int nameRes = name.compareTo(other.name);
        if(nameRes == 0) {
            return Integer.compare(height, other.height);
        } else {
            return nameRes;
        }
    }
}
