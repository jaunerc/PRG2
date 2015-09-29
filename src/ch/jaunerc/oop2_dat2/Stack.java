/*
 * License header jaunerc
 */
package ch.jaunerc.oop2_dat2;

import java.util.ArrayList;

/**
 * Implements a stack based on a ArrayList.
 * @author jaunerc
 */
public class Stack<T> {
    private int top;
    
    private ArrayList<T> stack;
    
    /**
     * Create a new stack object.
     */
    public Stack() {
        top = 0;
        stack = new ArrayList<>();
    }
    
    /**
     * Adds an element on the top of the stack.
     * @param el to push on the stack
     */
    public void push(T el) {
        stack.add(el);
        top++;
    }
    
    /**
     * Get the element on the top of the stack. This method will remove
     * the returned element from the stack.
     * @return element on the top
     */
    public T pop() {
        top--;
        T el = stack.get(top);
        stack.remove(top);
        
        return el;
    }
    
    /**
     * Wheter the stack is empty or not.
     * @return wheter the stack is empty or not
     */
    public boolean isEmpty() {
        return top == 0;
    }
    
    /**
     * Get the number of elements on the stack.
     * @return the number of elements
     */
    public int getSize() {
        return stack.size();
    }
}
