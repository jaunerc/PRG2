/*
 * License header jaunerc
 */
package ch.jaunerc.prg2.oop1_dat1;

/**
 *
 * @author jaunerc
 */
public class Account {
    private static int count = 0;
    
    private int no;
    private double saldo;
    private double rate;
    
    public static int getCount() {
        return count;
    }
    
    public Account(final double saldo, final double rate) {
        this.saldo = saldo;
        this.rate = rate;
        no = (count++);
    }
    
    public Account() {
        this(0,0);
    }
    
    public int getNumber() {
        return no;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public double getRate() {
        return rate;
    }
    
    public void payIn(final double value) {
        saldo += value;
    }
    
    public void payOut(final double value) {
        saldo -= value;
    }
    
    public void print() {
        System.out.println("account - no: "+no+" - saldo: "+saldo+" - rate: "+rate);
    }
    
    @Override
    public String toString() {
        return "account - no: "+no+" - saldo: "+saldo+" - rate: "+rate;
    }
}
