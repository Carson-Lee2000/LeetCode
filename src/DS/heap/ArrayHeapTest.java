package DS.heap;

import java.util.Random;

public class ArrayHeapTest {
    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (array[i - 1] < array[i]) {
                throw new IllegalArgumentException("error");
            }
        }

        System.out.println("success");
    }
}
