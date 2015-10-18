package ch.jaunerc.prg2.oop4_dat4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jaunerc
 */
public class Calculator extends javax.swing.JFrame implements ActionListener {

    private int operand1, operand2, result, operator, state;
    private boolean newOperand;

    /**
     * Creates new form Calculator
     */
    public Calculator() {
        initComponents();
        addActionListener();

        operand1 = 0;
        operand2 = 0;
        result = 0;
        operator = 0;
        state = 0;
        newOperand = false;
    }

    /**
     * Register the action listener on all buttons.
     */
    private void addActionListener() {
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        jButton5.addActionListener(this);
        jButton6.addActionListener(this);
        jButton7.addActionListener(this);
        jButton8.addActionListener(this);
        jButton9.addActionListener(this);
        jButton10.addActionListener(this);
        jButton11.addActionListener(this);
        jButton12.addActionListener(this);
        jButton13.addActionListener(this);
        jButton14.addActionListener(this);
        jButton15.addActionListener(this);
        jButton16.addActionListener(this);
        jButton17.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(250, 210));

        jPanel1.setLayout(new java.awt.GridLayout(0, 4));

        jButton1.setText("7");
        jPanel1.add(jButton1);

        jButton2.setText("8");
        jPanel1.add(jButton2);

        jButton3.setText("9");
        jPanel1.add(jButton3);

        jButton4.setText("/");
        jPanel1.add(jButton4);

        jButton5.setText("4");
        jPanel1.add(jButton5);

        jButton6.setText("5");
        jPanel1.add(jButton6);

        jButton7.setText("6");
        jPanel1.add(jButton7);

        jButton8.setText("*");
        jPanel1.add(jButton8);

        jButton9.setText("3");
        jPanel1.add(jButton9);

        jButton10.setText("2");
        jPanel1.add(jButton10);

        jButton11.setText("1");
        jPanel1.add(jButton11);

        jButton12.setText("-");
        jPanel1.add(jButton12);

        jButton13.setText("0");
        jPanel1.add(jButton13);

        jButton14.setText("S");
        jPanel1.add(jButton14);

        jButton15.setText("=");
        jPanel1.add(jButton15);

        jButton16.setText("+");
        jPanel1.add(jButton16);

        jButton17.setText("C");
        jPanel1.add(jButton17);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jTextField1.setEditable(false);
        jTextField1.setText("0");
        getContentPane().add(jTextField1, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        char ch = e.getActionCommand().charAt(0);
        int digit = ch - '0';

        switch (ch) {
            case '+':
            case '-':
            case '*':
            case '/':
                operate(ch);
                break;
            case '=':
                startCalculate();
                break;
            case 'C':
                changeText("0", true);
                resetOperators();
                break;
            case 'S':
                signum();
                break;
            default:
                if (newOperand) {
                    changeText("" + digit, true);
                    newOperand = false;
                } else {
                    changeText("" + digit, false);
                }
                if(state == 2) {
                    state = 0;
                }
        }
    }

    private void operate(char ch) {
        try {
            operand1 = Integer.parseInt(jTextField1.getText());
            operator = ch;
        } catch (Exception ex) {
            resetOperators();
        }
        newOperand = true; // the current value will be replaced, when a new digit was klicked
        state = 1;
    }

    private void resetOperators() {
        operand1 = 0;
        operand2 = 0;
        operator = 0;
        state = 0;
    }

    private void startCalculate() {
        try {
            if(state == 1) {
                operand2 = Integer.parseInt(jTextField1.getText());
                state = 2;
            }
            if (calculate()) {
                changeText("" + result, true);
                operand1 = result;
            } else {
                changeText("Error", true);
            }
        } catch (Exception ex) {
            resetOperators();
        }
    }

    private void signum() {
        char first = (jTextField1.getText()).charAt(0);
        if (first == '-') {
            int num = Integer.parseInt(jTextField1.getText());
            num *= -1;
            changeText("" + num, true);
        } else {
            changeText("-" + jTextField1.getText(), true);
        }
    }

    /**
     * Change the text of the text field. If the delOldValue parameter is false, the String s will be appended to the old text. Otherwise the String s will replace the old text.
     *
     * @param s String to write to the text field.
     * @param delOldValue wheter the new text should replace the old one.
     */
    private void changeText(String s, boolean delOldValue) {
        String text = s;

        if (!jTextField1.getText().equals("0") && !delOldValue) {
            try {
                text = "" + Integer.parseInt(jTextField1.getText() + text);
            } catch (NumberFormatException e) {
                text = jTextField1.getText();
            }
        }
        jTextField1.setText(text);
        jTextField1.repaint();
    }

    private boolean calculate() {
        boolean res = false;
        long tmp = 0;

        switch (operator) {
            case '+':
                tmp = (long) operand1 + operand2;
                break;
            case '-':
                tmp = (long) operand1 - operand2;
                break;
            case '*':
                tmp = (long) operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    tmp = (long) operand1 / operand2;
                } else {
                    tmp = Long.MAX_VALUE;
                }
                break;
            default:
                tmp = operand2;
        }

        if (tmp <= Integer.MAX_VALUE && tmp >= Integer.MIN_VALUE) {
            result = (int) tmp;
            res = true;
        }
        System.out.println("op1: " + operand1 + " " + operator + " op2: " + operand2);
        return res;
    }
}