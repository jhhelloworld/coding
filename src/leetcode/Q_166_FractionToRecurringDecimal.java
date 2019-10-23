package leetcode;

import com.sun.org.apache.bcel.internal.generic.LineNumberGen;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * jh
 * 2019年09月05日  00：06
 *
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 *
 */
public class Q_166_FractionToRecurringDecimal {
    /**
     * 思路：
     *  两数相除如果为小数，肯定为循环小数
     *  什么时候是一个循环：小数部分 商出现过
     *  因此 需要一个hashmap存储小数部分出现过的商，并且记录出现这个商的时候string的长度，两个重复的商的区间加括号
     *  除此之外注意符号问题
     *
     */
    public String fractionToDecimal(int numerator, int denominator) {
        //如果不加这句，0，-5 会返回-0
        if(numerator == 0){
            return "0";
        }
        //处理符号
        StringBuilder sb = new StringBuilder();
        sb.append((numerator<0)^(denominator<0)?"-":"");
        //生成绝对值,注意用long类型 因为如果 是Integer.MIN_VALUE 绝对值还是负数  注意强转,不强转最小值还是负值
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        //处理整数部分
        sb.append(num/den);
        num %= den;
        if(num == 0){
            return sb.toString();
        }
        //处理小数部分
        sb.append(".");
        //hashmap key:余数 value string 长度
        //为什么存余数，不存商 存商，重复时已经多出一位，需要减去一位、
        Map<Long,Integer> map = new HashMap<>();

        while (num!=0){
            num *= 10;
            sb.append(num/den);
            num %= den;
            if(map.containsKey(num)){
                int index = map.get(num);
                sb.insert(index,"(");
                sb.append(")");
                break;

            }else {
                map.put(num,sb.length());
            }

        }
        return sb.toString();


    }

    public static void main(String[] args) {
        int a = -1;
        int b =  2147483647;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.abs(b));

        long num = Math.abs( Integer.MIN_VALUE);
        System.out.println(num);


    }



}






























