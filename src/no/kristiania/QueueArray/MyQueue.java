package no.kristiania.QueueArray;

public interface MyQueue<T> {
    void enqueue(T value);
    T dequeue();
    T peek();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

}