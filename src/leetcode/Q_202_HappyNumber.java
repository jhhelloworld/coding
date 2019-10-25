package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * jh
 * 2019年09月05日  15：24
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 */
public class Q_202_HappyNumber {
    /**
     * 不是快乐数的数称为不快乐数(unhappy number)，所有不快乐数的数位平方和计算，
     * 最后都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中
     * 重点是找出是否存在循环
     * 找是否存在循环与两周方法 1. set  2. 快慢指针
     */


    //快慢指针
    public int getsquare(int n){
        int result = 0;
        while (n>0){
            int remainder = n%10;
            result += remainder*remainder;
            n /= 10;
        }
        return result;
    }

    public  boolean isHappy(int n) {
        int slow = n;
        int fast = getsquare(n);
        while (slow!=fast){
            slow = getsquare(slow);
            fast = getsquare(getsquare(fast));
        }
        return slow == 1;
    }


    //利用set
    public boolean isHappy2(int n){
        Set<Integer> record = new HashSet<>();
        while (record.add(n)){
            int square = getsquare(n);
            if (square == 1){
                return true;
            }
            n = square;
        }
        return false;
    }




}