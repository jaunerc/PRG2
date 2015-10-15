package ch.jaunerc.prg2.oop4_dat4;

import java.awt.Color;
import java.util.Objects;

/**
 *
 * @author jaunerc
 */
public class Balloon {
    private String text;
    private int size;
    private Color color;
    
    public Balloon(String text) {
        this.text = text;
        size = 0;
        color = Color.BLUE;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void blowUp() {
        size += 5;
    }
    
    public void deflate() {
        size = 0;
    }
    
    @Override
    public String toString() {
        return "";
    }
    
    @Override
    public boolean equals(Object other) {
        // 1. test identity
        if(other == this) {
            return true;
        }
        // 2. test null
        if(other == null) {
            return false;
        }
        // 3. test casting
        if(other.getClass() != getClass()) {
            return false;
        }
        // 4. test fields
        if(Objects.equals(this.text, ((Balloon)other).text) && 
                Objects.equals(this.color, ((Balloon)other).color)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.text);
        hash = 83 * hash + Objects.hashCode(this.color);
        return hash;
    }
}
