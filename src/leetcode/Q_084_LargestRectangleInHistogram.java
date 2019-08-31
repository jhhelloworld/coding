package leetcode;

import java.sql.Statement;
import java.util.Stack;

/**
 * jh
 * 2019年08月27日  11：38
 */
public class Q_084_LargestRectangleInHistogram {
    /**
     * 数组中的最大矩形
     * 单调栈结构
     * 如果当前值比栈顶元素大，直接入栈
     * 如果小于等于栈顶元素，则依次出栈，知道比栈顶元素大或者栈为空
     * 出栈元素的右边界是当前遍历位置，左边界是栈顶元素，栈为空则为-1
     * 如果最终栈不为空，依次弹出栈的元素，左边界为栈顶元素，有边界为数组右边界
     */
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