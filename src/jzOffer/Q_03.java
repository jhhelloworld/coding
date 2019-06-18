package jzOffer;

/**
 * jh
 * 2019年06月17日  12：20
 * 数组中是否有重复的数字   长度为N 的数组 都在 0-n-1范围内
 *
 * 找出数组中所有重复的数字
 *
 * 不改变数组，找出重复数字
 *
 */
public class Q_03 {
public boolean containsDuplicate(int[] nums) {
    if(nums == null || nums.length ==0){
        return false;
    }
    for(int i = 0;i<nums.length;i++){
        while (nums[i]!=i){
            if(nums[i] == nums[nums[i]]){
                return true;
            }else {
                swap(nums,i,nums[i]);
            }
        }
    }
    return false;
}

public void swap(int[] nums,int i,int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}




}