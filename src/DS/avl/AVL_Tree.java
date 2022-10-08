package DS.avl;

import java.util.ArrayList;

public class AVL_Tree<K extends Comparable<K>, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        // 记录节点高度，值为 1代表叶子节点
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AVL_Tree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 判断当前树是否是二分搜索树，根据中序遍历结果有序
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null)
            return;
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    // 判断当前树是否是平衡二叉树
    public boolean isAVL() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        if (Math.abs(getBalanceFactor(node)) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // 获取每个节点的平衡因子
    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return (getHeight(node.left) - getHeight(node.right));
    }

    // 添加元素
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;//更新
        }

        // 节点添加之后更新 node的height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("AVL is unbalanced");
        }

        // 维护AVL平衡
        // 右旋转
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        // 左旋转
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.left) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    // 右旋转
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(y.height, getHeight(x.left)) + 1;

        return x;
    }

    // 左旋转
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        x.left = y;
        y.right = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(y.height, getHeight(x.right)) + 1;
        return x;
    }

    // 从AVL树中删除元素
    // public V remove(K key) {
    //
    // }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;

        Node retNode;
        if (key.compareTo(node.key) < 0) {
            remove(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            remove(node.right, key);
        } else {

        }
        return node;
    }
}
