package no.kristiania.MyLinkedList;

public interface MyList<T> {

    void delete(int index);

    default boolean isEmpty() {
        return size() == 0;
    }

    T get(int index);

    default void add(T value) {
        add(size(), value);
    }

    void add(int index, T value);

    int size();

}
