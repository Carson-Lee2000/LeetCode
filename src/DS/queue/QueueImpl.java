package DS.queue;

import DS.array.Array;

public class QueueImpl<E> implements Queue<E>{

    private Array<E> array;

    public QueueImpl(int capacity) {
        array = new Array<>(capacity);
    }

    public QueueImpl() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.deleteFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        return "QueueImpl{" +
                "array=" + array +
                '}';
    }
}
