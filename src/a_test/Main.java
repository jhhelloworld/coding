package a_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * jh
 * 2019年04月15日  23：56
 */
public class Main {
    private static ArrayList<String> result = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static ArrayList<String> Permutation(String str) {
        if(str==null || str.length() ==0){
            return  result;
        }
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        dfs(arr,0);
        return result;



    }
    public static void dfs(char[] arr ,int begin){
        if(sb.length()==arr.length){
            result.add(sb.toString());
        }else {
            for(int i = begin;i<arr.length;i++){
                sb.append(arr[i]);
                if(i+1<arr.length && arr[begin] == arr[i]){
                    continue;
                }
                swap(arr,i,begin);
                dfs(arr,begin+1);
                swap(arr,i,begin);
                sb.delete(sb.length()-1,sb.length());
            }
        }


    }

    public static void swap(char[] arr ,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("abc");
        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());


        Permutation("abc");

    }




}




