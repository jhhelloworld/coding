package leetcode;

/**
 * jh
 * 2019年08月28日  15：32
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class Q_050_PowxN {

    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2) == 0? myPow(x*x,n/2):x*myPow(x*x,n/2);
    }
}