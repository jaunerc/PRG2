package ch.jaunerc.prg2.oop4_dat4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author jaunerc
 */
public class SwitchGui extends JFrame implements ActionListener{

    private JLabel label = new JLabel("The switch is OFF.");
    private JButton buttonOn = new JButton("On");
    private JButton buttonOff = new JButton("Off");
    private JButton btnClose = new JButton("Close");

    public SwitchGui() {
        super("Switch");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(200, 150);
        setLayout(new BorderLayout());
        
        btnClose.addActionListener(this);
        
        add(buttonOn, BorderLayout.NORTH);
        add(label, BorderLayout.CENTER);
        add(buttonOff, BorderLayout.SOUTH);
        add(btnClose, BorderLayout.EAST);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new SwitchGui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnClose) {
            System.exit(0);
        }
    }
}
