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


    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>>  result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        process(result,path,root,target);
        return result;
    }

    public static void process(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, TreeNode head, int target) {
        if (head == null) {
            return;
        }
        target -= head.val;
        path.add(head.val);
        if (target == 0 && head.left == null && head.right == null) {
            result.add(new ArrayList<Integer>(path));
        }
        process(result, path, head.left, target);
        process(result, path, head.right, target);
        path.remove(path.size()-1);



    }

    public static void main(String[] args) {

    }
}




