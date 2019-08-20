package leetcode;

/**
 * jh
 * 2019年08月20日  16：49
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class Q_088_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        int i = m-1;
        int j = n-1;
        while (i>=0 && j>=0){
            nums1[index--] = nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
        }
        //第一次提交忽略了下面步骤，这样是不对的，前面几个字符最终会剩下nums1的字符
        while (j>=0){
            nums1[index--] = nums2[j--];
        }
    }
}