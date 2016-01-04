package ch.jaunerc.prg2.mep;

/**
 *
 * @author jaunerc
 */
public class FalseAnswerException extends Exception {
    
    public FalseAnswerException(String right, String wrong) {
        super("Expected: "+right+" but got: "+wrong);
    }
}
