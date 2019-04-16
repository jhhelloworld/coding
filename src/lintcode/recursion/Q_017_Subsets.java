package lintcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * jh
 * 2019年03月08日  13：13
 * 给定一个含不同整数的集合，返回其所有的子集。
 */
public class Q_017_Subsets {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs(nums,result,new ArrayList<Integer>(),0);
        return result;


    }

    public void dfs(int[] nums,List<List<Integer>> result,List<Integer> subset,int index){
        //注意不要写成nums.length-1
        if(index == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index++]);
        dfs(nums,result,subset,index);
        subset.remove(subset.size()-1);
        dfs(nums,result,subset,index);


    }


}