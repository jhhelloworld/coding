package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * jh
 * 2019年09月04日  17：59
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 */
public class Q_149_MaxPointsOnALine {

    /**
     * 思路：从左到右遍历个点，统计这个点及以后最多有多少个点在一个直线上
     * 每遍历一个点生成一个map ：key为斜率，为了防止float或者double精度问题，先求最小公约数，再同除最小公约数，用字符串存储斜率
     * 重合点特殊处理
     */
    public int maxPoints(int[][] points) {
        if(points.length < 3){
            return points.length;
        }
        //记录最终结果
        int result = 1;
        for(int i = 0;i<points.length-1;i++){
            //与原点重合点的数量
            int origin = 1;
            //当前直线上点的数量（不包括原点），注意初始值为0
            int curMax = 0;
            Map<String ,Integer > map = new HashMap<>();
            for(int j = i+1;j<points.length;j++){
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if(x ==0 && y == 0){
                    origin++;
                }else {
                    int gcd = generateGcd(x,y);
                    x /= gcd;
                    y /= gcd;
                    String key = x+"_"+y;
                    int curCount = map.getOrDefault(key,0)+1;
                    map.put(key,curCount);
                    curMax = Math.max(curMax,curCount);
                }
            }
            result = Math.max(result,curMax+origin);
        }
        return result;
    }

    public int generateGcd(int x,int y){
        if(y == 0){
            return x;
        }
        return generateGcd(y,x%y);
    }







    //时间空间最优解
    //用乘替换除，解决精度问题
    static int result = 0;

    public static int maxPoints2(int[][] points) {
        int len = points.length;
        if (len < 3) {
            return len;
        }

        for (int i = 0; i < len - 1; i++) {
            //相邻两个点的坐标差，实际上就是固定一点，在下面的子方法中找斜率相同的值
            int x = points[i + 1][0] - points[i][0];
            int y = points[i + 1][1] - points[i][1];
            if (x != 0 || y != 0) {
                maxPointsHelper(points, x, y, i);
            }
        }
        //怎么解决的重复点问题：
        //如果数组中所有点都相等，返回数组长度
        //只要有不相同的两个点，就能进入下面的方法，就能统计到所有的点
        return result == 0 ? len : result;
    }

    //为什么入参是long的格式，下面有乘法，如果int可能会越界
    private static void maxPointsHelper(int[][] points, long a, long b, int base) {
        int path = 2;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            if (i != base && i != base + 1) {
                if ((points[i][1] - points[base][1]) * a == (points[i][0] - points[base][0]) * b)
                {
                    path++;
                }
            }
        }
        result = Math.max(result, path);
    }


    public static void main(String[] args) {
        double a = 94911151 / 94911150;
        float b = 94911152 / 94911151;
        System.out.println(a);
        System.out.println(b);

        int[][] arr =new int[][]{{0,0},{1,1},{4,2},{3,1}};
        System.out.println(maxPoints2(arr));




    }






}