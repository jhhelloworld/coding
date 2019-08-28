package leetcode;

import java.beans.beancontext.BeanContext;

/**
 * jh
 * 2019年02月28日  15：34
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
public class Q_066_PlusOne {
    public static int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return digits;
        }
        for(int i = digits.length-1;i>=0;i--){
            if(digits[i] ==9){
                digits[i]=0;
                continue;
            }else {
                digits[i] = digits[i]+1;
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;


    }


    public static void main(String[] args) {
        int[] arr = new int[]{9,9,9};
        for (int i:plusOne(arr)){
            System.out.print(i);
        }
    }
}