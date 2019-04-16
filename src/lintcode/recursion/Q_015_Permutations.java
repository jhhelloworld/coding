package lintcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * jh
 * 2019年03月08日  10：49
 * 给定一个数字列表，返回其所有可能的排列。
 */
public class Q_015_Permutations {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);

        return results;
    }

    private static void dfs(int[] nums,
                     boolean[] visited,
                     List<Integer> permutation,
                     List<List<Integer>> results) {
        if (nums.length == permutation.size()) {
            // 不要直接加permutation
            results.add(new ArrayList<Integer>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
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
        List<List<Integer>> list = permute(new int[]{1,2,3});

        System.out.println("");
    }



}