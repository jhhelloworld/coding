package util;

import java.util.Arrays;

public class ArrayTestUtil {

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     *
     * @param maxSize 最大长度
     * @param maxValue 最大值
     * @return 生成随机长度数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     *
     * @param arr 原始数组
     * @return 复制数组
     */
    public static int[] copyArray(int[] arr) {
        if(arr == null){
            return null;
        }
        return Arrays.copyOf(arr,arr.length);
    }


    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        //arr1 == null && arr2 == null  可以简化
        if (arr1 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
