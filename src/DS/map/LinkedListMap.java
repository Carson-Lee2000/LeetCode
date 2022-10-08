package DS.map;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size += 1;
        } else {
            // 更新value
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node previous = dummyHead;
        while (previous.next != null) {
            if (previous.next.key.equals(key)) {
                break;
            }
            previous = previous.next;
        }

        if (previous.next != null) {
            Node deleteNode = previous.next;
            previous.next = deleteNode.next;
            deleteNode.next = null;
            size -= 1;
            return deleteNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node != null) {
            node.value = newValue;
        } else {
            throw new IllegalArgumentException(key + " doesn't exist");
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private Node getNode(K key) {

        Node current = dummyHead.next;
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
