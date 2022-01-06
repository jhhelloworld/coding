package basic.sort;

/**
 * jh
 * 2019年02月13日  15：03
 */
public class Code_01_InsertionSort {
    public static void insertionSort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            for(int j = i-1;j>=0 && arr[j]>arr[j+1];j--){
                swap(arr,  j,  j+1);

            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }

}