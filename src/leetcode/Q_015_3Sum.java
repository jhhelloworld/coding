package leetcode;

import java.util.*;

/**
 * jh
 * TODO 542. 01 Matrix
 * TODO 全排列
 * 2019年01月24日  20：35
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *[-1, 0, 1, 2, -1, -4]
 * -4,-1,-1, 0,  1,  2
 * [-2,0,1,1,2]
 */
public class Q_015_3Sum {


    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> result =  threeSum(nums);
        System.out.println("");

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length<3)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int target = -nums[i];
            Set<Integer> set = new HashSet<>();
            for(int j = i+1;j<nums.length;j++){
                List<Integer> resultItem = new ArrayList<>();

                if(j!=i+1 && nums[j]==nums[j-1] && j!=nums.length-1){
                    continue;
                }
                if(set.contains(target-nums[j])){
                    resultItem.add(nums[i]);
                    resultItem.add(target-nums[j]);
                    resultItem.add(nums[j]);
                    result.add(resultItem);
                    set.add(nums[j]);
                    continue;
                }else {
                    set.add(nums[j]);
                }


            }
        }
        return result;

    }

}