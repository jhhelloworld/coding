package leetcode;

import java.sql.Statement;
import java.util.Stack;

/**
 * jh
 * 2019年08月27日  11：38
 */
public class Q_084_LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length ==0){
            return 0;
        }
        //记录最大面积
        int result = 0;
        //单调栈结构
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<heights.length;i++){
            while (!stack.isEmpty() && heights[i]<= heights[stack.peek()]){
                //弹出位置为cur,以cur为高的矩形，左边界为弹出后 stack.peek,右边界为i
                int cur = stack.pop();
                int left = stack.isEmpty()?-1:stack.peek();
                result = Math.max(result,heights[cur]*(i-left-1));

            }
            stack.push(i);
        }
        //处理其他数据
        while (!stack.isEmpty()){
            int cur = stack.pop();
            int left = stack.isEmpty()?-1:stack.peek();
            result = Math.max(result,heights[cur]*(heights.length-left-1));

        }


        return result;
    }


    public static void main(String[] args) {
        int[] height = new int[]{1};
        System.out.println(largestRectangleArea(height));
    }
}