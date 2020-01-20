package leetcode;

import java.util.Calendar;

/**
 * jh
 * 2019年09月19日  12：41
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class Q_005_LongestPalindromicSubstring {

    //manacher 算法
    public static String longestPalindrome(String s) {
        char[] chars = manacherString(s);
        //最右边界
        int pR = -1;
        //最右边界对应的圆心
        int index = -1;
        //最长回文半径
        int maxLen = Integer.MIN_VALUE;
        //最长回文半径对应的圆心
        int maxIndex = -1;
        //每个位置所对应的回文半径
        int[] pArr = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            //如果i在最右边界范围内，可加速
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            //尝试向两个扩张
            while (i + pArr[i] < chars.length && i - pArr[i] >= 0) {
                if (chars[i + pArr[i]] == chars[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            //更新最右边界及所对应的圆心
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            //跟新最大值
            if (maxLen < pArr[i]) {
                maxLen = pArr[i];
                maxIndex = i;
            }
        }


        //生成最长回文串
        StringBuilder sb = new StringBuilder();
        int endIndex = maxIndex + maxLen - 2;
        int beginIndex = maxIndex - maxLen + 2;
        for (int i = beginIndex; i <= endIndex; i = i + 2) {
            sb.append(chars[i]);
        }

        return sb.toString();

    }


    private static char[] manacherString(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return result;
    }


}