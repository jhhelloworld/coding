package leetcode;

/**
 * jh
 * 2019年09月10日  20：04
 */
public class Q_289_GameOfLife {

    public void gameOfLife(int[][] board) {
        judge(board);
        recover(board);
    }

    /**
     * 第一次：判断细胞生死，并且做下面状态转化
     * 1->0  :3
     * 1->1  :5
     * 0->0  :2
     * 0->1  :4
     */
    public void judge(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    if (getLiveNumber(board, i, j) == 2 || getLiveNumber(board, i, j) == 3) {
                        board[i][j] = 5;
                    } else {
                        board[i][j] = 3;
                    }
                } else {
                    if (getLiveNumber(board, i, j) == 3) {
                        board[i][j] = 4;
                    } else {
                        board[i][j] = 2;
                    }
                }

            }
        }
    }


    //统计活着的细胞的个数
    private int getLiveNumber(int[][] board, int i, int j) {
        int result = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x == i && y == j || x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                    continue;
                }
                if ((board[x][y] & 1) == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    //矩阵恢复
    private void recover(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] < 4) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
    }
}