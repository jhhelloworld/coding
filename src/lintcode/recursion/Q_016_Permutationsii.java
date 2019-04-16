package lintcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * jh
 * 2019年03月08日  13：12
 * 给出一个具有重复数字的列表，找出列表所有不同的排列。
 */
public class Q_016_Permutationsii {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);

        return results;
    }

    private static void dfs(int[] nums,
                     boolean[] visited,
                     List<Integer> permutation,
                     List<List<Integer>> results) {
        if (nums.length == permutation.size()) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> result = permuteUnique(new int[]{1,2,2});
        System.out.println();
    }

}