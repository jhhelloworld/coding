package leetcode;

/**
 * jh
 * 2019年09月05日  14：26
 *
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class Q_190_ReverseBits {
    // you need treat n as an unsigned value

    /**
     * 思路：
     * 每次取到最右边的数
     * n 向右移1；
     * result 向左移1 ，并且加上最右边的数
     */
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0;i<32;i++){
            int end = n&1;
            n >>=1;
            //注意下面两步的顺序
            result<<=1;
            result|= end;
        }
        return result;
    }
}