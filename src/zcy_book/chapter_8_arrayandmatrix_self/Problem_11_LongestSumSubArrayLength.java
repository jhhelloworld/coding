package zcy_book.chapter_8_arrayandmatrix_self;

import java.util.HashMap;

/**
 * @author Jianghua
 * 2018年11月05日  14：02
 */
public class Problem_11_LongestSumSubArrayLength {
    public static int maxLength(int[] arr, int k) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int sum = 0;
        int len = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(map.containsKey(sum-k)){
                len = Math.max(len,i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return len;

    }

}