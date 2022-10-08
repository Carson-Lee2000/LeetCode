package DS.stack;

public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(100);
        stack.push(200);
        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
