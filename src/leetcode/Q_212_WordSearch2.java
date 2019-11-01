package leetcode;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * jh
 * 2019年09月06日  23：25
 * <p>
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 */
public class Q_212_WordSearch2 {
    /**
     * 思路：
     * 1. 和查找单词1 不同点在于：这里是多个单词，大体思路类似，但是这里要查找多个单词，可以使用set但不是最优解
     * 2.对words建立 trieTree 。
     * 3. 遍历二维数组，判断字母在trieTree第一层是否存在，若存在，进入回溯过程
     * 4. 回溯过程和 查找单词1 类似，只是不是单纯的判断周围的字母和单词的下一个字母是否匹配，而是需要去trieTree中去寻找
     * 5. 这里建立的 trieTree 不需要有非常完善的功能，只需要记录路径，以及在末尾赋值对应单词即可。
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> reuslt = new ArrayList<>();
        TrieNode root = buildTrieTree(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, reuslt, root, i, j);

            }
        }
        return reuslt;
    }


    public void dfs(char[][] board, List<String> result, TrieNode root, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        char c = board[i][j];
        if (c == '#' || root.map[c - 'a'] == null) {
            return;
        }
        root = root.map[c - 'a'];
        if (root.word != null) {
            result.add(root.word);
            //防止重复
            root.word = null;
        }

        board[i][j] = '#';
        dfs(board, result, root, i - 1, j);
        dfs(board, result, root, i + 1, j);
        dfs(board, result, root, i, j - 1);
        dfs(board, result, root, i, j + 1);
        board[i][j] = c;
    }


    public TrieNode buildTrieTree(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if (cur.map[index] == null) {
                    cur.map[index] = new TrieNode();
                }
                cur = cur.map[index];
            }
            cur.word = word;

        }
        return root;
    }
    public class TrieNode {
        String word;
        TrieNode[] map = new TrieNode[26];
    }

}



