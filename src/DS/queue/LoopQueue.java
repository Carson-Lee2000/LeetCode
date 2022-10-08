package DS.queue;

import java.util.Arrays;

public class LoopQueue<E> implements Queue<E>{

    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        // 循环队列判空 front == tail，判满 (tail + 1) % capacity == 1，会浪费一个存储空间
        this.data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        // 判满
        if ((tail + 1) % data.length == 1) {
            this.resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size += 1;
    }

    @Override
    public E dequeue() {
        // 判空
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        E returnElement = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size -= 1;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return returnElement;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }

        return data[front];
    }


    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        return "LoopQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
