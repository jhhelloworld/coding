package leetcode;

import java.util.Arrays;

/**
 * jh
 * 2019年09月11日  17：39
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * <p>
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 */
public class Q_324_WiggleSort2 {
    public void wiggleSort(int[] nums) {
        //找到中位数
        int len = nums.length;
        //注意中位数是第几大  len/2 也可以
        int midIndex = (len + 1) / 2;
        int midNum = quickSelect(nums, 0, len - 1, midIndex);
        /**
         * i: 从1开始，存放大于中位数的值,向右递增 表示下一个需要填充的坐标
         * j: 从最右一个偶数下标开始，存放小于中位数的值，向左递减
         * 等于中位数的值会分散到数组两边，不必考虑这些值
         */
        int i = 1, j = len % 2 == 0 ? len - 2 : len - 1, p = 0;
        while (p < len) {
            // 遍历当前位置大于中位数 并且（p>i 表示当前坐标 没有被处理，p%2==0 表示虽然在i前面，但是p位置应是较小的数，也是没有处理）
            //重新理解：P表示当前遍历位置，i表示待插入大于中位数的下一个位置
            //如果p>i 无条件swap
            //如果p<=i,如果p%2==1，肯定被处理过了，小于i的奇数都是已处理过的
            if (nums[p] > midNum && (p > i || p % 2 == 0)) {
                swap(nums, p, i);
                //p ++;
                i += 2;
            } else if (nums[p] < midNum && (p < j || p % 2 == 1)) {
                //p++;
                swap(nums, p, j);
                j -= 2;
            } else {
                //什么时候进入这一步。
                //left或right=inex
                // 当num[p]等于midNum的时候直接跳过，等到未来和大于或小于的值互换，这样等于的值会放到数组两边
                p++;
            }
        }
    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private int quickSelect(int[] nums, int l, int r, int k) {
        if (l < r) {
            //主语：加上这一行后运行效率显著提升
            swap(nums, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(nums, l, r);
            if (p[0] <= k - 1 && k - 1 <= p[1]) {
                return nums[p[0]];
            } else if (p[0] > k - 1) {
                return quickSelect(nums, l, p[0] - 1, k);
            } else {
                return quickSelect(nums, p[1] + 1, r, k);
            }
        }
        return nums[l];
    }


    private int[] partition(int[] nums, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (nums[l] < nums[r]) {
                swap(nums, --more, l);
            } else if (nums[l] == nums[r]) {
                l++;
            } else {
                swap(nums, l++, ++less);
            }
        }
        swap(nums, more, r);
        return new int[]{less + 1, more};

    }




}