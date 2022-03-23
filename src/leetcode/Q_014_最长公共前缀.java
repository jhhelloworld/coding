package leetcode;

/**
 * jh
 * 2019年08月15日  16：36
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串""。
 * 示例1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母a-z。
 */
public class Q_014_最长公共前缀 {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return sb.toString();
        }
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }
        for (int i = 0; i < minLength; i++) {
            boolean success = true;
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    success = false;
                    break;
                }
            }
            if (!success) {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] ss = new String[]{"flower", "flow", "flight"};


        System.out.println(longestCommonPrefix(ss));
    }

}