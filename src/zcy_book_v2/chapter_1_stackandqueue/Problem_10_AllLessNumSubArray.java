package zcy_book_v2.chapter_1_stackandqueue;

import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组的数量
 */
public class Problem_10_AllLessNumSubArray {

	public static int getNum(int[] arr, int num) {
		if (arr == null || arr.length == 0 || num < 0) {
			return 0;
		}
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int left = 0;
		int right = 0;
		int res = 0;
		while (left < arr.length) {
			//扩到不能再扩就停
			while (right < arr.length) {
				//最小值结构更新
				if (qmin.isEmpty() || qmin.peekLast() != right) {
					while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[right]) {
						qmin.pollLast();
					}
					qmin.addLast(right);
					//最大值结构更新
					while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[right]) {
						qmax.pollLast();
					}
					qmax.addLast(right);
				}
				//停止
				if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
					break;
				}
				right++;
			}
			res += right - left;
			//最小值更新结构是否过期
			if (qmin.peekFirst() == left) {
				qmin.pollFirst();
			}
			if (qmax.peekFirst() == left) {
				qmax.pollFirst();
			}
			left++;
		}
		return res;
	}

	// for test
	public static int[] getRandomArray(int len) {
		if (len < 0) {
			return null;
		}
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * 10);
		}
		return arr;
	}

	// for test
	public static int getNumRightWay(int[] arr, int num) {
		int res = 0;
		for (int start = 0; start < arr.length; start++) {
			for (int end = start; end < arr.length; end++) {
				if (isValid(arr, start, end, num)) {
					res++;
				}
			}
		}
		return res;
	}

	public static boolean isValid(int[] arr, int start, int end, int num) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		return (max - min) <= num;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int size = 5;
		int testTime = 1000000;
		for (int i = 0; i < testTime; i++) {
			int[] arr = getRandomArray(size);
			int num = (int) (Math.random() * size);
			if (getNum(arr, num) != getNumRightWay(arr, num)) {
				printArray(arr);
				System.out.println(num);
				System.out.println(getNum(arr, num));
				System.out.println(getNumRightWay(arr, num));
				break;
			}
		}
	}

}
