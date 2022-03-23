package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * jh
 * 2019年09月05日  16：35
 * <p>
 * 现在你总共有 n 门课需要选，记为0到n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 */
public class Q_207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] incLinkCount = new int[numCourses];
        List<List<Integer>> adjust = new ArrayList<>();
        generateGraph(adjust, prerequisites, incLinkCount);
        return solveByBfs(adjust, incLinkCount);

    }

    /**
     * adjust 存储第 i 结课如果上了，就可以上哪些课
     * incLinkCounnt 存储 第i结课需要依赖的课程的数量
     */

    public void generateGraph(List<List<Integer>> adjust, int[][] prerequisites, int[] incLinkCounnt) {
        int n = incLinkCounnt.length;
        while (n-- > 0) {
            adjust.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int pre = edge[1];
            int next = edge[0];
            incLinkCounnt[next]++;
            adjust.get(pre).add(next);
        }

    }

    /**
     * 通过bfs解决的思路：
     * 1.扫描 incLinkCounnt，数值为0的课次表示不依赖其他课次，加入队列
     * 2.找到队列中adjust 对应的list，list中的课程也可达，把list在 incLinkCounnt 对应的数值减一
     * 如果 减一后等于0，则把这节课也加入队列
     */
    public boolean solveByBfs(List<List<Integer>> adjust, int[] incLinkCounnt) {
        //
        Queue<Integer> queue = new LinkedList<>();
        //记录可上多少节课,记录顺序
        int count = 0;

        for (int i = 0; i < incLinkCounnt.length; i++) {
            if (incLinkCounnt[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            List<Integer> toCourses = adjust.get(course);
            for (int to : toCourses) {
                incLinkCounnt[to]--;
                if (incLinkCounnt[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        return count == incLinkCounnt.length;
    }


}