package a_test;

import java.util.*;

/**
 * jh
 * 2019年09月03日  22：11
 */
public class PracticeAtHome {



    public int longestIncreasingPath(int[][] matrix) {
        for(int i = 0;i<matrix.length ;i++){
            for(int j = 0;j<matrix[0].length;j++){
                process(matrix,i,j,new boolean[matrix.length][matrix[0].length],0);
            }
        }
        return result;

    }

    int  result=0;

    public void process(int[][] matrix,int i ,int j,boolean[][] used,int len){
        if(i<0||i==matrix.length || j<0 || j== matrix[0].length || used[i][j]){
            return;
        }
        int curValue = matrix[i][j];
        len++;
        result = Math.max(result,len);
        //不需要记录是否使用过 ，因为路径是递增的，不可能使用旧值
        used[i][j] = true;
        if(i-1>=0 &&matrix[i-1][j]>curValue){
            process(matrix,i-1,j,used,len);
        }
        if(i+1<matrix.length && matrix[i+1][j]>curValue){
            process(matrix,i+1,j,used,len);

        }
        if(j-1>=0 && matrix[i][j-1]>curValue){
            process(matrix,i,j-1,used,len);
        }
        if(j+1<matrix[0].length && matrix[i][j+1]>curValue){
            process(matrix,i,j+1,used,len);

        }
        used[i][j] =false;
    }


    /**
     * 上面解法超时，原因： 存在大量重复计算，计算出[i,j] 的最大值，假设[i,j+1]的值比[i,j]的值小，又需要计算一遍[i,j]
     *  实际上只需要 [i,j]+1即可
     *
     */

    //这个数组的作用是i使当前点向上下左右移动
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath2(int[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int m = matrix.length,n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for(int i = 0;i<matrix.length ;i++){
            for(int j = 0;j<matrix[0].length;j++){
                int len = process2(matrix,cache,i,j,m,n);
                max = Math.max(max,len);
            }
        }
        return max;
    }


    public int process2(int[][] matrix,int[][] cache,int i ,int j,int m,int n){
        if(cache[i][j] !=0){
            return cache[i][j] ;
        }
        int max = 1;
        for(int[] dir:dirs){
            int x = i+dir[0],y = j+dir[1];
            if(x<0||x>=m || y<0 || y>=n || matrix[x][y] <=matrix[i][j]){
                continue;
            }
            int len = 1+process2(matrix,cache,x,y,m,n);
            max = Math.max(max,len);
        }
        cache[i][j] = max;
        return max;



    }





}












































