package leetcode;

/**
 * jh
 * 2019年08月27日  15：09
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Q_042_TrappingRrainWater {

    public int trap(int[] height) {
        if(height == null || height.length<3){
            return 0;
        }
        //定义4个变量：left,right 两个游标，   leftMax,rightMax:left左边的最大值和right右边的最大值
        int left = 1,right = height.length-1,leftMax = height[0],rightMax = height[height.length-1];
        int result = 0;

        while (left<=right){
            if(leftMax<rightMax){
                if(height[left]<leftMax){
                    result += leftMax-height[left];
                }else {
                    leftMax=height[left];
                }

                left++;
            }else {
                if(height[right]<rightMax){
                    result+= rightMax - height[right];
                }else {
                    rightMax = height[right];
                }

                right--;
            }
        }
        return result;



    }
}