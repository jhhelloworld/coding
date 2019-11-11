package leetcode;

import java.sql.SQLOutput;

/**
 * jh
 * 2019年09月10日  16：55
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 */
public class Q_279_PerfectSquares {

    //初始思路，找到小于或等于n的平方数，不正确，例如 12 = 4+4+4   12=9+1+1+1
    public static int numSquares(int n) {
        if(n<1){
            return 0;
        }
        int rest = n;
        int result = 0;
        while (rest>0){
            int sqr = (int)Math.floor(Math.sqrt(rest));
            rest -= sqr*sqr;
            result++;
        }
        return result;


    }

    public int numSquares2(int n) {
        int[] dp = new int[n+1];
        for(int i = 1;i<=n;i++){
            dp[i] = i;
            for(int j = 2;i-j*j>=0;j++){
                //状态转移方程
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }








    public static void main(String[] args) {

        System.out.println(numSquares(12));

        System.out.println(Math.floor(1.1));
    }
}