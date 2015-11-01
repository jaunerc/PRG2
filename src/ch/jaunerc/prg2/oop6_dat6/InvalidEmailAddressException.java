package ch.jaunerc.prg2.oop6_dat6;

/**
 *
 * @author jaunerc
 */
public class InvalidEmailAddressException extends IllegalArgumentException{
    
    public InvalidEmailAddressException(String s) {
        super(s);
    }
}
