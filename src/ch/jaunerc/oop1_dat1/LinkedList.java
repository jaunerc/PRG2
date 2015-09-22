package ch.jaunerc.oop1_dat1;

/**
 *
 * @author Cyrill Jauner
 */
public class LinkedList<T> {
    private ListNode<T> head;
    
    /**
     * Create a new linked list.
     */
    public LinkedList() {
        head = null;
    }
    
    /**
     * Check if the list is empty.
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return (head == null);
    }
    
    /**
     * Check if the list contains the given data.
     * @param data to check
     * @return true if the list contains the data
     */
    public boolean contains(final T data) {
        return (find(data) != null);
    }
    
    /**
     * Find the first node who contains the given data. It returns null if the data does not exist.
     * @param data to check for
     * @return the founded node or null
     */
    private ListNode<T> find(final T data) {
       ListNode<T> curr = head;
       
       while((curr != null) && data.equals(curr.getData())) {
           curr = curr.getNext();
       }
       
       return curr;
    }
    
    /**
     * Insert a new node to the list.
     * @param data to use for
     */
    public void insert(final T data) {
        head = new ListNode<T>(data, head);
    }
    
    /**
     * Appends a new node to the end of the list.
     * @param data to use for
     */
    public void addLast(final T data) {
        ListNode<T> curr = head;
        ListNode<T> next = new ListNode<>(data, null);
        
        while(curr != null) {
            curr = curr.getNext();
        }
        
        curr.setNext(next);
    }
    
    /**
     * Remove the first node who contains the given data. The return value is true when a matching node
     * was found.
     * @param data to delete
     * @return if a node was found
     */
    public boolean remove(final T data) {
        ListNode<T> curr = head;
        ListNode<T> prev = null;
        boolean res = false;
        
        while((curr != null) && data.equals(curr.getData())) {
            prev = curr;
            curr = curr.getNext();
        }
        
        if(curr != null) {
            if(curr == head) {
                head = curr.getNext();
            } else {
                prev.setNext(curr.getNext());
            }
            res = true;
        }
        
        return res;
    }
    
    /**
     * Get the number of nodes in the list.
     * @return the number of nodes
     */
    public int getLength() {
        ListNode<T> curr = head;
        int count = 0;
        
        while(curr != null) {
            count++;
            curr = curr.getNext();
        }
        
        return count;
    }
    
    /**
     * Invoke the toString method of the data for all nodes. Write all string to the console.
     */
    public void print() {
        ListNode<T> curr = head;
        
        while(curr != null) {
            System.out.println(curr.getData().toString());
            curr = curr.getNext();
        }
    }
}
