package leetcode;

/**
 * jh
 * 2019年08月17日  17：32
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Q_026_RemoveDuplicatesFromSortedArray {
    //思路：维持快慢指针，慢指针表示第一次出现的某个值，快指针遍历整个数组，最终返回满指针坐标+1
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast != nums.length) {
            while (fast != nums.length && nums[fast] == nums[slow]) {
                fast++;
            }
            if (fast != nums.length) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }


    //简化代码

    public int removeDuplicates2(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[j]) {
                A[++j] = A[i];
            }
        }
        return ++j;
    }
}