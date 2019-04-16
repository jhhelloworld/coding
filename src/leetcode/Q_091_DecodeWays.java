package leetcode;

/**
 * jh
 * 2019年03月06日  14：06
 * 难点：处理0
 */
public class Q_091_DecodeWays {
    public static int numDecodings(String s) {//split
        int start = 0;
        int end = 0;
        int result = 0;

        while (end<s.length()){
            if(Integer.valueOf(s.substring(end,end+1))==0){
                return 0;
            }
            boolean contain0 = false;
            while (end<s.length()-1 && Integer.valueOf(s.substring(end,end+2))<=26 ){

                if(Integer.valueOf(s.substring(end,end+2))==10  || Integer.valueOf(s.substring(end,end+2))==20){
                    contain0 = true;
                    break;
                }else {
                    end++;
                }

            }
            if(contain0){
                result+=step(end<=start?1:end-start);
                start = start+2;
                end = end+2;


            }else {
                result+=step(end-start+1);
                end++;
                start++;
            }









        }
        return result;

    }


    public static int step(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return step(n-1)+step(n-2);
    }


    public static void main(String[] args) {
        numDecodings2("10000");

    }

    public static int numDecodings2(String s) {
        int[] dp = new int[s.length() + 1];
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        //important
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char prev = s.charAt(i - 1);
            if (prev == '1' || prev == '2') {
                if (cur == '0') {
                    dp[i + 1] = dp[i - 1];
                } else if (prev == '1' || (prev == '2' && cur <= '6')) {
                    dp[i + 1] = dp[i - 1] + dp[i];
                } else {
                    dp[i + 1] = dp[i];
                }
            }
            //important
            else if (cur <= '9' && cur >= '1' && (prev == '0' || prev > '2')) {
                if(cur=='0'&& prev=='0'){
                    return  dp[s.length()];
                }
                dp[i + 1] = dp[i];
            }
        }
        return dp[s.length()];
    }
}