package leetcode;

import sun.util.resources.es.CurrencyNames_es_UY;

import java.rmi.MarshalException;
import java.util.*;

/**
 * jh
 * 2019年09月03日  15：22
 */
public class Q_140_WordBreak2 {


    //第一次提交超时
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || wordDict == null || wordDict.size() == 0) {
            return result;
        }
        Set<String> set = new HashSet<>(wordDict);
        process(result, s, set, new StringBuilder(), 0);
        return result;

    }

    public static void process(List<String> result, String s, Set<String> wordDict, StringBuilder sb, int index) {
        if (index == s.length()) {
            result.add(sb.toString().substring(0, sb.length() - 1));
            return;
        }
        if (index > s.length()) {
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String temp = s.substring(index, i);
            if (wordDict.contains(temp)) {
                sb.append(temp).append(" ");
                process(result, s, wordDict, sb, i);
                sb.delete(sb.length() - temp.length() - 1, sb.length());
            }
        }
    }




    //在上题中记录的是能否到达，在这里需要记录路径，防止重复计算
    public static List<String> wordBreak2(String s, List<String> wordDict) {
        Map<String, List<String>> record = new HashMap<>();

        List<String> list = DFS(s, wordDict, record);
        return list;
    }

    // DFS function returns an array including all substrings derived from s.
    static List<String> DFS(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }


    public static void main(String[] args) {
        String s = "catsanddog";
        String[] ss = new String[]{"cat", "cats", "and", "sand", "dog"};
        List<String> sss = Arrays.asList(ss);
        wordBreak2(s, sss);
        System.out.println(s.substring(3));
    }


}

















