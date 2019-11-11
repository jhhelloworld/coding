package leetcode;

/**
 * jh
 * 2019年09月10日  16：50
 * <p>
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 输入: [3,0,1]
 * 输出: 2
 */
public class Q_268_MissingNumber {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        result ^= nums.length;
        return result;

    }
}