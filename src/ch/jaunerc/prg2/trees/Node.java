/*
 * License header jaunerc
 */
package ch.jaunerc.prg2.trees;

import java.util.ArrayList;

/**
 *
 * @author jaunerc
 */
public class Node {

    public String value;
    public Node parent;
    public ArrayList<Node> childs;

    public Node(final String value, final Node parent, final ArrayList<Node> childs) {
        this.value = value;
        this.parent = parent;
        this.childs = childs;
    }

    public Node(final String value) {
        this(value, null, new ArrayList<>());
    }

    public void addChild(final Node n) {
        n.parent = this;
        childs.add(n);
    }

    public void removeChild(final Node n) {
        childs.remove(n);
    }

    public void removeChildAt(final int i) {
        childs.remove(i);
    }

    public boolean hasChilds() {
        return !childs.isEmpty();
    }

    public int degree() {
        return childs.size();
    }

    public int depth() {
        Node p = parent;
        int depth = 0;

        while (p != null) {
            depth++;
            p = p.parent;
        }

        return depth;
    }
}