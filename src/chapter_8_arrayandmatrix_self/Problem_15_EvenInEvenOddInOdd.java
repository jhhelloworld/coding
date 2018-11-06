package chapter_8_arrayandmatrix_self;

/**
 * @author Jianghua
 * 2018年11月05日  23：13
 */
public class Problem_15_EvenInEvenOddInOdd {
    public static void modify(int[] arr) {
        if(arr == null || arr.length<2){
            return;
        }
        int even = 0;
        int odd = 1;
        int end= arr.length - 1;
        while (even <arr.length && odd <arr.length){
            if((arr[end] & 1) == 0){
                swap(arr,even,end);
                even = even+2;
            }else {
                swap(arr,odd,end);
                odd = odd+2;
            }
        }
    }


    public static void  swap(int[] arr,int i,int j){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}