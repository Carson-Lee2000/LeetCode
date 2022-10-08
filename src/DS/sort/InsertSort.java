package DS.sort;

import org.junit.Test;

public class InsertSort {
    public int[] insertSort(int[] nums) {
        int temp = 0;
        int i = 0, j = 0;
        for (i = 1; i < nums.length; i++) {
            temp = nums[i];
            for (j = i - 1; j >= 0 ; j--) {
                if (temp < nums[j]) {
                    nums[j + 1] = nums[j];
                } else
                    break;
            }
            nums[j + 1] = temp;
        }
        return nums;
    }

    //有问题
    @Deprecated
    public int[] binarySort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //第i个元素之前的元素已经有序，可以将第i个元素按照折半查找的方式找到插入位置
            int j = 0;
            int temp = nums[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;

                if (nums[i] < nums[mid])
                    high = mid - 1;
                else if (nums[i] > nums[mid])
                    low = mid + 1;

                for (j = i; j > low; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[low] = temp;
            }
        }
        return nums;
    }

    public int[] shellSort(int[] nums) {
        for (int h = nums.length / 2; h > 0; h /= 2) {
            int temp = 0;
            int i = 0, j = 0;
            for (i = h; i < nums.length; i++) {
                temp = nums[i];
                for (j = i - h; j >= 0 ; j -= h) {
                    if (temp < nums[j]) {
                        nums[j + h] = nums[j];
                    } else
                        break;
                }
                nums[j + h] = temp;
            }
        }
        return nums;
    }

    public int[] bubbleSort(int[] nums) {
        int  temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    public void quickSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int key = nums[begin];
            int i = begin;
            int j = end;
            int temp = 0;

            while (i < j) {
                while (i < j && nums[j] > key) {
                    j --;
                }

                //找到右侧第一个小于key的值
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }

                while (i < j && nums[i] < key) {
                    i ++;
                }

                //
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = key;
            quickSort(nums, begin, i - 1);
            quickSort(nums, i + 1, end);
        }
    }

    public int[] simpleSelectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;//记录当前趟数最小元素的位置
            for (int j = i + 1; j < nums.length; j++)
                if (nums[j] < nums[min])
                    min = j;
            if (min != i) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }


    @Test
    public void testInsertSort() {
        int[] ints = simpleSelectSort(new int[]{2, 7, 6, 1, 5, 3, 9, 8});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
