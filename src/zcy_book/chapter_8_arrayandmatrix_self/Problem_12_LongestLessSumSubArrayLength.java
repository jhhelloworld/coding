package zcy_book.chapter_8_arrayandmatrix_self;

/**
 * @author Jianghua
 * 2018年11月05日  14：19
 */
public class Problem_12_LongestLessSumSubArrayLength {

    public static int maxLength(int[] arr, int k) {
        int[] help = new int[arr.length+1];
        int sum = 0;
        help[0] = sum;
        for(int i = 0 ;i<arr.length;i++){
            sum += arr[i];
            help[i+1] = Math.max(sum,help[i]);
        }
        sum = 0;
        int res = 0;
        int pre = 0;
        int len = 0;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            pre = getLessIndex(help,sum-k);
            len = pre==-1?0:i-pre+1;
            res = Math.max(len,res);

        }
        return res;
    }

    public static int getLessIndex(int[] arr, int num) {
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        int res = -1;
        while (left<= right){
            mid = (left+right)/2;
            if(arr[mid]>= num){
                res = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return res;

    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 3, -2, -4, 0, 6 };
        int k = -2;
        System.out.println(maxLength(arr, k));

    }


}