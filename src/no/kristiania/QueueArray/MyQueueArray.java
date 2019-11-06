package no.kristiania.QueueArray;

public class MyQueueArray<T> implements MyQueue<T>{

    protected Object[] data;

    private int head = -1;
    private int tail = -1;

    public MyQueueArray() {
        this(10);
    }

    public MyQueueArray(int capacity) {
        data = new Object[capacity];
    }

    @Override
    public void enqueue(T value) {

        if(isEmpty()) {
            head = 0;
            tail = 0;
        } else if(tail < data.length - 1) {
            //There is space
            tail++;
        } else {
            //we run out of space, where "tail"
            if(size() < data.length / 5) {
                //"5" is random arbitrary number

                int size = size();
                for (int i = 0; i < size; i++) {
                    data[i] = data[i + head];
                }
                head = 0;
                tail = size;
            } else {
                Object[] tmp = new Object[data.length * 2];

                int size = size();
                for (int i = 0; i < size; i++) {
                    tmp[i] = data[i + head];
                }
                head = 0;
                tail = size;
                data = tmp;
            }
        }
        data[tail] = value;
    }

    @Override
    public T dequeue() {
        if(isEmpty()) {
            throw new RuntimeException();
        }
        T value = (T) data[head];

        if(size() == 1) {
            //now it will be empty
            head = -1;
            tail = -1;
        } else {
            head++;
        }
        return value;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            throw new RuntimeException();
        }
        return (T) data[head];
    }

    @Override
    public int size() {
        if(head < 0) {
            return 0;
        }
        return (tail - head) + 1;
    }

}
