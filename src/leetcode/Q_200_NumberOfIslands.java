package leetcode;

import javax.sql.rowset.FilteredRowSet;

/**
 * jh
 * 2019年09月05日  15：13
 *
 * todo 深度优先 广度优先 并查集
 */
public class Q_200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        int[][] steps = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    infection(grid, i, j, steps);
                }
            }
        }
        recovery(grid);
        return result;


    }


    /**
     * 感染函数
     */
    public void infection(char[][] grid, int i, int j, int[][] steps) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        for (int[] step : steps) {
            int m = i + step[0];
            int n = j + step[1];
            infection(grid, m, n, steps);
        }
    }

    //恢复函数
    public void recovery(char[][] grid){
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '2'){
                    grid[i][j] = '1';
                }
            }
        }

    }
}