package ch.jaunerc.prg2.oop4_dat4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author jaunerc
 */
public class CircleGui extends JFrame implements ChangeListener{

    public static void main(String[] args) {
        new CircleGui();
    }
    
    private JSlider slider = new JSlider(0, 100);
    private CirclePanel panel = new CirclePanel();

    public CircleGui() {
        super("Draw a circle");

        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setValue(panel.xPercentage);
        slider.addChangeListener(this);
        
        add(slider, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        
        setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        panel.setXPercentage(slider.getValue());
    }

    private class CirclePanel extends JPanel {

        int xPercentage = 50;

        public void setXPercentage(int xPercentage) {
            this.xPercentage = xPercentage;
            repaint();
        }

        @Override
        public void paint(Graphics g) {
            int size = this.getWidth();
            super.paint(g);
            
            if(size > this.getHeight()) {
                size = this.getHeight();
            }
            
            g.setColor(Color.red);
            g.fillOval(0, 0, xPercentage * size / 100, xPercentage * size / 100);
        }
    }
}
