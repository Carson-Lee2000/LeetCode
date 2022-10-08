package DS.search;

import org.junit.Test;

public class ShunXU {
    public int searchSequ(int[] nums, int key) {
        //0号元素做哨兵，存放key，从nums[nusm.length]开始查找，数组长度实际为length+1
        if (nums[0] == key)
            return 0;
        else {
            nums[0] = key;
            for (int i = nums.length - 1; i > 0; --i) {
                if (nums[i] == key) {
                    return i;
                }
            }

        }
        return -1;
    }


    @Test
    public void test() {
        int[] ints = new int[]{65, 87, 4, 6, 2, 10, 66, 33, 77, 44};

        System.err.println(searchSequ(ints, 10));
    }
}
