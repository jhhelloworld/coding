package lintcode.backtracking;

/**
 * jh
 * 2019年03月14日  16：43
 */
public class Q_123_WordSearch {
    /**
     * @param board: A list of lists of character
     * @param word:  A string
     * @return: A boolean
     */
    public static boolean exist(char[][] board, String word) {
        // write your code here
        //find index0
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        char head = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == head) {
                    if (find(board, 0, i, j, word)) {
                        return true;
                    }
                }

            }
        }
        return false;

    }

    public static boolean find(char[][] board, int index, int i, int j, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length  || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        //???
        board[i][j] = '#';
        boolean rst = find(board, index + 1, i - 1, j, word) ||
                find(board, index + 1, i + 1, j, word) ||
                find(board, index + 1, i, j + 1, word) ||
                find(board, index + 1, i, j - 1, word);
        board[i][j] = word.charAt(index);
        return rst;

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a'}};
        exist(board,"b");


    }


}