package DS.hashTable;

import java.util.TreeMap;

public class HashTable<K, V> {
    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(97);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> treeMap = hashTable[hash(key)];
        if (treeMap.containsKey(key)) {
            treeMap.put(key, value);//更新
        } else {
            treeMap.put(key, value);
            size += 1;
        }
    }

    public V remove(K key) {
        TreeMap<K, V> treeMap = hashTable[hash(key)];
        if (treeMap.containsKey(key)) {
            V deleteValue = treeMap.get(key);
            treeMap.remove(key);
            size -= 1;
            return deleteValue;
        } else {
            return null;
        }
    }

    public void set(K key, V value) {
        TreeMap<K, V> treeMap = hashTable[hash(key)];
        if (treeMap.containsKey(key)) {
            treeMap.put(key, value);
        } else {
            throw new IllegalArgumentException("key not exist");
        }
    }

    public boolean contains(K key) {
        TreeMap<K, V> treeMap = hashTable[hash(key)];
        return treeMap.containsKey(key);
    }

    public V get(K key) {
        return hashTable[hash(key)].getOrDefault(key, null);
    }
}
