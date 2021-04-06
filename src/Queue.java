/**
 * Created by Eiman on 3/25/2021.
 */
public interface Queue <E> {
    boolean isEmpty();
    int size();
    E first();
    void enqueue(E element);
    E dequeue();



}
