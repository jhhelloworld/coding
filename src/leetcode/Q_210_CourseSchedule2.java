package leetcode;

import com.sun.tools.javac.util.ListBuffer;
import sun.misc.OSEnvironment;
import util.ListNode;

import java.util.*;

/**
 * jh
 * 2019年09月05日  17：06
 */
public class Q_210_CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
    public int[] solveByBfs(List<List<Integer>> adjust, int[] incLinkCounnt) {
        //
        int[] order = new int[incLinkCounnt.length];
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
            order[count++] = course;
            List<Integer> toCourses = adjust.get(course);
            for (int to : toCourses) {
                incLinkCounnt[to]--;
                if (incLinkCounnt[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        return count == incLinkCounnt.length ? order : new int[0];
    }


    private int[] solveByDFS(List<List<Integer>> adjs) {
        BitSet visited = new BitSet(adjs.size());
        BitSet onStack = new BitSet(adjs.size());
        Deque<Integer> order = new ArrayDeque<>();
        for (int i = adjs.size() - 1; i >= 0; i--) {
            if (!visited.get(i) && !hasOrder(i, adjs, visited, onStack, order)) {
                return new int[0];
            }
        }
        int[] orderArray = new int[adjs.size()];
        for (int i = 0; !order.isEmpty(); i++) {
            orderArray[i] = order.pop();
        }
        return orderArray;
    }

    private boolean hasOrder(int from, List<List<Integer>> adjs, BitSet visited, BitSet onStack, Deque<Integer> order) {
        visited.set(from);
        onStack.set(from);
        for (int to : adjs.get(from)) {
            if (!visited.get(to)) {
                if (!hasOrder(to, adjs, visited, onStack, order)) {
                    return false;
                }
            } else if (onStack.get(to)) {
                return false;
            }
        }
        onStack.clear(from);
        order.push(from);
        return true;
    }
}