package ch.hslu.prg2.trees;

/**
 * ETH Zürich; Leitprogramm; Binäre Suchbäume ----- Das ist die Klasse eines
 * einzelnen Knotens des Binären Suchbaums.
 *
 * @author Björn Steffen, Timur Erdag, Christina Class, Martin Klaper
 * @version 2.0
 */
public class BinSearchTree {

    private int key;
    private BinSearchTree left, right;

    /**
     * getter Methode für den Schlüssel
     *
     * @param key Schlüsselwert
     */
    public BinSearchTree(int key) {
        this.key = key;
        left = null;
        right = null;
    }

    /**
     * getter Methode für den Schlüssel
     *
     * @param key Schlüsselwert
     * @param left linker Nachbar
     * @param right rechter Nachbar
     */
    public BinSearchTree(int key, BinSearchTree left, BinSearchTree right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    /**
     * getter Methode für den Schlüssel
     *
     * @return den Schlüsselwert
     */
    public int getKey() {
        return key;
    }

    /**
     * setter Methode für den Schlüssel
     *
     * @param value der neue Schl�sselwert
     */
    public void setKey(int value) {
        key = value;
    }

    /**
     * getter Methode für das rechte Kind
     *
     * @return rechtes Kind
     */
    public BinSearchTree getRight() {
        return right;
    }

    /**
     * setter Methode für das rechte Kind
     *
     * @param newRight Referenz auf neues rechtes Kind
     */
    public void setRight(BinSearchTree newRight) {
        right = newRight;
    }

    /**
     * getter Methode für das linke Kind
     *
     * @return linkes Kind
     */
    public BinSearchTree getLeft() {
        return left;
    }

    /**
     * setter Methode für das linke Kind
     *
     * @param newLeft Referenz auf neues linkes Kind
     */
    public void setLeft(BinSearchTree newLeft) {
        left = newLeft;
    }

    /**
     * Inorder Ausgabe für den binären Suchbaum
     *
     * @param node Wurzelknoten des binären Suchbaums, der mit inorder
     * ausgegeben werden soll
     */
    public void inorder(BinSearchTree node) {
        if (node != null) {
            inorder(node.getLeft());
            System.out.print(" " + node.getKey() + " ");
            inorder(node.getRight());
        }
    }

    /**
     * Die Methode gibt zurück, ob der übergebene Wert im Baum vorhanden ist.
     *
     * @param node die Wurzel des Suchbaumes
     * @param key der Suchschlüssel
     * @return ob die Suche erfolgreich war
     */
    // Implementiere diese Methode nach den Vorgaben der Aufgabe 4.3.
    // Geben Sie true zurück, wenn der Wert gefunden wurde,
    // false sonst.
    public boolean search(BinSearchTree node, int key) {
        if(node != null) {
            if(key < node.key) {
                return search(node.left, key);         // search on the left side
            } else {
                if(key > node.key) {
                    return search(node.right, key);    // search on the right side
                } else {
                    return true;
                }
            }
        }
        
        return false;
    }

    /**
     * Diese Methode fügt einen neuen Knoten mit dem Schlüssel key in den
     * binären Suchbaum ein. Aufruf dieser Methode für einen Baum mit Wurzel
     * root mit dem Wert 10: root = insert (root, 10);
     *
     * @param node Wurzel des Baumes
     * @param key Schlüsselwert
     * @return die neue Wurzel des Baumes.
     */
    // Implementieren Sie diese Methode nach den Vorgaben der Aufgabe.
    // Geben Sie zur Kontrolle den Wert jedes besuchten Knoten aus!
    public BinSearchTree insert(BinSearchTree node, int key) {
        if(node != null) {
            System.out.print(node.key+" ");
            if(key < node.key) {
                node.left = insert(node.left, key);
            } else {
                node.right = insert(node.right, key);
            }
        } else {
            return new BinSearchTree(key);
        }
        return node;
    }

    /**
     * Diese Methode löscht alle Knoten mit dem Schlüssel key in dem binären
     * Suchbaum. (Aufgabe 4.13. (Additum)) Aufruf dieser Methode für einen Baum
     * mit Wurzel root mit dem Schlüsselwert 10: root = delete(root, 10);
     *
     * @param node Wurzel des Baumes
     * @param key Schlüsselwert
     * @return die neue Wurzel des Baumes.
     */
    // Als Additum kann auch das Löschen implementiert werden
    // als //# taucht immer die Zeile des Pseudocodes in der Musterlösung des Leitprogramms auf
    public BinSearchTree delete(BinSearchTree node, int key) {
        return node;
    }
}
