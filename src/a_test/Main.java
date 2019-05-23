package a_test;

import util.TreeNode;

import java.util.*;

/**
 * jh
 * 2019年04月15日  23：56
 * [10,1,11,2,12,3,11]
 * 4
 */
public class Main {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2};
        subsets(nums);

    }


    public static int multiply(int n){
        if(n==1){
            return 1;
        }
        else {
            return n*multiply(n-1);
        }
    }
}




