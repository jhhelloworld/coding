package leetcode;

import java.util.Arrays;

/**
 * jh
 * 2019年08月15日  21：44
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class Q_016_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        //初始值一定要用数组中的数据的组合，否则 可能命中target而导致返回初始值
        int result = nums[0] + nums[1] + nums[nums.length - 1], sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }


            }
        }
        return result;


    }


    public int threeSumClosest2(int[] nums, int target) {
        ///Runtime: 9 ms, faster than 96.54%
        if (nums == null || nums.length < 3){
            return 0;
        }
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int n = nums.length;
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] + nums[n - 1] + nums[n - 2] < target) {
                //判断首尾，不进行不必要的操作
                sum = nums[i] + nums[n - 1] + nums[n - 2];
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] > target) {
                int temp = nums[i] + nums[i + 1] + nums[i + 2];
                return lessGap(sum, temp, target);
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp == target) {
                    return target;
                }
                if (temp < target) {
                    j++;
                    sum = lessGap(sum, temp, target);
                } else {
                    k--;
                    sum = lessGap(sum, temp, target);
                }
            }
        }
        return sum;
    }

    private int lessGap(int sum, int temp, int target) {
        return Math.abs(sum - target) < Math.abs(temp - target) ? sum : temp;
    }
}