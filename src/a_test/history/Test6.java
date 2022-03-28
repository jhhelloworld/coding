package a_test.history;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import util.TreeNode;

import java.util.*;

/**
 * jh
 * 2019年08月23日  19：22
 */
public class Test6 {

    /**
     * 非递归
     *
     */
    public static int longestSubstring(String s, int k) {
        int d = 0;

        for (int numUniqueTarget = 1; numUniqueTarget <= Math.min(26,s.length()); numUniqueTarget++) {
            d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));
        }

        return d;
    }

    /**
     *  有 numUniqueTarget个不同的字符，每个字符至少重复k次的最长子串
     *
     */
    private static int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
        int[] map = new int[128];
        int numUnique = 0; // counter 1
        int numNoLessThanK = 0; // counter 2
        int begin = 0, end = 0;
        int d = 0;

        while (end < s.length()) {
            if (map[s.charAt(end)]++ == 0) {
                numUnique++; // increment map[c] after this statement
            }
            if (map[s.charAt(end++)] == k) {
                numNoLessThanK++; // inc end after this statement
            }

            while (numUnique > numUniqueTarget) {
                if (map[s.charAt(begin)]-- == k) {
                    numNoLessThanK--; // decrement map[c] after this statement
                }
                if (map[s.charAt(begin++)] == 0) {
                    numUnique--; // inc begin after this statement
                }
            }

            // 如果我们找到一个字符串，其中唯一字符的数量等于numUniqueTarget，并且所有这些字符重复至少K次，然后更新最大值
            if (numUnique == numUniqueTarget && numUnique == numNoLessThanK) {
                d = Math.max(end - begin, d);
            }
        }

        return d;
    }




    /**
     * 递归
     * 思想：把原始字符串分成按照 子串的字符是否出现>=k，分成一个个子串
     * 出现次数少于k 的子串不可能是最终结果
     *
     */
    public static int longestSubstring2(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = new char[26];
        // 记录每个字母出现的次数
        for (int i = 0; i < s.length(); i += 1) {
            chars[s.charAt(i) - 'a'] += 1;
        }
        //当前字符串是否符合需求
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (chars[i] < k && chars[i] > 0) {
                flag = false;
            }
        }
        // 当前字符串符合需求
        if (flag == true) {
            return s.length();
        }
        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring2(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring2(s.substring(start), k));
        return result;
    }


    public static void main(String[] args) {
        String s = "ababdccde";
        System.out.println(longestSubstring2(s,2));
    }


}











