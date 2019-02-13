package chapter_0_basic.search;

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

        //为什么 while 里的条件是 <，而不是 <=。
        // 一方面是我们想在循环外部判断最终的 left 位置是否是目标值，
        // 另一方面是如果循环条件允许 left = right，那么最后 mid = left = right，如果该处正好是目标值，那么 right 将始终等于 mid，不会再左移，就会陷入死循环。
        while (left < right){
            mid = (left+right)/2;
            //当中间值小于目标元素的时候，目标元素在序列的右边：left = temp + 1；
            /**
             * 其余的情况目标值在序列的左边：right = temp；
             * 我们要查找的第一个目标元素的位置，一般的情况就是目标元素存在多个情况，由上述的两个判断条件，我们可以知道，如果查找到了目标元素，并且该目标元素不是第一个的时候，
             * 此时left<right，判断继续进行。我们这里设置的判断条件保证了，当中间值小于目标元素的时候，left一定会向右移动，
             * 同时如果中间值恰好等于目标元素的时候，right能够不动，最终序列结束的时候，left=right=目标元素的第一次出现的位置！
             */
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

    /**
     * 寻找第一个大于目标值的数字,如果没有返回第一个
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int sp = 0, ep = letters.length - 1;
        while(sp <= ep) {
            int mid = (sp + ep) / 2;
            if(sp == ep) {
                return letters[sp] > target ? letters[sp] : letters[0];
            }
            if(letters[mid] <= target) {
                sp = mid + 1;
            }
            else {
                ep = mid;
            }
        }
        return letters[0];
    }






    //todo 递归
}