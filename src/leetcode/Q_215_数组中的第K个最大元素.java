package leetcode;

import jdk.nashorn.internal.objects.NativeNumber;

/**
 * jh
 * 2019年09月07日  13：47
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Q_215_数组中的第K个最大元素 {

    /**
     * 思路：快排思想
     * 1.找到最右边的元素为 rule，比rule小的放右边，rule大的放左边
     * 2.判断rule是否是第k大的元素，如果是，则直接返回，否，则可以计算出rule是第i大
     * 3.如果i>k,在右半部分找第k大
     * 4.如果i<k,在左半部分找第k大
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }


    public int quickSelect(int[] nums, int l, int r, int k) {
        if (l < r) {
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


    //注意这里要把较大的放到左边，较小的放到右边
    private int[] partition(int[] nums, int l, int r) {
        int more = l - 1, less = r;
        while (l < less) {
            if (nums[l] < nums[r]) {
                swap(nums, l, --less);
            } else if (nums[l] > nums[r]) {
                swap(nums, l++, ++more);
            } else {
                l++;
            }
        }
        swap(nums, l, r);
        return new int[]{more + 1, l};
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //时间最优解
    public int findKthLargest2(int[] nums, int k) {
        return quickSelect2(nums, 0, nums.length - 1, k);
    }

    private int quickSelect2(int[] nums, int left, int right, int k) {//大到小
        int mid = left + (right - left) / 2;
        int pivot = nums[mid];
        int i = left;
        int j = right;
        while (i <= j) {
            while (pivot < nums[i]) {
                i++;
            }
            while (pivot > nums[j]) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }



        //left  j  pivot i  right
        if (j - left + 1 >= k) {
            return quickSelect2(nums, left, j, k);
        }

        if (i - left + 1 <= k) {
            return quickSelect2(nums, i, right, k - (i - left));
        }
        //为什么+1
        return nums[j + 1];
    }

}




















