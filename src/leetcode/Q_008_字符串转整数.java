package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * jh
 * 2019年02月27日  09：46
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * 提示：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
public class Q_008_字符串转整数 {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean positive = true;
        List<Integer> list = new ArrayList<>();
        char[] arr = str.toCharArray();
        int begin = 0;
        //去空
        for (char c : arr) {
            if (c == ' ') {
                begin++;
                continue;
            } else {
                break;
            }
        }
        //符号
        if (begin < arr.length) {
            if (arr[begin] == '-') {
                positive = false;
                begin++;
            } else if (arr[begin] == '+') {
                begin++;
            }
        }
        //数字
        for (int i = begin; i < arr.length; i++) {
            if (arr[i] < '0' || arr[i] > '9') {
                break;
            }
            list.add(arr[i] - '0');
        }
        //转型
        long resultLong = 0;
        for (int i : list) {
            resultLong = resultLong * 10 + i;
            if (resultLong > Integer.MAX_VALUE) {
                break;
            }
        }
        resultLong = positive ? resultLong : -resultLong;
        if (resultLong > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (resultLong < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) resultLong;
        }

    }


    //时间最优解
    public int myAtoi2(String str) {
        int index = 0;
        int len = str.length();
        //assume it is a positive integer by default
        int sign = 1;
        long result = 0;
        //remove the whitespace in the front
        while (index < len && str.charAt(index) == ' ') {
            index++;
        }
        //handle sign
        if (index < len && str.charAt(index) == '+') {
            index++;
        } else if (index < len && str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        while (index < len && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            result = result * 10 + str.charAt(index) - '0';
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-1) * result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            index++;
        }
        return (int) result * sign;
    }


    public static void main(String[] args) {
        System.out.println(myAtoi(" 0-1"));


    }


}