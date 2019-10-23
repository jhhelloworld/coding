package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * jh
 * 2019年09月05日  12：33
 * <p>
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * todo 比较器总结
 */
public class Q_179_LargestNumber {

    //思路：贪心算法
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length==0){
            return "";
        }
        String[] strings = new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            strings[i] = String.valueOf(nums[i]);
        }
        //一定要会写这个方法
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                //逆序!!
                return s2.compareTo(s1);
            }
        });
        //如果入参为[0,0] 只需返回一个0
        if(strings[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<nums.length;i++){
            sb.append(strings[i]);
        }
        return sb.toString();




    }
}