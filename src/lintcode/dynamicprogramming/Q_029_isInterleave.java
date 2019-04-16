package lintcode.dynamicprogramming;

/**
 * jh
 * 2019年03月12日  19：54
 * 给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
 */
public class Q_029_isInterleave {
    public static boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] interleve = new boolean[s1.length() + 1][s2.length() + 1];
        interleve[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1) && interleve[i - 1][0] == true) {
                interleve[i][0] = true;
            }
        }
        for (int i = 1; i <= s2.length(); i++) {
            if (s3.charAt(i - 1) == s2.charAt(i - 1) && interleve[0][i - 1] == true) {
                interleve[0][i] = true;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if((interleve[i-1][j]==true && s3.charAt(i+j-1) == s1.charAt(i-1)) ||
                        (interleve[i][j-1] == true && s3.charAt(i+j-1) == s2.charAt(j-1))){
                    interleve[i][j] =true;

                }

            }
        }
        if(interleve[s1.length()][s2.length()]){
            return true;
        }else {
            return false;
        }


    }

    public static void main(String[] args) {
        isInterleave("aabcc","dbbca","aadbbcbcac");
    }
}