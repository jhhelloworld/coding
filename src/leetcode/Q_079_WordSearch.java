package leetcode;

import zcy_lesson.code_advance_08.Code_01_TopKSumCrossTwoArrays;

import java.util.Base64;

/**
 * jh
 * 2019年08月26日  15：49
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class Q_079_WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        if(word == null || word.length() == 0){
            return true;
        }
        char head = word.charAt(0);
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                //找到第一个等于Word[0]的元素
                if(board[i][j] == head){
                    if(find(board,word,i,j,0)){
                        return true;
                    }
                }

            }
        }
        return false;

    }


    public boolean find(char[][] board, String word,int i,int j,int index){
        if(index == word.length()){
            return true;
        }
        //这里的边界判断是重点，第一次提交错误
        //if(i-1<0 || j-1<0||i+1>board.length||j+1>board[0].length||board[i][j]!=chars[index]){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length|| board[i][j]!=word.charAt(index)){
            return false;
        }
        board[i][j] = '#';
        boolean result = find(board,word,i,j+1,index+1)
                || find(board,word,i+1,j,index+1)
                || find(board,word,i-1,j,index+1)
                || find(board,word,i,j-1,index+1);
        board[i][j] = word.charAt(index);
        return result;

    }






}























