/*
 * License header jaunerc
 */
package ch.jaunerc.prg2.oop3_dat3;

/**
 * Interface for list classes. It supports only Integers.
 * @author jaunerc
 */
public interface IList {
    
    /**
     * Add an integer object to the list.
     * @param obj to add to the list
     */
    void add(final Integer obj);
    
    /**
     * Remove the integer object from the list, if it exists.
     * @param obj to remove from the list
     * @return wheter the obj could be removed or not
     */
    boolean remove(final Integer obj);
    
    /**
     * Removes the first integer object with the value of i from the list.
     * @param i value to look for
     * @return wheter a object was removed or not
     */
    boolean removeValue(final int i);
    
    /**
     * Removes all integer object with the value of i in the list.
     * @param i value to look for
     * @return wheter all objects with i were removed or not
     */
    boolean removeValues(final int i);
    
    /**
     * Get the size of the list.
     * @return size of the list
     */
    int size();
    
    /**
     * Check if a integer object with the value of i exists.
     * @param i value to look for
     * @return wheter a object with the value of i exists or not
     */
    boolean exists(final int i);
    
    /**
     * Print out all values of the list to the console.
     */
    void print();
}
