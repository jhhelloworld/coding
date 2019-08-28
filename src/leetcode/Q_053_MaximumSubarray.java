package leetcode;

import javax.print.attribute.standard.NumberUp;

/**
 * jh
 * 2019年08月22日  13：27
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Q_053_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            if(sum<0){
                sum = 0;
            }
            sum += nums[i];
            result = Math.max(sum,result);
        }
        return result;

    }
}