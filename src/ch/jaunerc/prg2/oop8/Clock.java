package ch.jaunerc.prg2.oop8;

import java.util.Date;
import javax.swing.JApplet;
import javax.swing.JLabel;

/**
 *
 * @author jaunerc
 */
public class Clock extends JApplet {
    
    private JLabel label;
    
    /**
     * Initialization method that will be called after the applet is loaded into the browser.
     */
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
        label = new JLabel();
        setCurrentTime();
    }
    
    private void setCurrentTime() {
        Date date = new Date();
        label.setText(date.toString());
    }

    // TODO overwrite start(), stop() and destroy() methods
    @Override
    public void start() {
        super.start();
    }
}
