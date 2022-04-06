package 算法和数据结构体系学习班.class14;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 *
 正整数组 costs , 正整数组 profits ， 正数 K，正数 M
 cost[i] 代表i号项目的花费
 profits[i] 代表 i号项目在扣除花费后还能挣到的钱（利润）
 K表示你只能串行的最多做K个项目
 M表示初始的资金
 说明：每做完一个项目，马上获得收益，可以支持你去做下一个项目。不能并行的做项目
 输出：最后获得的最大钱数

 思路：
 维护一个小根堆，里面元素按照花费进行排序 （小根堆的作用是锁住项目）
 维护一个大根堆，里面元素按照利润进行排序 （大根堆的作用是解锁项目）
 首先初始化小根堆，把所有元素放入小根堆。
 依次弹出可以做项目的小根堆元素，并放入大根堆。直到当前资金无法做小根堆的项目为止。
 弹出大根堆顶部元素。（此时真正做个这个项目），更新资金。
 根据更新后的资金继续弹出小根堆元素放入大根堆。弹出大根堆顶部元素进行交易。
 直到大根堆为空，或者到达最大交易次数为止

 体现的贪心思想： 利用当前资金，在所有能做的项目中先做最大利润的项目

 */

public class Code04_IPO {

	// 最多K个项目
	// W是初始资金
	// Profits[] Capital[] 一定等长
	// 返回最终最大的资金
public static int findMaximizedCapital(int K, int W, int[] profits, int[] costs) {
	PriorityQueue<Program> minCostQ = new PriorityQueue<>(new MinCostComparator());
	PriorityQueue<Program> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
	for (int i = 0; i < profits.length; i++) {
		minCostQ.add(new Program(profits[i], costs[i]));
	}
	for (int i = 0; i < K; i++) {
		while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
			maxProfitQ.add(minCostQ.poll());
		}
		if (maxProfitQ.isEmpty()) {
			return W;
		}
		W += maxProfitQ.poll().p;
	}
	return W;
}

public static class Program {
	public int p;
	public int c;

	public Program(int p, int c) {
		this.p = p;
		this.c = c;
	}
}

public static class MinCostComparator implements Comparator<Program> {
	@Override
	public int compare(Program o1, Program o2) {
		return o1.c - o2.c;
	}
}

public static class MaxProfitComparator implements Comparator<Program> {

	@Override
	public int compare(Program o1, Program o2) {
		return o2.p - o1.p;
	}
}

}
