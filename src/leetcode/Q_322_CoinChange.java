package leetcode;

/**
 * jh
 * 2019年09月11日  14：23
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 */
public class Q_322_CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 ){
            return -1;
        }
        int[] dp = new int[amount+1];
        int max = Integer.MAX_VALUE;
        //第一次，从1开始把所有值初始化为最大值
//        for(int i = 1;i<dp.length;i++){
//            dp[i] = max;
//        }

        //第一次 把coin[0]以及倍数计算为正常值
        for(int i = 1;i<dp.length;i++){
            dp[i] = max;
            if(i-coins[0]>=0 && dp[i-coins[0]]!=max){
                dp[i] = dp[i-coins[0]]+1;
            }
        }



        int leftMin = 0;
        for(int i = 1;i<coins.length;i++){
            for(int j = 1;j<dp.length;j++){
                //如果是0 结果会比较小
                leftMin = max;
                int oldMin = dp[j];
                //这样写 max+1变为负数
                // int leftMin = j-coins[i]>=0?dp[j-coins[i]]+1:max;
                if(j-coins[i]>=0 &&dp[j-coins[i]]!=max ){
                    leftMin = dp[j-coins[i]]+1;
                }
                dp[j] = Math.min(oldMin,leftMin);
            }
        }
        return dp[amount] == max?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,10,1};
        System.out.println(coinChange(nums,27));
    }
}