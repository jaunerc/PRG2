/*
 * License header jaunerc
 */
package ch.jaunerc.prg2.oop2_dat2;

/**
 * A double linked list.
 * @author jaunerc
 */
public class DoubleLinkedList<T> {
    
    private Node<T> head;
    private Node<T> tail;
    
    /**
     * Create a new double linked list.
     */
    public DoubleLinkedList() {
        head = null;
        tail = null;
    }
    
    /**
     * Add an node on the head of the list.
     * @param data of the new node
     */
    public void addFirst(final T data) {
        Node<T> newNode = new Node<>(null, null, data);
        if(head == null) {
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
        }
        
        head = newNode;
    }
    
    /**
     * Add an node on the tail of the list.
     * @param data of the new node
     */
    public void addLast(final T data) {
        Node<T> newNode = new Node<>(null, null, data);
        if(tail == null) {
            head = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
        }
        
        tail = newNode;
    }
    
    /**
     * Add an node on the position i. This method will add the new node before
     * the current node on the position i.
     * @param i position for the new node
     * @param data of the new node
     */
    public void insert(final int i, final T data) {
        if(i == 0) {
            addFirst(data);
        } else if(i == (getLength() -1)) {
            addLast(data);
        } else {
            Node<T> curr = getNode(i);
            if(curr != null) {
                Node<T> newNode = new Node<>(curr.prev, curr, data);
                curr.prev.next = newNode;
                curr.prev = newNode;
            }
        }
    }
    
    /**
     * Get the node reference on the position i.
     * @param i position of the node in the list
     * @return node reference on the position i
     */
    private Node<T> getNode(final int i) {
        Node<T> n = head;
        
        for(int j = 0; j <= i && n != null; j++) {
            n = n.next;
        }
        
        return n;
    }
    
    /**
     * Get the length of the list.
     * @return length of the list
     */
    public int getLength() {
        Node<T> n = head;
        int count = 0;
        
        while(n != null) {
            count++;
            n = n.next;
        }
        
        return count;
    }
    
    /**
     * Wheter this list is empty or not.
     * @return true if this list has no nodes
     */
    public boolean isEmpty() {
        return (head == null);
    }
    
    /**
     * Print each node of the list to the console. This method starts with the first node.
     * It invokes the toString method of the node data to print to the console.
     */
    public void printOutForward() {
        Node<T> n = head;
        
        while(n != null) {
            System.out.println("el: "+n.getData().toString());
            n = n.next;
        }
    }
    
    /**
     * Print each node of the list to the console. This method starts with the last node.
     * It invokes the toString method of the node data to print to the console.
     */
    public void printOutBackward() {
        Node<T> n = tail;
        
        while(n != null) {
            System.out.println("el: "+n.getData().toString());
            n = n.prev;
        }
    }
    
    /**
     * A single node of the double linked list.
     * @param <T> 
     */
    private class Node<T> {
        
        public Node<T> prev;
        public Node<T> next;
        private T data;
        
        /**
         * Creates a new node object.
         * @param prev the previous node in the list
         * @param next the next node in the list
         * @param data of the node
         */
        public Node(final Node<T> prev, final Node<T> next, final T data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
        
        /**
         * Get the data of the node.
         * @return data of the node
         */
        public T getData() {
            return data;
        }
    }
}
