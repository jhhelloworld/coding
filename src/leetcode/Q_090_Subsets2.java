package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * jh
 * 2019年08月25日  23：50
 *
 * 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 */
public class Q_090_Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length ==0){
            return result;
        }
        Arrays.sort(nums);
        process(result,new ArrayList<>(),nums,0);
        return result;

    }


    public void process(List<List<Integer>> result,List<Integer> tempList,int[] nums,int index){
        result.add(new ArrayList<>(tempList));
        for(int i = index;i<nums.length;i++){
            if(i!=index && nums[i] == nums[i-1]){
                continue;
            }
            tempList.add(nums[i]);
            process(result,tempList,nums,index+1);
            tempList.remove(tempList.size()-1);
        }
    }
}