package leetcode;

import java.awt.*;

/**
 * jh
 * 2019年09月12日  16：43
 * <p>
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 */
public class Q_329_LongestIncreasingPathInAMatrix {
    public static int longestIncreasingPath(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                process(matrix, i, j, new boolean[matrix.length][matrix[0].length], 0);
            }
        }
        return result;

    }

    static int result = 0;

    public static void process(int[][] matrix, int i, int j, boolean[][] used, int len) {
        if (i < 0 || i == matrix.length || j < 0 || j == matrix[0].length || used[i][j]) {
            return;
        }
        int curValue = matrix[i][j];
        len++;
        result = Math.max(result, len);
        used[i][j] = true;
        if (i - 1 >= 0 && matrix[i - 1][j] > curValue) {
            process(matrix, i - 1, j, used, len);
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] > curValue) {
            process(matrix, i + 1, j, used, len);

        }
        if (j - 1 >= 0 && matrix[i][j - 1] > curValue) {
            process(matrix, i, j - 1, used, len);
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > curValue) {
            process(matrix, i, j + 1, used, len);

        }
        used[i][j] = false;
    }


    public static void main(String[] args) {
        int[][] nums = new int[][]
                {
                        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                        {19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
                        {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                        {39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
                        {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                        {59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
                        {60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
                        {79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
                        {80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
                        {99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
                        //{100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
                        //{119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
                        //{120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
                        //{139, 138, 137, 136, 135, 134, 133, 132, 131, 130},
                        //{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };

        System.out.println(longestIncreasingPath(nums));
    }


    //动态规划版本
    class Solution {
        public final int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int m = matrix.length, n = matrix[0].length;
            int result = 1;
            int[][] cache = new int[m][n];
            ;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result = Math.max(result, process(matrix, cache, i, j, m, n));

                }
            }
            return result;
        }


        public int process(int[][] matrix, int[][] cache, int i, int j, int m, int n) {
            //如果递归到的位置已经计算过，直接返回
            if (cache[i][j] != 0) {
                return cache[i][j];
            }

            int max = 1;
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || matrix[i][j] >= matrix[x][y]) {
                    continue;
                }
                int len = 1 + process(matrix, cache, x, y, m, n);
                max = Math.max(len, max);
            }
            cache[i][j] = max;
            return max;

        }
    }
}

















