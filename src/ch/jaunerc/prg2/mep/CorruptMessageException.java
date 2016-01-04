package ch.jaunerc.prg2.mep;

/**
 *
 * @author jaunerc
 */
public class CorruptMessageException extends Exception {
    
    public CorruptMessageException(String msg) {
        super("The message is not in the correct format: "+msg);
    }
}
