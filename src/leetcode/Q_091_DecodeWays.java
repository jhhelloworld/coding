package leetcode;

/**
 * jh
 * 2019年03月06日  14：06
 * 难点：处理0
 * 一条包含字母A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释:它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释:它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 *

 */
public class Q_091_DecodeWays {
    public int numDecodings(String s) {
        if(s == null|| s.length() == 0){
            return 0;
        }
        //第一个字符为0，不可能解码
        if(s.charAt(0)=='0'){
            return 0;
        }

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 1;i<s.length();i++){
            if(1<=Integer.parseInt(s.substring(i,i+1)) && Integer.parseInt(s.substring(i,i+1))<=9){
                dp[i+1] += dp[i];
            }
            if(Integer.parseInt(s.substring(i-1,i+1))<=26 && 10<=Integer.parseInt(s.substring(i-1,i+1))){
                dp[i+1] +=dp[i-1];

            }
            //如果到i，解码方法为0，没必要处理后续步骤
            if(dp[i+1] == 0){
                return 0;
            }
        }
        return dp[s.length()];
    }
}