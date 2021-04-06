/**
 * Created by Eiman on 3/25/2021.
 */
public class ArrayQueue<E> implements Queue <E> {
    E data[];
    static int capacity=100;
    int f=0;
    int sz=0;

    public ArrayQueue(int c) {
        data= (E[]) new Object[c];
    }

    public ArrayQueue() {
        this(capacity);
    }

    @Override
    public boolean isEmpty() {
        return sz==0;
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public E first() {
        if (isEmpty())return null;
        return data[f];
    }

    @Override
    public void enqueue(E element) throws IllegalStateException {
        if (size()==data.length)throw new IllegalStateException("Queue is full");
        int x=(f+sz)%data.length;
        data[x]=element;
        sz++;

    }

    @Override
    public E dequeue() {
        if (isEmpty())return null;
        E deleted=data[f];
        data[f]=null;
        f=(f+1)%data.length;
        sz--;
        return deleted;
    }
}
