/*
 * License header jaunerc
 */
package ch.jaunerc.prg2.trees;

import java.util.ArrayList;

/**
 * This class represents a tree data structure. 
 * @author jaunerc
 */
public class Tree {
    private Node root;
    private int order;
    
    /**
     * Create a new tree object.
     * @param rootData for the root node
     */
    public Tree(final String rootData) {
        root = new Node(rootData);
        order = 10;
    }
    
    /**
     * Create a new tree object. It creates a root node with the data of "root"
     */
    public Tree() {
        this("root");
    }

    /**
     * Get the order of this tree.
     * @return the order of this tree
     */
    public int getOrder() {
        return order;
    }
    
    /**
     * Set the order of this tree.
     * @param order value for the tree
     */
    public void setOrder(int order) {
        this.order = order;
    }
    
    /**
     * Create a node with the given data and add it to the root node.
     * @param data for the new node
     */
    public void addNode(final String data) {
        root.addChild(new Node(data));
    }
    
    /**
     * Get the height of the tree. Height means the depth of the deepest node 
     * in the tree.
     * @return the height of the tree
     */
    public int height() {
        return calcHighestDepth(root);
    }
    
    /**
     * Calculate the height of the tree. This method checks recursively the depth of every node
     * lower than the first given node. The highest value will be returned.
     * @param curr current node to check
     * @return the highest depth from the current node
     */
    private int calcHighestDepth(final Node curr) {
        int res = curr.depth();
        int tmp = 0;
        
        if(curr.hasChilds()) {
            for(Node n : curr.childs) {
                if((tmp = calcHighestDepth(n)) > res) {
                    res = tmp;
                }
            }
        }
        
        return res;
    }
    
    public void printOut() {
        iterate(root);
    }
    
    private void iterate(Node node) {
        if(node.hasChilds()) {
            for(Node n : node.childs) {
                iterate(n);
            }
        }
        System.out.println(node.value);
    }
    
    /**
     * This class represents a node in the tree structure.
     */
    private class Node {
        public String value;
        public Node parent;
        public ArrayList<Node> childs;
        
        /**
         * Create a new Node.
         * @param value of the node
         * @param parent node of this node
         * @param childs child nodes will be added to this list
         */
        public Node(final String value, final Node parent, final ArrayList<Node> childs) {
            this.value = value;
            this.parent = parent;
            this.childs = childs;
        }

        public Node(final String value) {
            this(value, null, new ArrayList<>());
        }

        public void addChild(final Node n) {
            if(childs.size() < order) {
                n.parent = this;
                childs.add(n);
            }
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
}
