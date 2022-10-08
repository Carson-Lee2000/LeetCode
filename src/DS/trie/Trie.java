package DS.trie;

import java.util.TreeMap;

public class Trie {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    // 添加单词
    public void add(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);
        }

        if (!current.isWord) {
            current.isWord = true;
            size += 1;
        }
    }

    // 查询单词
    public boolean contains(String word) {
         Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(i) == null) {
                return false;
            }
            current = current.next.get(c);
        }
        return current.isWord;
    }
}
