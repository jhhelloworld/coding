package leetcode;

/**
 * jh
 * 2019年09月05日  14：45
 *
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class Q_191_NumberOf1Bits {
    // you need to treat n as an unsigned value

    /**
     * 思路：
     *  n&n-1  把n的最后一个1变为0
     */
    public int hammingWeight(int n) {
        int result = 0;
        while (n!=0){
            n = n&n-1;
            result++;
        }
        return result;



    }
}