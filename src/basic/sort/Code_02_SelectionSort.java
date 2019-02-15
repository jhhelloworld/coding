package basic.sort;

/**
 * jh
 * 2019年02月13日  17：25
 */
public class Code_02_SelectionSort {

    public static void selectionSort(int[] arr) {
        if(arr == null || arr.length<2)
            return;
        for(int i = 0;i<arr.length-1;i++){
            int minIndex = i;
            for (int j = i+1;j<arr.length;j++){
                minIndex = arr[j]<arr[minIndex]?j:minIndex;
            }
            swap(arr,i,minIndex);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];


    }

}