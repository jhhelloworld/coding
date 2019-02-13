package leetcode;

/**
 * jh
 * 2019年01月16日  21：26
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * [0,1,0,3,12]  -> [1,3,12,0,0]
 */
public class Q_283_MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0){
            return;
        }
        int len = nums.length;
        int left = 0;
        for(int i = 0;i<len;i++){
            if(nums[i]!=0){
                nums[left++]=nums[i];
            }else {
                continue;
            }
        }
        for(int i = left;i<len;i++){
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println();
    }
}