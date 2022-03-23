package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * jh
 * 2019年08月20日  09：29
 * 有效的数独
 * 判断一个9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class Q_036_ValidSudoku {


    /**
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != ',') {
                    if (!set.add(c + "in row " + i)
                            || !set.add(c + "in col " + j)
                            || !set.add(c + "in corner " + i / 3 + "_" + j / 3)
                    ) {
                        return false;

                    }
                }

            }
        }
        return true;
    }
}






