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
    
    public static void main(String[] args) {
        Bank bank = new Bank("ubs");
        bank.printAccounts();
    }
    
    public Bank(final String name) {
        this.name = name;
        accountList = new LinkedList<>();
        accountList.insert(new Spar(1000, 1.2, 4000));
        accountList.insert(new Spar(1000, 1.2, 4000));
    }
    
    public String getName() {
        return name;
    }
    
    public void printAccounts() {
        accountList.print();
    }
}
