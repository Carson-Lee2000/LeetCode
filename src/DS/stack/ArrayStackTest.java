package DS.stack;

public class ArrayStackTest {
    public static void main(String[] args) {
        MainStack<Integer> stack = new MainStack<>();
        for (int i = 0; i < stack.getCapacity(); i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.push(100);
        System.out.println(stack);
        stack.push(99);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
