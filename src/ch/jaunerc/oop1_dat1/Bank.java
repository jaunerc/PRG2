/*
 * License header jaunerc
 */
package ch.jaunerc.oop1_dat1;

/**
 *
 * @author jaunerc
 */
public class Bank {
    private String name;
    private LinkedList<Account> accountList;
    
    public Bank(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
