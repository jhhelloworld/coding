package leetcode;

/**
 * jh
 * 2019年09月05日  15：50
 *
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class Q_204_CountPrimes {

    /**
     * 思路
     *  1. 如果分别除从2——n-1 肯定是 超时的
     *  2. 可以只统计 i范围 2——n-1
     *  3. 当 i 为质数时 把 i*2  i*3 直到 n-1标记为非质数
     *  4. 统计1——sqrt(n) 的质数的个数
     */
    public static int countPrimes(int n) {
        if(n<3){
            return 0;
        }
        int result = 0;
        //如果是质数，值为false，非质数是true
        boolean[] mark = new boolean[n];
        for(int i = 2;i<n;i++){
            if(!mark[i]){
                System.out.println(i);
                int j=i+i;
                while (j<n){
                    mark[j] = true;
                    j+=i;
                }
                result++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        countPrimes(999983);
    }

}