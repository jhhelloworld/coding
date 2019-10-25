package leetcode;

/**
 * jh
 * 2019年09月05日  14：54
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class Q_198_HouseRobber {

    //思路 动态规划  dp 方程 dp[i] = max(dp[i-2]+nums[i], dp[i-1])
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {

            return nums[0];
        }

        int[] rob = new int[nums.length];
        rob[0] = nums[0];
        rob[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            rob[i] = Math.max(nums[i] + rob[i - 2], rob[i - 1]);
        }
        return rob[rob.length - 1];
    }

    //节省空间的做法
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lastlast = 0;
        int last = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(lastlast + nums[i], last);
            lastlast = last;
            last = result;
        }
        return result;
    }
}