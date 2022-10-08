package DS.queue;

public class LinkedListQueue<E> implements Queue<E>{

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            if (e == null) {
                return "null";
            }
            return e.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (this.tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size += 1;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty, dequeue failed");
        }
        Node deleteNode = head;
        head = head.next;
        deleteNode.next = null;
        if (head == null) {
            tail = null;
        }
        size -= 1;
        return deleteNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: top ");

        Node current = head;
        while (current != null) {
            stringBuilder.append(current + "->");
            current = current.next;
        }
        stringBuilder.append("null tail");
        return stringBuilder.toString();
    }
}
