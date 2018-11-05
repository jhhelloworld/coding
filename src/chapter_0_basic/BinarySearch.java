package chapter_0_basic;

/**
 * @author Jianghua
 * 2018年11月05日  14：41
 * 二分查找，以单调不减序列为例
 */
public class BinarySearch {
    /**
     * 找第一次出现的位置
     */
    public static int binarySearchFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        int mid;
        while (left < right){
            mid = (left+right)/2;
            if(arr[mid]<target){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        if(arr[left] == target){
            return left;
        }else {
            return -1;
        }
    }

    /**
     * 找最后一次出现的位置
     */
    public static int binarySearchLast(int[] arr, int target) {
       int left = 0;
       int right = arr.length;
       int mid;
       while (left<right){
           mid = (left+right)/2;
           if(arr[mid]>target){
               right = mid - 1 ;
           }else {
               left = mid;
           }
       }
        if(arr[left] == target){
            return left;
        }else {
            return -1;
        }

    }






    //todo 递归
}