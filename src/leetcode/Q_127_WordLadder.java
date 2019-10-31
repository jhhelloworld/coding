package leetcode;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.lang.reflect.Array;
import java.util.*;

/**
 * jh
 * 2019年08月31日  17：49
 * <p>
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 5  "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 */
public class Q_127_WordLadder {

    //思想：BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), visited = new HashSet<>();
        //如果字典中没有endWord，直接返回。
        if (!dict.contains(endWord)) {
            return 0;
        }
        //BFS使用的队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        for (int len = 1; !queue.isEmpty(); len++) {
            //遍历当前层队列---考虑一下为什么不用!queue.isEmpty()
            for (int i = queue.size(); i > 0; i--) {
                String curNode = queue.poll();
                if (curNode.equals(endWord)) {
                    return len;
                }
                //逐步改变curNode的各个位置的字母，查看队列中是否包含距离为1的单词 TODO 待优化
                List<String> neighbors = getNrighbors(curNode, dict);
                for (String neighbor : neighbors) {
                    //防止重复计算，如果是第二次访问该节点，肯定不是最短路径。如果需要输出全部路径，则不能加这个判断
                    if (visited.add(neighbor)) {
                        queue.offer(neighbor);
                    }

                }
            }

        }
        return 0;
    }


    public List<String> getNrighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) {
                    continue;
                }
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }


    //超出时间限制，因为LeetCode测试用例 dict非常多
    private ArrayList<String> getNeighbors2(String node, Set<String> dict) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : dict) {
            if (getInstance2(s, node) == 1) {
                result.add(s);
            }
        }
        return result;
    }


    private int getInstance2(String node, String dict) {
        if (node.length() != dict.length()) {
            return 0;
        }
        int distance = 0;
        for (int i = 0; i < node.length(); i++) {
            if (node.charAt(i) != dict.charAt(i)) {
                distance++;
            }
            if (distance == 2) {
                return 2;
            }
        }
        return distance;
    }


}