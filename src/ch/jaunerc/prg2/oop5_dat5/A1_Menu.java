package ch.jaunerc.prg2.oop5_dat5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author jaunerc
 */
public class A1_Menu extends JFrame{
    
    public static void main(String[] args) {
        new A1_Menu();
    }
    
    private JMenuBar menuBar;
    private JMenu menuFile, menuHelp;
    private JMenuItem itemFileNew, itemFileOpen, itemFileExit;
    
    public A1_Menu() {
        super("A1 Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 300));
        setLayout(new BorderLayout());
        
        initComponents();
        addActionListeners();
        setVisible(true);
    }
    
    private void initComponents() {
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuHelp = new JMenu("Help");
        itemFileNew = new JMenuItem("New");
        itemFileOpen = new JMenuItem("Open");
        itemFileExit = new JMenuItem("Exit");
        
        menuFile.add(itemFileNew);
        menuFile.add(itemFileOpen);
        menuFile.addSeparator();
        menuFile.add(itemFileExit);
        
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        
        setJMenuBar(menuBar);
    }
    
    private void addActionListeners() {
        MenuListener listener = new MenuListener();
        itemFileExit.addMouseListener(listener);
        menuHelp.addMouseListener(listener);
    }
    
    private void showDialog() {
        JOptionPane.showMessageDialog(this, "Copyright", "Not helpful", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private class MenuListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getSource() == itemFileExit) {
                System.exit(0);
            } else if(e.getSource() == menuHelp) {
                showDialog();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
        
    }
}
