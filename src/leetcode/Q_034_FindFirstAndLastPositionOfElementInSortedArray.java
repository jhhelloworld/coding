package leetcode;

/**
 * jh
 * 2019年08月19日  13：00
 */
public class Q_034_FindFirstAndLastPositionOfElementInSortedArray {
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























