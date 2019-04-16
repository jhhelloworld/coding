package leetcode;

import java.beans.beancontext.BeanContext;

/**
 * jh
 * 2019年02月28日  15：34
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
        int[] arr = new int[]{8,9,9};
        for (int i:plusOne(arr)){
            System.out.print(i);
        }
    }
}