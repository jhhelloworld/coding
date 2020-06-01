package leetcode;

import java.util.Arrays;

/**
 * jh
 * 2019年01月04日  14：10
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Q_003_无重复字符的最长子串 {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abababc"));
    }

    /**
     * 思路：0,1,....i-1,i,...
     *  当遍历到i位置时，导致重复的字符，要么是 i-1位置时的重复字符，要么是上一个 chars[i] 的位置
     *  二者相比取后一个即可
     */
    public static int lengthOfLongestSubstring(String s) {
        //预处理
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        //map[chars[i]]  记录字符上一次出现的位置,初始值为-1
        int[] map = new int[255];
        Arrays.fill(map,-1);
        //pre：当前遍历到i,包含i-1的最长无重复的前一个位置
        int pre = -1;
        //记录最大结果
        int result = 0;
        //当前位置最大长度
        int current = 0;
        for(int i = 0;i<chars.length;i++){
            pre = Math.max(map[chars[i]],pre);
            map[chars[i]] = i;
            current = i-pre;
            result = Math.max(current,result);

        }
        return result;
    }
}