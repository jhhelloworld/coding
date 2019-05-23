package zcy_book_v2.chapter_1_stackandqueue;

import java.util.Stack;

/**
 * 最大矩阵面积
 */
public class Problem_09_MaximalRectangle {

	public static int maxRecSize(int[][] map) {
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		int maxArea = 0;
		int[] height = new int[map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
			}
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}

	/**
	 * 一个数组如果代表直方图，求最大矩形面积
	 * @param height
	 * @return
	 */
	public static int maxRecFromBottom(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int maxArea = 0;
		//单调栈
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			//栈不为空并且当前数小于等于栈顶的值   注意：如果等于的话也弹出 TODO why 设 23334  相当于放弃了前两个3取最大值的可能
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
				//弹出
				int j = stack.pop();
				//结算 k是左边界，如果弹出之后是空，则是-1位置，否则是弹出之后栈顶的位置   i是右边界  自己在j位置
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i - k - 1) * height[j];
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		//处理其余数据
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			//右边界是数组最右位置
			int curArea = (height.length - k - 1) * height[j];
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[][] map = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 }, };
		System.out.println(maxRecSize(map));
	}

}
