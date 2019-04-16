package lintcode.recursion;

import com.sun.org.apache.xerces.internal.impl.ExternalSubsetResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * jh
 * 2019年03月13日  14：13
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集。
 */
public class Q_018_Subsets2 {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null ){
            return result;
        }
        if(nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>(),result);
        return result;
    }


    public static void dfs(int[] nums,int index,List<Integer> subset,List<List<Integer>> result){
        result.add(new ArrayList<>(subset));
        for(int i = index;i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            //i+1;不能i++,也不能++i，不能改变i值
            dfs(nums,++i,subset,result);
            subset.remove(subset.size()-1);


        }
    }






    public static void main(String[] args) {
        subsetsWithDup(new int[]{1,2,2});
    }




}
















