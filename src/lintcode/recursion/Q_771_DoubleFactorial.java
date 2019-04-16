package lintcode.recursion;

/**
 * jh
 * 2019年03月13日  10：38
 * 给定一个数n，返回该数的二阶阶乘。在数学中，正整数的二阶阶乘表示不超过这个正整数且与它有相同奇偶性的所有正整数乘积。
 */
public class Q_771_DoubleFactorial {
    public static long doubleFactorial(int n) {
        // Write your code here
        if(n<=0){
            return 1;
        }
        return n*doubleFactorial(n-2);
    }

    public static void main(String[] args) {
        System.out.println(doubleFactorial(6));

    }

}