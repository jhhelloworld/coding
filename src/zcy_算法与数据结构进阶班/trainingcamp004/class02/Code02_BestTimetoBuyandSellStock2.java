package zcy_算法与数据结构进阶班.trainingcamp004.class02;

public class Code02_BestTimetoBuyandSellStock2 {

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int ans = 0;
		for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i-1], 0);
		}
		return ans;
	}

}
