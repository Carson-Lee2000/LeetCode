package DS.map;

public class BST_Map<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST_Map() {
        this.root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    // 向以node为根的BST中插入节点
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size += 1;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }

        return null;
    }

    // 删除以node为根的BST中key对应的节点，返回删除相应节点后二叉树的根节点
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            // 待删除节点的左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size -= 1;
                return rightNode;
            }

            // 待删除节点的右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size -= 1;
                return leftNode;
            }

            // 待删除节点的左右子树均不空，用待删除节点右子树的最小节点（或左子树的最大节点）替换待删除节点
            Node successor = minmun(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    // 获取最小节点
    private Node minmun(Node node) {
        if( node.left == null )
            return node;

        return minmun(node.left);
    }

    // 获取删除最小元素后的根节点
    private Node removeMin(Node node) {
        // Node deleteNode = minmun(node);
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size -= 1;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);

        if (node != null) {
            node.value = newValue;
        } else {
            throw new IllegalArgumentException(key + " doesn't exist");
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    // 返回以node为根的BST中key对应的节点
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }
}
