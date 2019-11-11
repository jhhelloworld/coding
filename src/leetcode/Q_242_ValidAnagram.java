package leetcode;

/**
 * jh
 * 2019年09月10日  16：46
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class Q_242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (map[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            map[t.charAt(i) - 'a']--;
        }
        return true;

    }
}