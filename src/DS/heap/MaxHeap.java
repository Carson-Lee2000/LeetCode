package DS.heap;

import DS.array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] array) {
        data = new Array<>(array);
        for (int i = parent(array.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    // 返回堆中元素的个数
    public int size() {
        return data.getSize();
    }

    // 判断堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引表示的节点对应的父节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("this is root, has no parent");
        }

        return (index - 1) / 2;
    }

    // 返回index对应节点的左孩子节点的索引
    private int leftChild(int index) {
        return (2 * index + 1);
    }

    // 返回index对应节点的右孩子节点的索引
    private int rightChild(int index) {
        return (2 * index + 2);
    }

    // 向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.getElement(parent(k)).compareTo(data.getElement(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 从大顶堆中取出最大元素
    // 将最后一个元素移到堆顶，执行siftDown
    public E extractMax() {
        E max = findMax();
        data.swap(data.getSize() - 1, 0);
        data.deleteLast();

        siftDown(0);
        return max;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            // 记录左右孩子中值最大的节点
            int maxChildIndex = leftChild(k);
            // 判断右孩子是否存在，更新maxChildIndex
            if (maxChildIndex + 1 < data.getSize() && data.getElement(maxChildIndex + 1).compareTo(data.getElement(maxChildIndex)) > 0) {
                maxChildIndex = rightChild(k);
            }

            if (data.getElement(k).compareTo(data.getElement(maxChildIndex)) >= 0) {
                break;
            }

            data.swap(k, maxChildIndex);
            k = maxChildIndex;
        }
    }

    // 返回最大元素
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("heap is empty");
        }

        return data.getElement(0);
    }

    // 取出堆中的最大元素，并且替换成e
    public E replace(E e) {
        E result = findMax();
        data.setElement(0, e);
        siftDown(0);
        return result;
    }
}
