package leetcode;

/**
 * jh
 * 2019年09月20日  14：35
 * 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素\
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
public class Q_010_RegularExpressionMatching {


    /**
     * 递归 执行时间 577毫秒
     */
    public static boolean match(char[] str, char[] pattern) {
        //数据预处理
        if (str == null || pattern == null) {
            return false;
        }

        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);


    }

    //递归流程， strIndex: str匹配位置  patternIndex 模板匹配位置
    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //str 和 pattern都到尾，返回成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern到尾 str没到尾 返回失败
        //str 到尾，pattern没到尾，可能成功，比如 ""，和".*"   或    "aa"和 "aaa*"
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //patternIndex+1是*，且strIndex跟patternIndex匹配,分3种匹配模式；如不匹配，pattern后移2位
        //为什么要加  strIndex!=str.length 的判断： 上面两个if同时不满足，比如""，和".*" 会报越界
        //为什么 不用加   patternIndex == pattern.length  ，上面两个if已经把这种情况包括了
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (strIndex != str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
                return matchCore(
                        //* 继续匹配下一位 strIndex后移1位，patternIndex不动 "aaa"  "a*"
                        str, strIndex + 1, pattern, patternIndex)
                        //*匹配1个 strIndex后移1位，patternIndex后移两位    "abc" "a*bc"
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        //*匹配0个 strIndex不动，patternIndex后移两位  "abc"   "a*abc"
                        || matchCore(str, strIndex, pattern, patternIndex + 2);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //patternIndex+1不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if (strIndex != str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;


    }


    /**
     * 更简单的递归 执行时间28ms
     * ------------------------------------------------------------------------------------------------
     */


    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatch(s.toCharArray(),0,p.toCharArray(),0);

    }


    public boolean isMatch(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (patternIndex == pattern.length) {
            return strIndex == str.length;
        }


        /**
         * 思路是 每次从当前位置选两个，先比较第一个是否匹配，再看第二个是否是*
         */
        boolean first = strIndex < str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.');

        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            return isMatch(str, strIndex, pattern, patternIndex + 2)
                    || first && isMatch(str, strIndex + 1, pattern, patternIndex);
        } else {
            //当前匹配并后面的都匹配
            return first && isMatch(str, strIndex + 1, pattern, patternIndex + 1);
        }
    }


    /**
     * - 动态规划-----------------------------------------------------------------------------------------------
     */


    static int[][] cache;

    public static boolean isMatch3(String s, String p) {
        //为什么加一？  如果si到了末尾，pi没有到末尾 ，递归的加一操作会 这时候 si 可能等于s.length
        cache = new int[s.length() + 1][p.length() + 1];
        return process(s, 0, p, 0);
    }

    public static boolean process(String s, int si, String p, int pi) {
        if (pi == p.length()) {
            return si == s.length();
        }
        // 什么时候会加速递归 （si+1,pi）后存储，后面的 （si+1,pi+1）会用到
        if (cache[si][pi] != 0) {
            return cache[si][pi] == 1;
        }

        boolean curMatch = false;
        // si 什么时候会等于s.length
        boolean firstMatch =si<s.length() && ( s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.');
        if (pi < p.length() - 1 && p.charAt(pi + 1) == '*') {
            curMatch = process(s, si, p, pi + 2) || (firstMatch && process(s, si + 1, p, pi));
        } else {
            curMatch = firstMatch && process(s, si + 1, p, pi + 1);
        }
        cache[si][pi] = curMatch ? 1 : -1;
        return curMatch;

    }


    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "c*a*b";
    }






}