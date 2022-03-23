package leetcode;

import java.lang.management.BufferPoolMXBean;

/**
 * jh
 * 2019年08月25日  18：59
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class Q_075_SortColors {
    //思路：快排思想
    public void sortColors(int[] nums) {
        if(nums == null|| nums.length<2){
            return;
        }
        int less = -1,more = nums.length-1,index = 0;

        //注意，一定是index<=more 因为如果 [2,0,1] 最后变为[1,0,2],index=1,more=1,循环终止了
        while (index<=more){
            if(nums[index]==0){
                swap(nums,++less,index++);
            }else if(nums[index] == 1){
                index++;
            }else {
                swap(nums,index,more--);
            }
        }


    }


    public void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

















