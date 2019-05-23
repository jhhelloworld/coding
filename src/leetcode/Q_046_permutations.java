package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * jh
 * 2019年05月16日  14：41
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Q_046_permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),nums);
        return result;


    }
    public static void backtrack(List<List<Integer>> result,List<Integer> tempList,int[] nums){
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
        }else{
            for(int i = 0;i<nums.length;i++){
                if(tempList.contains(nums[i])){
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(result,tempList,nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}