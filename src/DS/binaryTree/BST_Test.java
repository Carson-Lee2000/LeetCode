package DS.binaryTree;

public class BST_Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 2, 4, 8};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println("--");
        bst.preOrderNR();
        System.out.println("--");
        // bst.levelOrder();
        // bst.postOrder();
        bst.removeNode(3);
        bst.levelOrder();
        // System.out.println("--");
        // System.out.println(bst);
    }
}
