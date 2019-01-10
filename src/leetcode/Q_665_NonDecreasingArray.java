package leetcode;

/**
 * jh
 * 2019年01月07日  17：11
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 *
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * 3423 false   421
 */
public class Q_665_NonDecreasingArray {
    public static void main(String[] args) {
        int[] nums = {4,2,1};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int num = 0;

        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
               if(num==1)
                   return false;
               else{
                   if(i-1>=0 && nums[i+1]<nums[i-1]){
                       nums[i+1]=nums[i];
                   }
               }
                i++;
            }

        }
        return true;



    }
}