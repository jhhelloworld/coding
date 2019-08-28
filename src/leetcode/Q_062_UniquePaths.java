package leetcode;

/**
 * jh
 * 2019年08月23日  15：22
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *输入 7，3  输出 28    输入 3，2 输出 3
 *
 */
public class Q_062_UniquePaths {

public static int uniquePaths(int m, int n) {
    int[] result = new int[n];
    //第一行只有一个可能
    for(int i = 0;i<n;i++){
        result[i] = 1;
    }
    for(int i = 1;i<m;i++){
        for(int j = 1;j<n;j++){
            result[j] += result[j-1];
        }
    }
    return result[n-1];
}





}