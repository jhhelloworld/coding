package leetcode;

import com.sun.tools.classfile.Opcode;
import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.*;

/**
 * jh
 * 2019年08月25日  14：42
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 */
public class Q_073_SetMatrixZeroes {


    //第一次提交，使用俩个hashSet记录 行和列为0的值。空间复杂度o(M+N)
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return;
        }
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for(int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix.length;j++){
                if (matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Iterator<Integer> iterator = row.iterator();
        while (iterator.hasNext()){
            int rowIndex = iterator.next();
            for(int i = 0;i< matrix[0].length;i++){
                matrix[rowIndex][i] = 0;
            }

        }
        iterator = col.iterator();
        while (iterator.hasNext()){
            int colIndex = iterator.next();
            for(int i = 0;i< matrix.length;i++){
                matrix[i][colIndex] = 0;
            }

        }
    }


    //第一行和第一列记录该行或该列是否有0，[0,0] 是行和列的公共数据，在这里表示行0，另一个变量 col0，表示第一列是否有0
    public static void setZeroes2(int[][] matrix) {
        int col0 = 1;
        for(int i = 0;i<matrix.length;i++){
            //检查第一列是否有0，注意这里只给col0赋值，没有给行赋值，因为本身就是0 无需重复赋值
            if(matrix[i][0] == 0){
                col0 = 0;
            }
            //记录每行每列是否出现0
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //赋0，从后往前，原因：如果从前往后，假设第一行中出现过0，第一行全部赋值0，就把上一步的记录状态值覆盖了
        for(int i= matrix.length-1;i>=0;i--){
            //注意这里是j>=1
            for(int j = matrix[0].length-1;j>=1;j--){
                if(matrix[i][0] == 0|| matrix[0][j] == 0){
                    matrix[i][j] =0;
                }
            }
            if(col0 == 0){
                matrix[i][0] = 0;
            }
        }

    }










    public static void main(String[] args) {

        int[][] n = new int[][]{{0,2},{3,4}};
        setZeroes2(n);







        Map<String,String> map = new HashMap<>();


        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "," + value);
        }

        for (String key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println("=========================");

        for (String values : map.values()) {
            System.out.println(values);
        }


        Set<String> set = new HashSet<String>();
        //遍历
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //或者这样
        for (String s:set) {
            System.out.println(s);
        }
    }
}