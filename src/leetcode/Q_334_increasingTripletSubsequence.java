package leetcode;

/**
 * jh
 * 2019年12月03日  14：30
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * 数学表达式如下:
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 */
public class Q_334_increasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > min2) {
                return true;
            }
            //维护 min1 和min2
            if (num <= min1) {
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }
        }
        return false;
    }
}