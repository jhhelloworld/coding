package leetcode;

import util.ListNode;

import java.util.*;

/**
 * jh
 * 2019年08月21日  16：24
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Q_049_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = getKey(s);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }

        }
        return new ArrayList<List<String>>(map.values());
    }

    public static String getKey(String s) {






        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return String.valueOf(charArr);
        //下面这行返回的是数组地址
        //return charArr.toString();
    }


    public static void main(String[] args) {



        System.out.println(getKey("abc"));
        System.out.println(getKey("bca"));

        System.out.println();
    }


}













