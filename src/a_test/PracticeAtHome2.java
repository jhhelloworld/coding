package a_test;


/**
 * jh
 * 2019年09月14日  12：42
 *
 * 矩阵递增数列
 */
public class PracticeAtHome2 {



    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length<3){
            return false;
        }
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i = 0;i<nums.length;i++){
            if(nums[i]>min2){
                return true;
            }
            //维护 min1 和min2
            //如果没有等于 [1,1,-2,6] 返回true
            if(nums[i] <= min1){
                min1 = nums[i];
            }else if(nums[i]<min2){
                min2 = nums[i];
            }

        }
        return false;

    }
}
