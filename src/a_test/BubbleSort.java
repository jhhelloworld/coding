package a_test;

/**
 * jh
 * 2019年04月12日  09：44
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length<=1){
            return;
        }
        for(int i = 0;i<arr.length;i++){
            for(int j = i;j<arr.length-1;j++){
                if(arr[j]> arr[j+1]){
                    swap(arr,i,j);
                }
            }
        }



    }


    public  static void swap(int[] arr,int i,int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
}