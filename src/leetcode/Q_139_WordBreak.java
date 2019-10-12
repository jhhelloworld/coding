package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * jh
 * 2019年09月03日  12：46
 */
public class Q_139_WordBreak {
    //初始思路：动态规划
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> setDict = new HashSet<>(wordDict);
        boolean[] can = new boolean[s.length()];
        can[0] = true;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (can[i]) {
                for (int j = i; j < chars.length; j++) {
                    String temp = s.substring(i, j + 1);
                    if (setDict.contains(temp)) {

                        if (j == s.length() - 1) {
                            return true;
                        } else {
                            can[j + 1] = true;
                        }
                    }
                }
            }

        }
        return false;
    }


    /**
     * 暴力递归  超时
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        process(s, wordDict);
        return result;
    }

    boolean result = false;

    public void process(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            result = true;
            return;
        }
        for (String dict : wordDict) {
            if (s.startsWith(dict)) {
                String rest = s.substring(dict.length());
                process(rest, wordDict);
            }
        }
    }


    /**
     * 动态规划——遍历词典
     * 设s="leetcodeleetcode" dict = "leet"."code"
     * 递归思想：从左到右遍历，Leet命中，只要后面的 也能拆分，则能拆分
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        record = new Boolean[s.length()];
        return process2(s, wordDict, 0);
    }

    //记录 i 开始后面是否可以被拆分
    Boolean[] record;

    public boolean process2(String s, List<String> wordDict, int i) {
        if (i > s.length()) {
            return false;
        }
        if (i == s.length()) {
            return true;
        }
        if (record[i] != null) {
            return record[i];
        }
        boolean result = false;
        for (String word : wordDict) {
            if (s.indexOf(word, i) == i) {
                result = process2(s, wordDict, i + word.length());
                if (result) {
                    break;
                }
            }
        }
        record[i] = result;

        return result;

    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        String s = "leetcodes";
        System.out.println(s.startsWith("code", 4));


        System.out.println(wordBreak(s, list));
        ;
    }

}