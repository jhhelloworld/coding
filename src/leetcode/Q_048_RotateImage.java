package leetcode;

import jdk.nashorn.internal.objects.NativeUint8Array;

/**
 * jh
 * 2019年08月21日  14：41
 */
public class Q_048_RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length<2|| matrix.length != matrix[0].length){
            return;
        }

        int left = 0,right = matrix.length-1,top = 0,bottom = matrix.length-1;
        //由外层到内层旋转
        while (left<right){
            //从左上角的元素开始，顺时针旋转
            for(int i = 0;i<right-left;i++){
                int temp = matrix[top][left+i];
                matrix[top][left+i] = matrix[bottom-i][left];
                matrix[bottom-i][left] = matrix[bottom][right-i];
                matrix[bottom][right-i] = matrix[top+i][right];
                matrix[top+i][right] = temp;


            }
            left++;
            right--;
            top++;
            bottom--;
        }
    }
}