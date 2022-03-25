package zcy_算法与数据结构进阶班.trainingcamp001.class01;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 单调栈实现（无重复数+有重复数）
 * 目标：找到数组中各个元素的左边第一个比他小的数，和右边第一个比他小的数。
 */

/**
 * 思路：
 *
 * 数组中没有重复的元素：
 * 维护一个栈，存储数组下标，从栈底到栈顶对应的数组元素是递增的。
 * 遍历数组，如果当前数值 > 栈顶对应的数值,直接入栈。
 * 如果当前数值 < 栈顶对应的数值, 一次从栈顶弹出，直到栈顶值比当前值小为止。
 * 每弹出一个数，就生成弹出这个数的 "左边第一个比他小的数，和右边第一个比他小的数"
 * 规则是：
 * 1. 使他弹出的这个数，就是右边第一个比他小的数(这两个数中间不可能有比他小的数，如过有，在遍历到这个数的时候就弹出了)
 * 2. 栈中下一层的数就是左边第一个比他小的数。（当初就是因为比下一层的数大，才入的栈），如果已经是栈底，就说明左边没有比他小的数了。
 * 然后把当前值对应的数组下标压入栈。
 * 遍历完数组后，单独处理栈里面还剩下的数据。这些元素不是由于某个数的出现让他弹出，而是数组遍历完才弹出的，所以右边离他最近的比他小的数——无
 * 1. 对于剩下的元素来说，右边没有比自己小的数
 * 2. 左边比自己小的数，和上面逻辑相同。
 *
 * 数组中有重复的元素：
 * 栈不能存储单个位置，存储结构变为：Stack<List<Integer>>， 存储一组数值相同的元素对应的下标。
 * 入栈规则：
 * 如果当前数值比栈顶元素List中任意一个大，则直接入栈（下一层对应的数值相同，直接和第一个比就好），加入到List尾部。
 * 如果当前数值比栈顶元素小，则开始弹出。
 * List中右边第一个比他小的值，就是当前遍历的值，这一点和没有重复元素的场景相同。
 * List中左边第一个比他小的元素，是下一层中，List末尾的元素（因为他是最后加入的）
 * 当前元素入队，加入到List尾部。
 * 遍历完数组后，弹出规则和上面类似。
 *
 */
public class Code03_MonotonousStack {

	public static int[][] getNearLessNoRepeat(int[] arr) {
		int[][] res = new int[arr.length][2];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				int popIndex = stack.pop();
				//第一次写代码写成了 stack.pop()
				int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
				res[popIndex][0] = leftLessIndex;
				res[popIndex][1] = i;
			}
			stack.push(i);
		}
		//剩余元素容易忘记
		while (!stack.isEmpty()) {
			int popIndex = stack.pop();
			int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
			res[popIndex][0] = leftLessIndex;
			res[popIndex][1] = -1;
		}
		return res;
	}

	// arr [3, 2, 1, 4, 5]
	//      0  1  2  3  4
	
	//  [
	//    0 :  [-1,  1  ]
	//    1 :  [-1,  2  ]
	
	//  ] 
	//
	public static int[][] getNearLess(int[] arr) {
		int[][] res = new int[arr.length][2];
		
		
		// List<Integer> -> 放的是位置，同样值的东西，位置压在一起
		// 代表值    底  ->  顶   小  -> 大
		Stack<List<Integer>> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) { // i -> arr[i] 进栈
			// 底 -> 顶， 小 -> 大
			while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
				List<Integer> popIs = stack.pop();
				// 取位于下面位置的列表中，最晚加入的那个
				int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
				for (Integer popi : popIs) {
					res[popi][0] = leftLessIndex;
					res[popi][1] = i;
				}
			}
			// 相等的、比你小的
			if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
				stack.peek().add(i);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				stack.push(list);
			}
		}
		while (!stack.isEmpty()) {
			List<Integer> popIs = stack.pop();
			// 取位于下面位置的列表中，最晚加入的那个
			int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
			for (Integer popi : popIs) {
				res[popi][0] = leftLessIndex;
				res[popi][1] = -1;
			}
		}
		return res;
	}

	// for test
	public static int[] getRandomArrayNoRepeat(int size) {
		int[] arr = new int[(int) (Math.random() * size) + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < arr.length; i++) {
			int swapIndex = (int) (Math.random() * arr.length);
			int tmp = arr[swapIndex];
			arr[swapIndex] = arr[i];
			arr[i] = tmp;
		}
		return arr;
	}

	// for test
	public static int[] getRandomArray(int size, int max) {
		int[] arr = new int[(int) (Math.random() * size) + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * max) - (int) (Math.random() * max);
		}
		return arr;
	}

	// for test
	public static int[][] rightWay(int[] arr) {
		int[][] res = new int[arr.length][2];
		for (int i = 0; i < arr.length; i++) {
			int leftLessIndex = -1;
			int rightLessIndex = -1;
			int cur = i - 1;
			while (cur >= 0) {
				if (arr[cur] < arr[i]) {
					leftLessIndex = cur;
					break;
				}
				cur--;
			}
			cur = i + 1;
			while (cur < arr.length) {
				if (arr[cur] < arr[i]) {
					rightLessIndex = cur;
					break;
				}
				cur++;
			}
			res[i][0] = leftLessIndex;
			res[i][1] = rightLessIndex;
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[][] res1, int[][] res2) {
		if (res1.length != res2.length) {
			return false;
		}
		for (int i = 0; i < res1.length; i++) {
			if (res1[i][0] != res2[i][0] || res1[i][1] != res2[i][1]) {
				return false;
			}
		}

		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int size = 10;
		int max = 20;
		int testTimes = 2000000;
		for (int i = 0; i < testTimes; i++) {
			int[] arr1 = getRandomArrayNoRepeat(size);
			int[] arr2 = getRandomArray(size, max);
			if (!isEqual(getNearLessNoRepeat(arr1), rightWay(arr1))) {
				System.out.println("Oops!");
				printArray(arr1);
				break;
			}
			if (!isEqual(getNearLess(arr2), rightWay(arr2))) {
				System.out.println("Oops!");
				printArray(arr2);
				break;
			}
		}
	}
}
