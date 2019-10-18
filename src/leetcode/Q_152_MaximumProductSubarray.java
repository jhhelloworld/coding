package leetcode;

/**
 * jh
 * 2019年09月04日  22：42
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 */
public class Q_152_MaximumProductSubarray {


    /**
     * 思路
     * 所有的子数组都会以某一个位置结束
     * 遍历到位置i时，找到以 i-1结尾的子数组的最大值和最小值
     * 最大值可能是
     * 遍历到i-1时，包含i-1的 乘积的最大值*nums[i]
     * 遍历到i-1时，包含i-1的 乘积的最小值*nums[i]
     * nums[i]
     */
    public int maxProduct(int[] nums) {
        int min = nums[0],max = nums[0],curMin = nums[0],curMax = nums[0],result = nums[0];
        //注意从1 开始
        for(int i =1;i<nums.length;i++){
            curMin = min*nums[i];
            curMax = max*nums[i];
            min = Math.min(Math.min(curMax,curMin),nums[i]);
            max = Math.max(Math.max(curMax,curMin),nums[i]);
            result = Math.max(max,result);
        }
        return result;

    }
}