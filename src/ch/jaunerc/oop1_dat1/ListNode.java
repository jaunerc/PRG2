package ch.jaunerc.oop1_dat1;

/**
 *
 * @author Cyrill Jauner
 */
public class ListNode<T> {
    private T data;
    private ListNode<T> next;
    
    public ListNode(final T data, final ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
