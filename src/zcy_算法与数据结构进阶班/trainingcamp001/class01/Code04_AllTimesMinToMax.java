package zcy_算法与数据结构进阶班.trainingcamp001.class01;

import java.util.Stack;

/**
 * 给定一个只包含正数的数组arr，arr中任何一个子数组sub，
 * 一定都可以算出(sub累加和 )* (sub中的最小值)是什么，
 * 那么所有子数组中，这个值最大是多少？
 *
 * 思路：
 * 找到数组中每个元素 左右两侧第一个比他小的数值。中间的这些元素组成的数组就是"以当前元素作为最小值，乘积最大的子数组"
 * 不必校验更小的子数组，因为这是正整数，子数组的sum值肯定更小。
 * 如何快速的获取子数组的和：
 * 构造一个"和数组"，记录从arr[0]开始，到当前位置的所有元素的和，通过上述步骤已经知道子数组的左右范围，相减即可获得子数组的和。
 *
 * 为什么这里不用list？
 * 之前为什么需要list？ 在元素弹出时需要获取栈顶元素作为左边第一个比他小的值。如果相等时直接压入，在弹出时上面的相等值不能获取左边比他小的数值。
 * 现在为什么不需要了？
 * 在判断栈顶元素和当前值相等的时候，直接把栈顶元素弹出，无需存储相同值。因为弹出的元素的"地位" 和当前值一样，二者最终的子数组范围一样，min 都是自身。

 *
 * https://blog.csdn.net/u011624267/article/details/119743131
 */
public class Code04_AllTimesMinToMax {

	public static int max1(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int minNum = Integer.MAX_VALUE;
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
					minNum = Math.min(minNum, arr[k]);
				}
				max = Math.max(max, minNum * sum);
			}
		}
		return max;
	}

	public static int max2(int[] arr) {
		int size = arr.length;
		int[] sums = new int[size];
		sums[0] = arr[0];
		for (int i = 1; i < size; i++) {
			sums[i] = sums[i - 1] + arr[i];
		}
		int max = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < size; i++) {
			//注意，这里是>=
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				int j = stack.pop();
				//相等可以忽略
				if(arr[i] == arr[j]){
					continue;
				}
				//注意，这里不需要 arr[stack.peek() + 1]
				max = Math.max(max, (stack.isEmpty() ? sums[i - 1] : (sums[i - 1] - sums[stack.peek()])) * arr[j]);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			max = Math.max(max, (stack.isEmpty() ? sums[size - 1] : (sums[size - 1] - sums[stack.peek()])) * arr[j]);
		}
		return max;
	}

	public static int[] gerenareRondomArray() {
		int[] arr = new int[(int) (Math.random() * 20) + 10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 101);
		}
		return arr;
	}

	public static void main(String[] args) {
		int testTimes = 2000000;
		System.out.println("test begin");
		for (int i = 0; i < testTimes; i++) {
			int[] arr = gerenareRondomArray();
			if (max1(arr) != max2(arr)) {
				System.out.println("FUCK!");
				break;
			}
		}
		System.out.println("test finish");
	}

}
