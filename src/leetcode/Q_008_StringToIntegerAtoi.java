package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * jh
 * 2019年02月27日  09：46
 */
public class Q_008_StringToIntegerAtoi {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean positive = true;
        List<Integer> list = new ArrayList<>();
        char[] arr = str.toCharArray();
        int begin = 0;
        //去空
        for (char c:arr){
            if(c == ' '){
                begin++;
                continue;
            }else {
                break;
            }
        }
        //符号
        if(begin<arr.length){
            if(arr[begin]=='-'){
                positive = false;
                begin++;
            }else if(arr[begin]=='+'){
                begin++;
            }
        }
        //数字
        for(int i = begin;i<arr.length;i++){
            if(arr[i]<'0'|| arr[i]>'9'){
                break;
            }
            list.add(arr[i]-'0');
        }
        //转型
        long resultLong = 0;
        for (int i:list){
            resultLong = resultLong*10+i;
            if(resultLong>Integer.MAX_VALUE){
                break;
            }
        }
        resultLong = positive?resultLong:-resultLong;
        if(resultLong>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(resultLong<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else {
            return (int)resultLong;
        }



    }

    public static void main(String[] args) {
        System.out.println(myAtoi(" 0-1"));

    }


}