package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * jh
 * 2019年08月25日  21：45
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 */
public class Q_078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length==0){
            return result;
        }
        process(result,new ArrayList<>(),nums,0);
        return result;


    }

    public static void process(List<List<Integer>> result,List<Integer> tempList,int[] nums,int start){
        result.add(new ArrayList<>(tempList));
        for(int i = start;i<nums.length;i++){
            tempList.add(nums[i]);
            //注意，这里是i+1，不是start+1
            process(result,tempList,nums,start+1);
            tempList.remove(tempList.size()-1);
        }

    }
}































