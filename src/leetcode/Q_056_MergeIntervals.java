package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * jh
 * 2019年08月22日  15：26
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Q_056_MergeIntervals {


    //注意：非基础类型是选择排序
    public int[][] merge(int[][] intervals) {


        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            } else {
                newInterval = intervals[i];
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);

    }


    //这里虽然分别为 start end 排序，但是使用的是快速排序
    public int[][] merge2(int[][] intervals) {
        // if(intervals.length<=1) return new int[0][0];
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<int[]> res = new ArrayList<int[]>();
        //i 为遍历节点，j为当前合并区间的第一个节点。
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || start[i + 1] > end[i]) {
                int[] tmp = {start[j], end[i]};
                res.add(tmp);
                j = i + 1;
            }
        }
        int[][] res2 = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            res2[i] = res.get(i);
        }
        return res2;

    }


    public static void main(String[] args) {
        int[][] nums = new int[3][2];
        nums[0] = new int[]{3, 5};
        nums[1] = new int[]{1, 6};
        nums[2] = new int[]{3, 8};
        nums[0] = new int[]{4, 5};
        nums[1] = new int[]{5, 3};
        nums[2] = new int[]{2, 4};
        nums[0] = new int[]{3, 5};
        nums[1] = new int[]{1, 3};
        nums[2] = new int[]{2, 4};
        nums[0] = new int[]{3, 7};
        nums[1] = new int[]{1, 3};
        nums[2] = new int[]{1, 4};
        nums[0] = new int[]{3, 5};
        nums[1] = new int[]{1, 8};
        nums[2] = new int[]{7, 9};
        nums[0] = new int[]{3, 5};
        nums[1] = new int[]{1, 3};
        nums[2] = new int[]{2, 4};


        long a = System.currentTimeMillis();
        for (int i = 0;i<10000;i++){
            Arrays.sort(nums, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        }
        System.out.println(System.currentTimeMillis()-a);
        a = System.currentTimeMillis();

        for (int j = 0;j<10000;j++){
            int[] start = new int[nums.length];
            int[] end = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                start[i] = nums[i][0];
                end[i] = nums[i][1];
            }
            Arrays.sort(start);
            Arrays.sort(end);
        }

        System.out.println(System.currentTimeMillis()-a);



    }


}