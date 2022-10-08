package DS.queue;

public class LinkedListQueueTest {
    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 6; i++) {
            linkedListQueue.enqueue(i);
        }
        System.out.println(linkedListQueue);
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue);
        linkedListQueue.enqueue(10);
        System.out.println(linkedListQueue);
    }
}
