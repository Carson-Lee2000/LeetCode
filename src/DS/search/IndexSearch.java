package DS.search;

import org.junit.Test;

import java.util.Arrays;

public class IndexSearch {
    public int indexSearch(int[] nums, int key) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        int mid = low + ((key - nums[low]) / (nums[high] - nums[low])) * (high - low);
        while (low < high) {
            if (nums[mid] < key) {
                low = mid;
                mid = low + ((key - nums[low]) / (nums[high] - nums[low])) * (high - low);
            } else if (nums[mid] > key) {
                high = mid;
                mid = low + ((key - nums[low]) / (nums[high] - nums[low])) * (high - low);
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] ints = new int[]{65, 87, 4, 6, 2, 10, 66, 33, 77, 44};
        System.out.println(indexSearch(ints, 33 ));
    }
}
