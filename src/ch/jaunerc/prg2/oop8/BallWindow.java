package ch.jaunerc.prg2.oop8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class provides a window for the ball simulation.
 * @author jaunerc
 */
public class BallWindow extends JFrame {
    
    private Canvas canvas;
    
    /**
     * Creates a new BallWindow object.
     */
    public BallWindow() {
        super("Ball simulation");
        setSize(600, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }
    
    /**
     * Set the window visible.
     */
    public void showWindow() {
        setVisible(true);
        canvas.run();
    }
    
    /**
     * Initialize the gui components.
     */
    private void initComponents() {
        canvas = new Canvas();
        add(canvas, BorderLayout.CENTER);
    }
    
    /**
     * This class provides a panel to draw the balls onto.
     */
    private class Canvas extends JPanel implements MouseListener, MouseMotionListener, Runnable {
        
        private ArrayList<Ball> balls;
        
        /**
         * Creates a new canvas object.
         */
        public Canvas() {
            balls = new ArrayList<>();
            addMouseListener(this);
            addMouseMotionListener(this);
            setBackground(Color.white);
        }
        
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawString("Balls: "+balls.size(), 500, 20); // draw the number of balls to the panel
            
            Iterator<Ball> iterator = balls.iterator();
            while(iterator.hasNext()) {
                Ball b = iterator.next();
                if(b.isAlive()) {
                    b.draw(g); // draw the current ball to the panel
                } else {
                    iterator.remove(); // the current ball is dead, so remove it
                }
            }
        }
        
        /**
         * Create a new random ball on the start position of the mouse click.
         * @param e event to indicate the mouse action.
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            balls.add(Ball.genRandomBall(e.getX(), e.getY(), getHeight()));
        }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }

        @Override
        public void mouseDragged(MouseEvent e) {
            mouseClicked(e);
        }
        
        /**
         * Create random balls on every position that the dragged mouse pointer passed.
         * @param e event to indicate the mouse action.
         */
        @Override
        public void mouseMoved(MouseEvent e) { }
        
        /**
         * Start the repainting.
         */
        @Override
        public void run() {
            while (true) {
                repaint();
            }
        }
    }
}
