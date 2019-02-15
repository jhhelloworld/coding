package zcy_book.chapter_8_arrayandmatrix_self;

/**
 * @author Jianghua
 * 2018年11月06日  10：11
 */
public class Problem_16_SubArrayMaxSum {
    public static int maxSum(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for(int i = 0; i<arr.length;i++){
            cur = cur+arr[i];
            max = Math.max(max,cur);
            cur = cur>0?cur:0;
        }
        return max;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = { -2, -3, -5, 40, -10, -10, 100, 1 };
        System.out.println(maxSum(arr1));

        int[] arr2 = { -2, -3, -5, 0, 1, 2, -1 };
        System.out.println(maxSum(arr2));

        int[] arr3 = { -2, -3, -5, -1 };
        System.out.println(maxSum(arr3));

    }
}