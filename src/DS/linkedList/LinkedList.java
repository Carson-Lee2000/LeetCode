package DS.linkedList;

public class LinkedList<E> {

    private class Node {
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
            if (e != null)
                return e.toString();
            return "null";
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 链表头添加元素
    public void addFirst(E e) {

        // head = new Node(e, head);

        // Node node = new Node(e);
        // node.next =dummyHead.next;
        // dummyHead.next = node;
        //
        // size += 1;
        add(0, e);
    }

    // 在链表中间添插入元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index exception");
        }
        // if (index == 0) {
        //     addFirst(e);
        // } else
        Node previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }
        Node node = new Node(e);
        node.next = previous.next;
        previous.next = node;

        size += 1;
    }

    // 在链表末尾插入元素
    public void addLast(E e) {
        add(size, e);
    }

    // 获得index位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    // 获得链表第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取链表最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改元素的值
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    // 查找
    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    // 删除index位置的元素
    public E delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("delete failed");
        }

        Node previous = dummyHead;
        Node current = dummyHead.next;

        for (int i = 0; i < index; i++) {
            previous = previous.next;
            current = current.next;
        }

        size -= 1;
        E e = current.e;
        previous.next = current.next;
        current.next = null;
        return e;
    }

    // 删除首部元素
    public E deleteFirst() {
        return delete(0);
    }

    // 删除末尾元素
    public E deleteLast() {
        return delete(size - 1);
    }

    // 删除元素e
    public void deleteElement(E e) {
        Node previous = dummyHead;
        while (previous.next != null) {
            if (previous.next.e.equals(e)) {
                break;
            }
            previous = previous.next;
        }

        if (previous.next != null) {
            Node deleteNode = previous.next;
            previous.next = deleteNode.next;
            deleteNode.next = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = dummyHead.next;
        while (current != null) {
            stringBuilder.append(current + "->");
            current = current.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}
