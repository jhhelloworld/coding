package leetcode;

/**
 * jh
 * 2019年09月04日  23：23
 *
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设nums[-1] = nums[n] = -∞。
 *
 */
public class Q_162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int mid = 0;
        while(l<r){
            mid = l+(r-l)/2;
            if(nums[mid]>nums[mid+1]){
                r = mid;
            }else{
                l= mid+1;
            }
        }
        return r;
    }
}