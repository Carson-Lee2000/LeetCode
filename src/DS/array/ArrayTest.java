package DS.array;

public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < array.getCapacity() - 1; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        // array.add(array.getSize() - 1, 100);
        // System.out.println(array);
        // array.delete(3);
        // System.out.println(array);
        // array.add(2, 100);
        // // array.add(2, 1000);
        // System.out.println(array);
        // array.addLast( 101);
        // System.out.println(array);
        array.delete(0);
        array.delete(0);
        array.delete(0);
        array.delete(0);
        System.out.println(array);
    }
}
