/*
 * License header jaunerc
 */
package ch.jaunerc.prg2.oop2_dat2;

/**
 *
 * @author jaunerc
 */
public class RingBuffer<T> {
    private final int size;
    private int numberElements;
    private int head;
    private int tail;
    
    private T[] queue;
    
    public RingBuffer(final int size) {
        this.size = size;
        numberElements = 0;
        head = 0;
        tail = 0;
        queue = (T[]) new Object[size];
    }
    
    public void enqueue(final T el) {
        numberElements++;
        if(tail == size) {
            tail = 0;
        }
        queue[tail] = el;
        tail++;
    }
    
    public T dequeue() {
        numberElements--;
        if(head == size) {
            head = 0;
        }
        T el = queue[head];
        head++;
        return el;
    }
    
    public boolean isEmpty() {
        return numberElements == 0;
    }
    
    public boolean isFull() {
        return numberElements == size;
    }
}
