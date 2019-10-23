package leetcode;

/**
 * jh
 * 2019年09月05日  11：43
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 你算法的时间复杂度应为 O(log n) 。
 */
public class Q_172_FactorialTrailingZeroes {

    /**
     * 要在末位产生0，则必然是5×2，即使是原数中包含的0也可以分解，因此将题目简化为寻找阶乘中5的个数，即n//5，
     * 但是要考虑到这只找到了n中是5倍数的所有数，例如25，即在25!中找到了5个是5的倍数的数分别为5,10,15,20,25，
     * 要注意这之中的25依然可以分解为5的倍数，因此n//5其实是少计入了一部分情况的。
     */
    public int trailingZeroes(int n) {
        int result = 0;
        while (n>=5){
            n /= 5;
            result += n;
        }
        return result;

    }

}