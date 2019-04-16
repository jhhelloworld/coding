package lintcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * jh
 * 2019年03月14日  20：13
 * 给出一个候选数字的set(C)和目标数字(T),找到C中所有的组合，使找出的数字和为T。C中的数字可以无限制重复被选取。
 */
public class Q_135_CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();

        if(candidates==null){
            return result;
        }
        Arrays.sort(candidates);
        help(candidates,0,target,new ArrayList<Integer>(),result);


        return result;
    }


    public void help(int[] candidates,int begin,int target,List<Integer> subset,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(subset));
            //注意不要忘记return
            return;
        }
        for(int i = begin;i<candidates.length;i++){
            if(candidates[i]>target){
                break;
            }
            if(i!=0 && candidates[i]==candidates[i-1]){
                continue;
            }

            subset.add(candidates[i]);
            //注意 这里是 i，不是index
            help(candidates,i,target-candidates[i],subset,result);
            subset.remove(subset.size()-1);
        }

    }

}





































