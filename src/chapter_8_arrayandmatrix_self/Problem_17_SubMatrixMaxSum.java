package chapter_8_arrayandmatrix_self;

/**
 * @author Jianghua
 * 2018年11月06日  11：09
 */
public class Problem_17_SubMatrixMaxSum {
    public static int maxSum(int[][] m) {
        if(m == null || m.length == 0 || m[0].length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null;
        for(int i = 0; i<m.length;i++){
            s= new int[m[0].length];
            for(int j = i; i<m.length;j++){
                cur = 0;
                for(int k = 0;k<s.length;k++){
                    s[k]+= m[k][k];
                    cur = cur + s[k];
                    max = Math.max(cur,max);
                    cur = cur<0?0:cur;
                }
            }
        }



        return max;
    }
}