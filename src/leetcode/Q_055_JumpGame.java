package leetcode;

/**
 * jh
 * 2019年08月22日  13：39
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 */
public class Q_055_JumpGame {
    //思路:动态规划
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }

        //定义一个新数组 ，存储所有可能到达的位置
        boolean[] can = new boolean[nums.length];
        can[0] = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (can[i]) {
                int len = nums[i];
                for (int j = 1; j <= len; j++) {
                    if (i + j < nums.length) {
                        //及时终止
                        if (i + j == nums.length - 1) {
                            return true;
                        }
                        can[i + j] = true;
                    } else {
                        //数组 越界 ，终止
                        break;
                    }
                }
            }
        }
        return false;
    }


    //最优解
    public boolean canJump2(int[] A) {
        //if(A.length <= 1)
        //return true;

        int max = 0; //max stands for the largest index that can be reached.

        for (int i = 0; i < A.length; i++) {

            //if not enough to go to next
            if (max < i) {
                return false;
            }
            //update max
            if (i + A[i] > max) {
                max = i + A[i];
            }
            //max is enough to reach the end
            if (max >= A.length - 1) {
                return true;
            }
        }
        return false;

    }


}