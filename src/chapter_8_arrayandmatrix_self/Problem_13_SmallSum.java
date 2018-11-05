package chapter_8_arrayandmatrix_self;

/**
 * @author Jianghua
 * 2018年11月05日  19：43
 */
public class Problem_13_SmallSum {
    public static int getSmallSum(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        return func(arr,0,arr.length-1);

    }
    public static int func(int[] arr,int l,int r){
        if(l==r){
            return 0;
        }
        int mid = (l+r)/2;
        return func(arr,l,mid)+func(arr,mid,r)+merge(arr,l,mid,r);

    }
    public static int merge(int[] arr,int left,int mid ,int right){
        int[] help = new int[right-left+1];
        int hi = 0;
        int sum = 0;
        int i = left;
        int j = mid+1;
        while (i<=mid && j<=right){
            if(arr[i]<arr[j]){
                sum += arr[j]*(right-j+1);
                help[hi++]=arr[i++];
            }else {
                help[hi++] = arr[j++];
            }
        }
        return sum;

    }
}















