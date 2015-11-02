package ch.jaunerc.prg2.oop7;

/**
 *
 * @author Cyrill Jauner
 */
public class Cube implements Comparable<Cube>{
    private int number;
    private int s1, s2, s3;

    public Cube(int number, int s1, int s2, int s3) {
        this.number = number;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
    
    /**
     * Calculate the volume of the cube. If the volume is higher or lower than the integer bounds it returns
     * -1.
     * @return the volume of the cube. 
     */
    public int getVolume() {
        int volume = -1;
        long v = ((long)s1*s2*s3);
        if(isInteger(v)) {
            volume = (int) v;
        }
        return volume;
    }
    
    /**
     * Calculate the surface of the cube. If the surface is higher or lower than the integer bounds it returns
     * -1.
     * @return the surface of the cube.
     */
    public int getSurface() {
        int surface = -1;
        long s = (2*s1*s2) + (2*s1*s3) + (2*s2*s3);
        if(isInteger(s)) {
            surface = (int) s;
        }
        return surface;
    }
    
    /**
     * Proove if the given long is in the range of an integer.
     * @param l the value to check.
     * @return wheter the value is in the range of an integer.
     */
    private boolean isInteger(long l) {
        boolean res = true;
        if(l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            res = false;
        }
        return res;
    }
    
    public int getMaxDimension() {
        int max = s1;
        if(max < s2) {
            max = s2;
        } else if(max < s3) {
            max = s3;
        }
        return max;
    }

    @Override
    public String toString() {
        String separator = "---------------------------";
        return separator+"\nCUBE "+number+"\nSlides: "+s1+" "+s2+" "+s3+" \nVolume="+getVolume()+"\nSurface="+getSurface()+"\n";
    }
    
    /**
     * Generate a hash code for this cube. This method calculates a hashCode with the volume of the cube. 
     * @return hash code value.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.getVolume();
        return hash;
    }
    
    /**
     * Check if the given object is equals to this. Two cubes are equal if they had the same volume.
     * @param obj to check with this.
     * @return wheter obj is equal to this or not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cube other = (Cube) obj;
        if (this.getVolume() != other.getVolume()) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Cube o) {
        if(this == o) {
            return 0;
        }
        return Integer.compare(getVolume(), o.getVolume());
    }
}
