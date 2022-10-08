package DS.linkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);
        linkedList.add(2, 5);
        System.out.println(linkedList);

        System.out.println(linkedList.contains(2));
        linkedList.set(2, 100);
        System.out.println(linkedList);
        System.out.println(linkedList.delete(0));
        System.out.println(linkedList);
        System.out.println(linkedList.deleteLast());
        System.out.println(linkedList);
    }
}
