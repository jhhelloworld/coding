package leetcode;

import java.util.Stack;

/**
 * jh
 * 2019年01月11日  18：55
 *
 * quotient and remainder.
 * Given an integer, return its base 7 string representation.
 * Input: 100  Output: "202"
 *
 * Input: -7  Output: "-10"
 */

public class Q_504_Base7 {
    public static String convertToBase7_0(int num) {
        boolean isPositive = num>=0?true:false;
        num = Math.abs(num);
        if(num == 0 )
            return "0";
        Stack<Integer> stack = new Stack<>();
        int remainder = num%7;
        int quotient = num/7;
        stack.push(remainder);
        while (quotient!=0){
            remainder = quotient%7;
            quotient = quotient/7;
            stack.push(remainder);
        }
        StringBuilder sb = new StringBuilder();
        if(!isPositive){
            sb.append('-');
        }
        while (!stack.empty()){
            int i = stack.pop();
            sb.append(i);
        }
        return sb.toString();

    }

    public String convertToBase7(int num) {
        if (num < 0)
            return '-' + convertToBase7(-num);
        if (num < 7)
            return num + "";
        return convertToBase7(num / 7) + num % 7;
    }



    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7'
    };

    public String convertToBase7_2(int num) {
        //return Integer.toString(num, 7);
        char buf[] = new char[33];
        boolean negative = (num < 0);
        int charPos = 32;

        if (!negative) {
            num = -num;
        }

        while (num <= -7) {
            buf[charPos--] = digits[-(num % 7)];
            num = num / 7;
        }
        buf[charPos] = digits[-num];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (33 - charPos));
    }


    public String convertToBase7_3(int num) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        boolean negative = false;

        if (num < 0) {
            negative = true;
        }
        while (num != 0) {
            sb.append(Math.abs(num % 7));
            num = num / 7;
        }

        if (negative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }



    public static void main(String[] args) {
    }
}