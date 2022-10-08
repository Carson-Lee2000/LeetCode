package DS.queue;

public class ArrayQueueTest {
    public static void main(String[] args) {
        // QueueImpl<Integer> queue = new QueueImpl<>();
        // for (int i = 0; i < 5; i++) {
        //     queue.enqueue(i);
        // }
        // System.out.println(queue);
        // queue.dequeue();
        // System.out.println(queue);
        LoopQueue<Integer> loopQueue = new LoopQueue<>(11);
        loopQueue.enqueue(100);
        loopQueue.enqueue(102);
        loopQueue.enqueue(105);
        loopQueue.enqueue(109);
        System.out.println(loopQueue);
        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue);
        loopQueue.enqueue(111);
        System.out.println(loopQueue);
        System.out.println(loopQueue.getFront());
    }
}
