package DS;

import aa_code.E203;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("array can't be empty");
        }

        this.val = arr[0];
        ListNode current = this;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        ListNode current = this;
        while (current != null) {
            stringBuilder.append(current.val + "->");
            current = current.next;
        }

        stringBuilder.append("null");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);
        // aa_code.ListNode removeElements3 = new E203().removeElements3(listNode, 3);
    }
}
