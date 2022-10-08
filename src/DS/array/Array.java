package DS.array;

import java.util.Arrays;

public class Array<E> {

    private E[] data;
    // 已经存储的数据数量
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E[] array) {
        data = (E[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        size = array.length;
    }
    // 获取数组元素数量
    public int getSize() {
        return this.size;
    }

    // 获取数组存储能力
    public int getCapacity() {
        return this.data.length;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向数组末尾添加元素
    public void addLast(E element) {
        // if (size == data.length) {
        //     throw new IllegalArgumentException("数组已满");
        // }
        // data[size] = element;
        // size += 1;
        add(size, element);
    }

    // 向数组头部插入元素
    public void addFirst(E element) {
        add(0, element);
    }

    // 向数组指定位置添加元素
    public void add(int index, E element) {
        if (size == data.length) {
            resize(2 * data.length);
        } else if (index < 0 || index > size) {
            throw new IllegalArgumentException("index越界");
        }
        for (int i = size - 1; i >= index ; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size += 1;
    }

    // 按照索引取出元素
    public E getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("越界");
        }
        return data[index];
    }

    //
    public E getFirst() {
        return getElement(0);
    }

    public E getLast() {
        return getElement(size - 1);
    }

    // 数组元素更新
    public void setElement(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("越界");
        }
        data[index] = element;
    }

    // 判断是否包含
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    // 查找索引
    public int findFirstIndex(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    // 删除指定位置元素
    public E delete(int index) {
        if (index  < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }

        E deleteNum = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size -= 1;
        data[size] = null;

        if (size == data.length / 2) {
            resize(data.length / 2);
        }
        return deleteNum;
    }

    // 删除头部元素
    public E deleteFirst() {
        return delete(0);
    }

    // 删除尾部元素
    public E deleteLast() {
        return delete(size - 1);
    }

    // 删除第一个值为element的元素
    public void remove(E element) {
        int firstIndex = findFirstIndex(element);
        if (firstIndex != -1) {
            delete(firstIndex);
        }
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 交换位置
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("index is illegal");
        }

        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
