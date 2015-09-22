/*
 * License header jaunerc
 */
package ch.jaunerc.oop1_dat1;

/**
 *
 * @author jaunerc
 */
public class Spar extends Account {
    private double maxOut;
    
    public Spar(final double saldo, final double rate, final double maxOut) {
        super(saldo, rate);
        this.maxOut = maxOut;
    }
    
    @Override
    public void payOut(final double value) {
        if(value <= maxOut) {
            super.payOut(value);
        }
    }
    
    @Override
    public void print() {
        System.out.print("Spar - no: "+getNumber());
        System.out.print(" - saldo: "+getSaldo());
        System.out.print(" - rate: "+getRate());
        System.out.println(" - max out: "+maxOut);
    }
}
