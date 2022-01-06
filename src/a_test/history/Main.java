package a_test.history;



import javafx.scene.chart.LineChart;

import java.util.*;
import java.util.stream.Collectors;

/**
 * jh
 * 2019年04月15日  23：56
 * [10,1,11,2,12,3,11]
 * 4
 */
public class Main {



    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.equals("")){
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] map = new int[256];
        for(int i = 0;i<map.length;i++){
            map[i] = -1;
        }
        int pre = -1;
        int result = 0;
        for(int i = 0;i<s.length();i++){
            pre = Math.max(pre,map[chars[i]]);
            int currentMax = i-pre;
            result = Math.max(currentMax,result);
            map[chars[i]] = i;
        }
        return result;




    }








    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();


        char[] arr = str.toCharArray();
        for(int i = 0;i<arr.length;i++){

        }




        return 0;
    }








    //约瑟夫  https://blog.csdn.net/u011500062/article/details/72855826
    public int LastRemaining_Solution(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            list.add(i);
        }
        while (list.size()!=1){

        }




        return list.get(0);


    }







    //topK
    public int findKthLargest(int[] nums, int k) {
        //快排思想
        return 0;

    }


















    int N = 0;
    int count = 0;
    public int totalNQueens(int n) {
        N=n;
        DFS(0, 0, 0, 0);
        return count;
    }
    void DFS(int row, int col, int pie, int na) {
        //这里的col,pie,na都以二进制位的形式表示是否有占位，1表示有占位
        if (row >= N) {
            count++;
            return;
        }
        int bits = ( ~ (col | pie | na) ) & ((1 << N) - 1);
        //这里通过三个数相或来判断占位，取反使得1表示空位，同时用后面的式子消除高位的1
        while (bits > 0) {
            int p = bits & -bits; //这里是取最后一个1的位置，如对于1010来说p为0010
            DFS(row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            /*
             *对于row显然+1，col跟p或进行占位，pie和na在下一行显然分别左移1位右移1位
             *00100
             *01010
             *10001
             */
            bits = bits & (bits - 1);//消掉最后一个1，即这个位不符合，检查下一个1位
        }
    }













































      public class TreeNode {
          int val;
         TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public TreeNode buildTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(pre[0]);
        stack.push(root);

        int preIndex = 1, inIndex = 0;
        while (preIndex < pre.length) {
            TreeNode lastNode = null;
            while (inIndex < in.length && stack.peek() != null && stack.peek().val == in[inIndex]) {
                lastNode = stack.pop();
                inIndex++;
            }

            if (lastNode != null) {
                stack.push(lastNode);
            }

            TreeNode curNode = new TreeNode(pre[preIndex]);

            if (lastNode == null) {
                stack.peek().left = curNode;
            } else {
                stack.pop().right = curNode;
            }

            stack.push(curNode);
            preIndex++;
        }

        return root;
    }























































    //蓄水池算法

    public  static  int rand(int max){
        return (int) Math.random()*max+1;
    }

    public static int[] getKNumsRand(int k, int max) {
        if(k<1 || max<1){
            return null;
        }
        int[] result = new int[Math.min(k,max)];
        for(int i = 0;i<result.length;i++){
            result[i] = i;
        }
        for(int i = k+1;i<max+1;i++){
            int random = rand(i);
            if(random<=k){
                result[rand(k)] = i;
            }
        }
        return result;


    }









    //




    //约瑟夫环

    //滑动窗口

    //接雨水




    //两个数组中 位数   https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
    //topk
    //第K大 https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
    //数据流第K大：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
    // 前K个高频元素 ：https://leetcode-cn.com/problems/top-k-frequent-elements/
    //最长递增子序列

    //手写 LRU https://mp.weixin.qq.com/s/GYTyrp5vTVibVYI-3NHrNA
    //接雨水 https://leetcode-cn.com/problems/trapping-rain-water/


}



















