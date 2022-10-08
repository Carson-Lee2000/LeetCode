package DS.stack;

import DS.array.Array;

// array stack
public class MainStack<E> implements Stack<E> {

    private Array<E> array;

    public MainStack(int capacity) {
        array = new Array<>(capacity);
    }

    public MainStack() {
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
    public void push(E e) {
        array.addLast(e);
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public E pop() {
        return array.deleteLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        return "MainStack{" +
                "array=" + array +
                '}';
    }
}
