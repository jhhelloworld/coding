package leetcode;

/**
 * jh
 * 2019年08月25日  19：23
 * <p>
 * 最小覆盖子串
 * <p>
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案
 */
public class Q_076_MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        //预处理
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        //记录返回结果的左右坐标
        int resultBegin = 0, resultEnd = 0;
        //记录遍历过程的左右坐标
        int begin = 0, end = 0;
        //记录包含t的最小长度
        int minLen = Integer.MAX_VALUE;
        //记录 begin——end 还缺少多少t的字符
        int match = t.length();
        //bitmap 记录每个字母还缺少多少个才能全部包含
        int[] map = new int[256];
        //初始化bitmap
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        char[] chars = s.toCharArray();
        //遍历s
        while (end != s.length()) {
            //更新map和match
            map[chars[end]]--;
            //减一后>=0 ——>  原来大于0，表示是t的字符
            if (map[chars[end]] >= 0) {
                match--;
            }
            //match==0,表示当前字符串片段包含t的所有字符，但是不一定是最短，应该从begin逐渐右移，直到最短
            if (match == 0) {
                while (map[chars[begin]] < 0) {
                    map[chars[begin++]]++;
                }
                if (end - begin + 1 < minLen) {
                    resultBegin = begin;
                    resultEnd = end;
                    minLen = end - begin + 1;
                    //left最后右移，同时更新match 和map
                    match++;
                    map[chars[begin++]]++;

                }
            }

            end++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(resultBegin, resultEnd + 1);
    }


    //时间最优解
    public String minWindow2(String s, String t) {
        char[] sa = s.toCharArray();
        int left = 0;
        int right = 0;
        int minLeft = -1;
        int minSoFar = Integer.MAX_VALUE;
        int[] map = new int[128];
        int count = t.length();
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        while (right < sa.length) {
            if (map[sa[right++]]-- > 0) {
                count--;
            }

            while (count == 0) {
                if (minSoFar > right - left) {
                    minSoFar = right - left;
                    minLeft = left;
                }

                if (map[sa[left++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLeft == -1 ? "" : s.substring(minLeft, minLeft + minSoFar);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));

    }
}
























