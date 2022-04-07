package 算法和数据结构体系学习班.class14;

import java.util.PriorityQueue;


/**
   一块金条切成两半，需要花费和长度值一样的铜板
   比如长度为20的金条，无论怎么切都需要花费20个铜板。一群人想整分整块金条，怎么分最省铜板。
   例如，给定数组:{10,20,30} 代表一共三个人，整块金条长度是60，金条要分成 10，20，30三部分
   如果先把金条分成 10 和 50，花费60个铜板，再把长度为50的金条分成20和30，再花费50个铜板，一共花费110个铜板。
   但是如果如果先分成30和30，在把其中一个30分成10和20，共花费90铜板
   输入一个数组，返回分割的最小代价


 暴力递归思路
 合并任意两个元素，枚举所有可能。

 贪心思路：
 维护一个小根堆，存储当前金条状况。每次优先合并最小的两根金条。
 把合并后的金条重新放回小根堆，继续上面的步骤。


 堆和排序是贪心算法最常用的两个手段
 小根堆、大根堆、排序 是贪心算法最常用的三个模型。


 */

public class Code02_LessMoneySplitGold {

	// 纯暴力！
	public static int lessMoney1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return process(arr, 0);
	}

	// 等待合并的数都在arr里，pre之前的合并行为产生了多少总代价
	// arr中只剩一个数字的时候，停止合并，返回最小的总代价
	public static int process(int[] arr, int pre) {
		if (arr.length == 1) {
			//第一次coding 写成了返回是arr[0]，肯定不是arr[0] ，arr[0] 是固定值，即金条总长度。
			return pre;
		}
		int ans = Integer.MAX_VALUE;
		//枚举任意两段合并
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				ans = Math.min(ans, process(copyAndMergeTwo(arr, i, j), pre + arr[i] + arr[j]));
			}
		}
		return ans;
	}

	//返回一个新数组，数组长度比原数组小1，除i,j外其他元素不变，i+j合并成一个元素
	public static int[] copyAndMergeTwo(int[] arr, int i, int j) {
		int[] ans = new int[arr.length - 1];
		int ansi = 0;
		for (int arri = 0; arri < arr.length; arri++) {
			if (arri != i && arri != j) {
				ans[ansi++] = arr[arri];
			}
		}
		ans[ansi] = arr[i] + arr[j];
		return ans;
	}

	public static int lessMoney2(int[] arr) {
		//默认按照整数大小排序
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			pQ.add(arr[i]);
		}
		int sum = 0;
		int cur = 0;
		while (pQ.size() > 1) {
			//小根堆弹出两个，计算之后再扔回去。 其实这就是霍夫曼树
			cur = pQ.poll() + pQ.poll();
			sum += cur;
			pQ.add(cur);
		}
		//堆里只剩一个的时候返回sum
		return sum;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (maxValue + 1));
		}
		return arr;
	}

	public static void main(String[] args) {
		int testTime = 100000;
		int maxSize = 6;
		int maxValue = 1000;
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			if (lessMoney1(arr) != lessMoney2(arr)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");
	}

}
