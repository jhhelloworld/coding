package leetcode;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 进阶：
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 */
public class Q_034_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length==0){
            return new int[]{-1,-1};
        }

        //获取第一次出现的下标
        int firstIndex = getFirstIndex(nums,target);
        int lastIndex= 0;
        if(firstIndex == -1){
            lastIndex = -1;
        }else {
            lastIndex = getLastIndex(nums,target);
        }
        result[0] = firstIndex;
        result[1] = lastIndex;
        return result;
    }


    private int getFirstIndex(int[] nums,int target){
        int left = 0,right = nums.length-1,mid = 0;
        while (left+1<right){
            mid = left+(right-left)/2;
            if(nums[mid] >= target){
                right = mid;
            }else {
                left = mid +1;
            }
        }
        if(nums[left] == target){
            return left;
        }else if(nums[right] == target){
            return right;
        }else {
            return -1;
        }
    }


    private int getLastIndex(int[] nums,int target){
        int left = 0,right = nums.length-1,mid = 0;
        while (left+1<right){
            mid = left+(right-left)/2;
            if(nums[mid] <= target){
                left = mid;
            }else {
                right = mid -1;
            }
        }
        if(nums[right] == target){
            return right;
        }else if(nums[left] == target){
            return left;
        }else {
            return -1;
        }
    }



}























